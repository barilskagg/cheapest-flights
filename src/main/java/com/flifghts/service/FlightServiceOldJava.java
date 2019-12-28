package com.flifghts.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlightServiceOldJava {

    public static void main(String[] args) throws IOException {

//        Until Java 8 Java provided only the HttpURLConnection API – which is low-level and isn't known for being feature-rich and user-friendly
//        Therefore, some widely used third-party libraries were commonly used – such as Apache HttpClient, Jetty, and Spring's RestTemplate.
        URL url = new URL("https://wizzair.com/#/booking/select-flight/SOF/LCA/2020-01-17/null/1/0/0/0/null");


//        Note that this method only creates a connection object, but does not establish the connection yet.
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

//        GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


//        To execute the request we can use the getResponseCode(), connect(), getInputStream() or getOutputStream() methods:
        int status = con.getResponseCode();
        System.out.println("Status: "+status);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        System.out.println("Content: "+content);

        in.close();

        con.disconnect();
    }
}
