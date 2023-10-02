package com.example.datadogtest;

import com.datadog.api.client.ApiClient;
import com.datadog.api.client.ApiException;
import com.datadog.api.client.v1.api.EventsApi;
import com.datadog.api.client.v1.model.EventListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;


@SpringBootApplication
public class DatadogTestApplication {

    public static void main(String[] args) {

        /*RestTemplate restTemplate = new RestTemplate();

        String apiKey = "63c80f7e8045c89b8c27275ea66b7994";
        String appKey = "a72a56b2db150bfb0314e587d4d8886bbc89ff21";

        String url = "https://api.datadoghq.eu/api/v1/events";


        Instant start = Instant.now().minus(1, ChronoUnit.DAYS);
        Instant end = Instant.now();
        String queryString = String.format("?start=%s&end=%s", start.getEpochSecond(), end.getEpochSecond());


        HttpHeaders eventHeaders = new HttpHeaders();
        eventHeaders.set("DD-API-KEY", apiKey);
        eventHeaders.set("DD-APPLICATION-KEY", appKey);

        HttpEntity<String> entity = new HttpEntity<>(null, eventHeaders);
        String response = restTemplate.exchange(url + queryString, HttpMethod.GET, entity, String.class).getBody();

        System.out.println(response);

        String apiUrl = "https://api.datadoghq.eu/api/v2/logs/events";

        String monitorUrl = apiUrl + "?api_key=" + apiKey + "&application_key=" + appKey;
        int pageSize = 20;

        HttpHeaders headers = new HttpHeaders();
        headers.set("page_size", String.valueOf(pageSize));


        try {
            URI uri = new URI(monitorUrl);
            RequestEntity<Void> requestEntity = RequestEntity.get(uri).headers(headers).build();

            RestTemplate restTemplateMonitor = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplateMonitor.exchange(requestEntity, String.class);
            String responseBody = responseEntity.getBody();
            System.out.println(responseBody);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);

            String message = rootNode.path("message").asText();

            System.out.println("Message: " + message);



        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/

        Long monitorId = 10159692L;
        String apiKey = "1b6e08cbea7dcf43fe5e1a6f67257c2d";
        String appKey = "8c91264542f6633eb70ead0a786067d2375053ec";

        String endpoint = "https://api.datadoghq.eu/api/v1/events";

        Long start = 1676873726L;
        Long end = 1677830093L;
        String priority = "normal";
        String tags = "monitor_id:" + monitorId.toString();

        // Authorization header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("DD-API-KEY", apiKey);
        headers.set("DD-APPLICATION-KEY", appKey);

        String url = endpoint + "?start=" + start + "&end=" + end  + "&tags=" + tags;
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println(responseEntity.getBody());
        } else {
            System.out.println("Hata: " + responseEntity.getStatusCode());
        }


    }

}
