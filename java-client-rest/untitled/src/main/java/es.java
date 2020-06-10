import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.*;

import java.io.IOException;


public class es {

    private final RestHighLevelClient client;

    public RestHighLevelClient getClient() {
        return client;
    }

    
    public es() {
        final CredentialsProvider credentialsProvider =
                new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("admin", "admin"));

        HttpHost host = new HttpHost("10.3.48.54", 9200, "http");

        RestClientBuilder builder = RestClient.builder(host);
        builder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                .setMaxConnPerRoute(1)
                .setMaxConnTotal(1).setDefaultCredentialsProvider(credentialsProvider)
        );
        builder.setRequestConfigCallback(
                requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(5000)
                        .setSocketTimeout(60000)
        );
        this.client = new RestHighLevelClient(builder);
    }

    public static void main(String[] args) throws IOException {
        es client = new es();
        String query = "{\n" +
                "  \"index_patterns\": [\n" +
                "    \"kingcub-comment*\"\n" +
                "  ],\n" +
                "  \"settings\": {\n" +
                "    \"number_of_shards\": 5,\n" +
                "    \"number_of_replicas\": 1\n" +
                "  },\n" +
                "  \"mappings\": {\n" +
                "    \"_source\": {\n" +
                "      \"enabled\": true\n" +
                "    },\n" +
                "    \"properties\": {\n" +
                "      \"approvedAt\": {\n" +
                "        \"type\": \"long\"\n" +
                "      },\n" +
                "      \"approvedBy\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"commentID\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"content\": {\n" +
                "        \"properties\": {\n" +
                "          \"extension\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"media\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"text\": {\n" +
                "            \"type\": \"text\"\n" +
                "          },\n" +
                "          \"timestamp\": {\n" +
                "            \"type\": \"long\"\n" +
                "          },\n" +
                "          \"userID\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"createdAt\": {\n" +
                "        \"type\": \"long\"\n" +
                "      },\n" +
                "      \"createdBy\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"cursor\": {\n" +
                "        \"type\": \"long\"\n" +
                "      },\n" +
                "      \"date\": {\n" +
                "        \"type\": \"date\"\n" +
                "      },\n" +
                "      \"deleted\": {\n" +
                "        \"type\": \"boolean\"\n" +
                "      },\n" +
                "      \"labels\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"mediaID\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"parentCommentID\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"post\": {\n" +
                "        \"properties\": {\n" +
                "          \"card_info\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"card_type\": {\n" +
                "            \"type\": \"long\"\n" +
                "          },\n" +
                "          \"extension\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"id\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          },\n" +
                "          \"media_id\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          },\n" +
                "          \"title\": {\n" +
                "            \"type\": \"text\"\n" +
                "          },\n" +
                "          \"user\": {\n" +
                "            \"properties\": {\n" +
                "              \"avatar\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "              },\n" +
                "              \"full_name\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "              },\n" +
                "              \"id\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "              },\n" +
                "              \"isPage\": {\n" +
                "                \"type\": \"boolean\"\n" +
                "              },\n" +
                "              \"user_name\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "              },\n" +
                "              \"verifyAccount\": {\n" +
                "                \"type\": \"boolean\"\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"updatedAt\": {\n" +
                "        \"type\": \"long\"\n" +
                "      },\n" +
                "      \"updatedBy\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"waitingContent\": {\n" +
                "        \"properties\": {\n" +
                "          \"extension\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"media\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"text\": {\n" +
                "            \"type\": \"text\"\n" +
                "          },\n" +
                "          \"timestamp\": {\n" +
                "            \"type\": \"long\"\n" +
                "          },\n" +
                "          \"userID\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"waitingLabels\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"waitingLog\": {\n" +
                "        \"properties\": {\n" +
                "          \"commentID\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          },\n" +
                "          \"logID\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          },\n" +
                "          \"payload\": {\n" +
                "            \"enabled\": false\n" +
                "          },\n" +
                "          \"timestamp\": {\n" +
                "            \"type\": \"long\"\n" +
                "          },\n" +
                "          \"type\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          },\n" +
                "          \"userID\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Request request = new Request("PUT", "/_template/kingcub-comment");
        HttpEntity stringEntity = new StringEntity(query, ContentType.APPLICATION_JSON);
        request.setEntity(stringEntity);


        System.out.println(client.getClient().getLowLevelClient().performRequest(request).getStatusLine().getStatusCode());

    }
}
