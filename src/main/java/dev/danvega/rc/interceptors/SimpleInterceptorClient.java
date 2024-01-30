package dev.danvega.rc.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SimpleInterceptorClient {

    private static final Logger log = LoggerFactory.getLogger(SimpleInterceptorClient.class);
    private final RestClient restClient;
    
    public SimpleInterceptorClient(RestClient.Builder builder, ClientHttpRequestInterceptor myInterceptor) {

        this.restClient =
                builder
                        .baseUrl("https://jsonplaceholder.typicode.com")
                        .requestFactory(new JdkClientHttpRequestFactory())
                        .requestInterceptor(myInterceptor)
//                        .requestInterceptor(((request, body, execution) -> {
//                            log.info("Intercepting request: " + request.getURI());
//                            request.getHeaders().add("x-request-id", "12345");
//                            return execution.execute(request, body);
//                        }))
                        .build();
    }

    public String findAllTodos() {
        return restClient.get()
                .uri("/todos")
                .retrieve()
                .body(String.class);
    }
}
