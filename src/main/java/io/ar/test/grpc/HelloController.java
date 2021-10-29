package io.ar.test.grpc;

import helloworld.GreeterGrpc;
import helloworld.HelloRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/hello")
public class HelloController {

    @Inject
    GreeterGrpc.GreeterBlockingStub blockingStub; // <2>

    @Get(produces = MediaType.APPLICATION_JSON)
    public Greeting index() {
        final HelloRequest request = HelloRequest.newBuilder() // <3>
                .setName("Fred")
                .build();

        String message = blockingStub.sayHello(request)
                .getMessage();

        return Greeting.builder()
                .greeting(message)
                .build();
    }
}
