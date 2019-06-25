package com.envimate.examples.http;

import com.envimate.httpmate.HttpMate;
import com.envimate.httpmate.convenience.endpoints.PureJavaEndpoint;
import com.envimate.httpmate.convenience.handler.HttpHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.envimate.httpmate.HttpMate.anHttpMateConfiguredAs;
import static com.envimate.httpmate.LowLevelBuilder.LOW_LEVEL;

public final class Application {
    public static void main(String[] args) {
        final HttpHandler httpHandler = (request, response) -> {
            final LocalDateTime time = LocalDateTime.now();
            final String dateFormatted = time.format(DateTimeFormatter.ISO_TIME);

            response.setStatus(200);
            response.setBody("current time is " + dateFormatted);
        };

        final HttpMate httpMate = anHttpMateConfiguredAs(LOW_LEVEL)
                .get("/time", httpHandler)
                .build();
        PureJavaEndpoint.pureJavaEndpointFor(httpMate)
                .listeningOnThePort(1337);
    }
}
