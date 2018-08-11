package com.dojo.madness.service;

import com.dojo.madness.client.OverwatchApiClient;
import com.dojo.madness.entity.Hero;
import com.dojo.madness.exception.NotFoundException;
import com.dojo.madness.mapper.EntityMapper;
import com.dojo.madness.mapper.ResponseMapper;
import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.model.HeroResponse;
import com.dojo.madness.repository.HeroRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HeroService {

    private final HeroRepository heroRepository;
    private final ResponseMapper responseMapper;
    private final EntityMapper entityMapper;
    private final AbilityService abilityService;
    private final OverwatchApiClient overwatchApiClient;

    @Autowired
    public HeroService(final HeroRepository heroRepository,
                       final ResponseMapper responseMapper,
                       final EntityMapper entityMapper,
                       final AbilityService abilityService,
                       final OverwatchApiClient overwatchApiClient) {
        this.heroRepository = heroRepository;
        this.responseMapper = responseMapper;
        this.entityMapper = entityMapper;
        this.abilityService = abilityService;
        this.overwatchApiClient = overwatchApiClient;
    }

    public List<HeroResponse> list() {
        final List<Hero> heroes = (List<Hero>) heroRepository.findAll();
        return heroes
                .stream()
                .map(responseMapper::mapHeroResponse)
                .collect(Collectors.toList());
    }

    public HeroResponse findById(final Integer heroId) {
        return heroRepository
                .findById(heroId)
                .map(responseMapper::mapHeroResponse)
                .orElseThrow(() -> new NotFoundException("Hero not found"));
    }

    public List<AbilityResponse> findAbilitiesByHeroId(final Integer heroId) {
        return heroRepository
                .findById(heroId)
                .map(abilityService::findByHeroId)
                .orElse(Collections.emptyList());
    }

    public boolean syncData(){

        try {
            log.info("Importing Heroes data into database");

            overwatchApiClient.getHeroes().getData().forEach(heroResponse -> {
                Hero hero = entityMapper.mapHeroEntityFromResponse(heroResponse);
                save(hero);
            });

            log.info("Heroes data updated");

            return true;

        } catch (Exception ex) {
            log.error("Error sync heroes data", ex);
            return false;
        }
    }

    public void save(@NonNull final Hero hero){
        heroRepository.save(hero);
    }



}
