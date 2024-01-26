# Rest Client Examples

This is a collection of examples using the new `RestClient` in Spring Framework 6.1 & Spring Boot 3.2. 

These are the topics that I would like to cover in this series:

- `RestClient` Instance (org.springframework.web.client) ✅
  - static factory methods
  - DefaultRestClientBuilder
- CRUD
    - List
    - Read
    - Persist
    - Query Params
- Testing with `@RestClientTest` ✅
- HTTP Interfaces
- Switching Http Client Libraries ✅
- Multipart Data
- Jackson JSON Views
- Error Handling
- Interceptors
- Retry (Interceptor)
- Proxy (SimpleClientHttpRequestFactory)
- Spring Cloud MVC
- Resilience
- Live Template ✅

## RestClient Instance

[X Tutorial](https://twitter.com/therealdanvega/status/1750539660886004093)

## Client Request Factories

The `RestClient` uses an underlying Http Client to make calls over HTTP. If you want to read more about this you can check
out the [Spring Documentation](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-request-factories). The 
following video is a walkthrough of how to do that. The code for this is located in `/src/main/resources/dev/danvega/rc/client/JdkClient.java`

[YouTube Tutorial](https://youtu.be/9M0NggD6Mbw)


## Testing with @RestClientTest

You can test your `RestClient` code using the `@RestClientTest` annotation. 

[YouTube Tutorial](https://youtu.be/jhhi03AIin4)

**Note**

If you run into an issue writing tests with `@RestClientTest` and you're using the JDK Http Client you might be running
into this https://github.com/spring-projects/spring-boot/issues/38832 


## Live Templates

[X Tutorial](https://twitter.com/therealdanvega/status/1750560170785054887)