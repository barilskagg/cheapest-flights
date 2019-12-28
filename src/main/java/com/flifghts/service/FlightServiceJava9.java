package com.flifghts.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class FlightServiceJava9 {

//    https://www.baeldung.com/java-9-http-client
//    Unlike HttpURLConnection, HTTP Client provides synchronous and asynchronous request mechanisms.
//
//    The API consists of 3 core classes:
//
//    HttpRequest – represents the request to be sent via the HttpClient
//    HttpClient – behaves as a container for configuration information common to multiple requests
//    HttpResponse – represents the result of an HttpRequest call

    public static void main(String[] args) throws IOException, InterruptedException {
         final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://wizzair.com/#/booking/select-flight/SOF/LCA/2020-01-17/null/1/0/0/0/null"))
                .timeout(Duration.of(10, SECONDS))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
    }
}
