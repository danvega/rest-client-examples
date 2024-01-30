package dev.danvega.rc.interceptors;

import org.springframework.web.client.RestClient;

public class OAuth2Client {

    private final RestClient restClient;

    // https://github.com/spring-projects/spring-security/issues/13588#issuecomment-1881627223
    public OAuth2Client(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

}
