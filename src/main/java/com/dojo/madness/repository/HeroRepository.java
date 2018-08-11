package com.dojo.madness.repository;

import com.dojo.madness.entity.Hero;
import org.springframework.data.repository.CrudRepository;

/**
 * Access layer for database queries for the {@link Hero}
 */
public interface HeroRepository extends CrudRepository<Hero, Integer> {


}
