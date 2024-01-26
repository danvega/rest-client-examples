package dev.danvega.rc.client;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

public class JdkClient {

    private final RestClient restClient;

    /*
     An example of how to swap out the underlying http client for another one
     */
    public JdkClient(RestClient.Builder builder) {
        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);

        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .requestFactory(requestFactory)
                .build();
    }
}
