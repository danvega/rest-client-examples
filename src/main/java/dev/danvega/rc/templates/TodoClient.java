package dev.danvega.rc.templates;

import org.springframework.web.client.RestClient;

public class TodoClient {

    private final RestClient restClient;

    public TodoClient(RestClient.Builder builder) {
        this.restClient = builder.build();

    }

}
