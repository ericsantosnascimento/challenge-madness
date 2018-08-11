package com.dojo.madness.model;

import com.dojo.madness.entity.Hero;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AbilityResponse {

    private Integer id;
    private String name;
    private String description;
    private Boolean isUltimate;
    private HeroResponse hero;

    @JsonCreator
    private AbilityResponse(@JsonProperty("id") Integer id,
                            @JsonProperty("name") String name,
                            @JsonProperty("description") String description,
                            @JsonProperty("is_ultimate") Boolean isUltimate,
                            @JsonProperty("hero") HeroResponse hero) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUltimate = isUltimate;
        this.hero = hero;
    }
}
