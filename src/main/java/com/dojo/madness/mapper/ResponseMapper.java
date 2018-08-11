package com.dojo.madness.mapper;

import com.dojo.madness.entity.Ability;
import com.dojo.madness.entity.Hero;
import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.model.HeroResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public AbilityResponse mapAbilityResponse(@NonNull final Ability ability) {
        return AbilityResponse.builder()
                .id(ability.getId())
                .name(ability.getName())
                .description(ability.getDescription())
                .isUltimate(ability.getIsUltimate())
                .hero(mapHeroResponse(ability.getHero()))
                .build();

    }

    public HeroResponse mapHeroResponse(@NonNull final Hero hero) {
        return HeroResponse.builder()
                .id(hero.getId())
                .name(hero.getName())
                .realName(hero.getRealName())
                .health(hero.getHealth())
                .armour(hero.getArmour())
                .shield(hero.getShield())
                .build();

    }
}
