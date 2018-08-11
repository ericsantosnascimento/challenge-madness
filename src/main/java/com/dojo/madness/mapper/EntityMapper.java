package com.dojo.madness.mapper;

import com.dojo.madness.entity.Ability;
import com.dojo.madness.entity.Hero;
import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.model.HeroResponse;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public Hero mapHeroEntityFromResponse(final HeroResponse heroResponse) {
        Hero hero = new Hero();
        hero.setId(heroResponse.getId());
        hero.setName(heroResponse.getName());
        hero.setRealName(heroResponse.getRealName());
        hero.setHealth(heroResponse.getHealth());
        hero.setArmour(heroResponse.getArmour());
        hero.setShield(heroResponse.getShield());
        return hero;
    }

    public Ability mapAbilityEntityFromResponse(final AbilityResponse abilityResponse) {
        Ability ability = new Ability();
        ability.setName(abilityResponse.getName());
        ability.setId(abilityResponse.getId());
        ability.setDescription(abilityResponse.getDescription());
        ability.setIsUltimate(abilityResponse.getIsUltimate());
        ability.setHero(mapHeroEntityFromResponse(abilityResponse.getHero()));
        return ability;
    }
}
