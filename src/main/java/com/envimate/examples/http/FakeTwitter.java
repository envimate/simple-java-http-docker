package com.envimate.examples.http;

import com.envimate.httpmate.HttpMate;
import com.envimate.httpmate.convenience.endpoints.PureJavaEndpoint;

import static com.envimate.httpmate.http.HttpRequestMethod.*;

public final class FakeTwitter {
    public static void main(String[] args) {
        final HttpMate httpMate = HttpMate.aLowLevelHttpMate()
                .callingTheHandler(System.out::println)
                .forRequestPath("/*").andRequestMethods(GET, POST, PUT)
                .build();

        PureJavaEndpoint.pureJavaEndpointFor(httpMate).listeningOnThePort(1337);
    }
}
