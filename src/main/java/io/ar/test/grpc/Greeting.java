package io.ar.test.grpc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting {
    private String greeting;
}
