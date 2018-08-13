package com.dojo.madness.controller;


import com.dojo.madness.model.AbilityResponse;
import com.dojo.madness.service.AbilityService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/abilities")
public class AbilityController {

    private AbilityService abilityService;

    @Autowired
    public AbilityController(final AbilityService abilityService){
        this.abilityService = abilityService;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<AbilityResponse> list() {
        return abilityService.list();
    }

    @RequestMapping(value = "/{ability_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AbilityResponse getById(@PathVariable(value = "ability_id") @NonNull final Integer abilityId) {
        return abilityService.findById(abilityId);
    }

    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean syncHeroes() {
        return abilityService.syncData();
    }

}

