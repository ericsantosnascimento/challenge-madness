package com.dojo.madness.service;

import com.dojo.madness.client.OverwatchApiClient;
import com.dojo.madness.entity.Ability;
import com.dojo.madness.entity.Hero;
import com.dojo.madness.exception.NotFoundException;
import com.dojo.madness.mapper.EntityMapper;
import com.dojo.madness.mapper.ResponseMapper;
import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.repository.AbilityRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AbilityService {

    private final AbilityRepository abilityRepository;
    private final ResponseMapper responseMapper;
    private final EntityMapper entityMapper;
    private final OverwatchApiClient overwatchApiClient;

    @Autowired
    public AbilityService(final AbilityRepository abilityRepository,
                          final ResponseMapper responseMapper,
                          final EntityMapper entityMapper,
                          final OverwatchApiClient overwatchApiClient) {
        this.abilityRepository = abilityRepository;
        this.responseMapper = responseMapper;
        this.entityMapper = entityMapper;
        this.overwatchApiClient = overwatchApiClient;
    }

    public List<AbilityResponse> list() {
        final List<Ability> heroes = (List<Ability>) abilityRepository.findAll();
        return heroes
                .stream()
                .map(responseMapper::mapAbilityResponse)
                .collect(Collectors.toList());
    }

    public AbilityResponse findById(final Integer heroId) {
        return abilityRepository
                .findById(heroId)
                .map(responseMapper::mapAbilityResponse)
                .orElseThrow(() -> new NotFoundException("Ability not found"));
    }

    public List<AbilityResponse> findByHeroId(final Hero hero) {
        return abilityRepository
                .findByHero(hero)
                .stream()
                .filter(Objects::nonNull)
                .map(responseMapper::mapAbilityResponse)
                .collect(Collectors.toList());
    }

    public boolean syncData() {

        try {

            log.info("Importing Abilities data into database");

            overwatchApiClient.getAbilities().getData().forEach(abilityResponse -> {
                Ability ability = entityMapper.mapAbilityEntityFromResponse(abilityResponse);
                save(ability);
            });

            log.info("Abilities data updated");

            return true;

        } catch (Exception ex) {
            log.error("Error sync heroes data", ex);
            return false;

        }
    }


    public void save(@NonNull final Ability ability) {
        abilityRepository.save(ability);
    }
}
