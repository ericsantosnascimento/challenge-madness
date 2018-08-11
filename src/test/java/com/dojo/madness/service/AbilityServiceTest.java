package com.dojo.madness.service;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@Transactional
public class AbilityServiceTest {

    @Autowired
    private AbilityService abilityService;

    @Test
    public void load_abilities_data_successfully() {
        abilityService.syncData();
        int abilitiesCount = abilityService.list().size();
        Assert.assertThat(abilitiesCount, CoreMatchers.is(16));
    }


}