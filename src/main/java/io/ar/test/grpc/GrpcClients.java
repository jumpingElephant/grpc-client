package io.ar.test.grpc;

import helloworld.GreeterGrpc;
import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Singleton;

@Factory
class GrpcClients {

    @Singleton
    GreeterGrpc.GreeterStub reactiveStub(@GrpcChannel("greeter") ManagedChannel channel) {
        return GreeterGrpc.newStub(channel);
    }

    @Singleton
    GreeterGrpc.GreeterBlockingStub blockingStub(@GrpcChannel("greeter") ManagedChannel channel) {
        return GreeterGrpc.newBlockingStub(channel);
    }
}
