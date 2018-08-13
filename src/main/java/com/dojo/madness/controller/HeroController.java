package com.dojo.madness.controller;

import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.model.HeroResponse;
import com.dojo.madness.service.HeroService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/heroes")
public class HeroController {

    private HeroService heroService;

    @Autowired
    public HeroController(final HeroService heroService){
        this.heroService = heroService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<HeroResponse> list() {
        return heroService.list();
    }

    @RequestMapping(value = "{hero_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HeroResponse getById(@PathVariable(value = "hero_id") @NonNull final Integer heroId) {
        return heroService.findById(heroId);
    }

    @RequestMapping(value = "/{hero_id}/abilities", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<AbilityResponse> getHeroAbilities(@PathVariable(value = "hero_id") @NonNull final Integer heroId) {
        return heroService.findAbilitiesByHeroId(heroId);
    }

    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean syncHeroes() {
        return heroService.syncData();
    }


}

