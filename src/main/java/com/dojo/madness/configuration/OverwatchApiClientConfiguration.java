package com.dojo.madness.configuration;

import com.dojo.madness.client.OverwatchApiClient;
import com.dojo.madness.factory.OverwatchApiClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OverwatchApiClientConfiguration {

    @Value("${api.endpoint}")
    private String overwatchApiClient;

    @Bean
    public OverwatchApiClient overwatchApiClient() {
        return OverwatchApiClientFactory.factory(overwatchApiClient);
    }

}