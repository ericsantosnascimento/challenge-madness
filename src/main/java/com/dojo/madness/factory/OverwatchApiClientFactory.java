package com.dojo.madness.factory;

import com.dojo.madness.client.OverwatchApiClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.NonNull;

public class OverwatchApiClientFactory {

    /**
     * build OverwatchApiClientinstance
     *
     * @param endpoint the endpoint to connect to the server
     * @return OverwatchApiClientinstance instance
     */
    public static OverwatchApiClient factory(final @NonNull String endpoint) {

        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(new OkHttpClient())
                .target(OverwatchApiClient.class, endpoint);
    }

}