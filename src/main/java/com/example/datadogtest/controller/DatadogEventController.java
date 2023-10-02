package com.example.datadogtest.controller;

import com.datadog.api.client.ApiClient;
import com.datadog.api.client.ApiException;
import com.datadog.api.client.v1.api.EventsApi;
import com.datadog.api.client.v1.model.EventListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatadogEventController {

   /* @GetMapping("/events/{monitorId}")
    public EventListResponse getEventsByMonitorId(@PathVariable String monitorId) throws ApiException {
        ApiClient defaultClient = ApiClient.getDefaultApiClient();
        EventsApi apiInstance = new EventsApi(defaultClient);
        String apiKey = System.getProperty("");
        String applicationKey = System.getProperty("");

        EventListResponse allEventsResponse = apiInstance.listEvents(0L, 1677354L)
                .withApiKey(apiKey)
                .withApplicationKey(applicationKey)
                .execute();

        EventListResponse filteredEventsResponse = apiInstance.listEvents( 0L, 1677830093L)
                .withApiKey(apiKey)
                .withApplicationKey(applicationKey)
                .withMonitorId(monitorId)
                .execute();
        return filteredEventsResponse;
    }*/
}
