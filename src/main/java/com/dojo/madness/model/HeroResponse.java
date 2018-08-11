package com.dojo.madness.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HeroResponse {

    private Integer id;
    private String name;
    private String realName;
    private Integer health;
    private Integer armour;
    private Integer shield;

    @JsonCreator
    private HeroResponse(@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("real_name") String realName,
                        @JsonProperty("health") Integer health,
                        @JsonProperty("armour") Integer armour,
                        @JsonProperty("shield") Integer shield) {
        this.id = id;
        this.name = name;
        this.realName = realName;
        this.health = health;
        this.armour = armour;
        this.shield = shield;
    }

}
