package dev.danvega.rc.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.rc.post.Post;
import dev.danvega.rc.post.PostClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(PostClient.class)
class PostClientTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    PostClient postClient;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllPosts() throws JsonProcessingException {
        // given
        List<Post> data = List.of(
                new Post(1, 1, "Hello, World!", "This is my first post!"),
                new Post(2, 1, "Testing Rest Client with @RestClientTest", "This is a post about testing RestClient calls")
        );

        // when
        this.server
                .expect(requestTo("https://jsonplaceholder.typicode.com/posts"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(data), MediaType.APPLICATION_JSON));

        // then
        List<Post> posts = postClient.findAll();
        assertThat(posts.size()).isEqualTo(2);
    }

}

