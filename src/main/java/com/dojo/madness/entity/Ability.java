package com.dojo.madness.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

/**
 * Entity representation for AbilityResponse in the database
 */
@Data
@Entity
@Table(name = "ability")
public class Ability {

    @Id
    @Column(name = "ability_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_ultimate")
    private Boolean isUltimate;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
