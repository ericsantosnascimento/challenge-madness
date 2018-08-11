package com.dojo.madness.repository;

import com.dojo.madness.entity.Ability;
import com.dojo.madness.entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Access layer for database queries for the {@link Ability}
 */
public interface AbilityRepository extends CrudRepository<Ability, Integer> {

    List<Ability> findByHero(final Hero hero);
}
