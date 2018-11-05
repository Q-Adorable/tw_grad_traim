package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.endpoint;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<JsonNode> healthResponse = restTemplate.getForEntity("http://localhost:8081/actuator/health", JsonNode.class);
            System.out.println(healthResponse);
            JsonNode healthJson = healthResponse.getBody();
            List<JsonNode> status = healthJson.findValues("status");
            long count = status.stream().filter(jsonNode -> jsonNode.asText().contains("DOWN")).count();
            return count == 0 ?
                    Health.up().withDetail("product", "product is ok").build() :
                    Health.down().withDetail("product", "product is not ok").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Health.down().withDetail("product", "product is not ok").build();
        }

    }
}
