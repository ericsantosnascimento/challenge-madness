package com.dojo.madness.client;

import com.dojo.madness.client.model.OverwatchApiResponse;
import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.model.HeroResponse;
import feign.FeignException;
import feign.Headers;
import feign.RequestLine;

/**
 * Overwatch client Api, connects to overwatch api
 * <p>
 */
@Headers("Content-Type: application/json")
public interface OverwatchApiClient {

    @RequestLine("GET /api/v1/hero/")
    OverwatchApiResponse<HeroResponse> getHeroes() throws FeignException;

    @RequestLine("GET /api/v1/ability/")
    OverwatchApiResponse<AbilityResponse> getAbilities() throws FeignException;


}