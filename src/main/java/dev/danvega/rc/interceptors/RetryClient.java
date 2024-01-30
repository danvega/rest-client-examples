package dev.danvega.rc.interceptors;

import am.ik.spring.http.client.RetryableClientHttpRequestInterceptor;
import org.springframework.util.backoff.FixedBackOff;
import org.springframework.web.client.RestClient;

public class RetryClient {

    private final RestClient restClient;

    /*
        Example of a RetryableClientHttpRequestInterceptor with a FixedBackOff
        https://github.com/making/retryable-client-http-request-interceptor
     */
    public RetryClient(RestClient.Builder builder) {
        this.restClient =
                builder
                        .baseUrl("https://jsonplaceholder.typicode.com")
                        .requestInterceptor(new RetryableClientHttpRequestInterceptor(new FixedBackOff(100, 2)))
                        .build();
    }

    public String retry() {
        return restClient.get()
                .uri("/todos")
                .retrieve()
                .body(String.class);
    }

}
