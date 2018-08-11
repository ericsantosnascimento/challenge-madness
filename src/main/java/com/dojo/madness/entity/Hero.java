package com.dojo.madness.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Entity representation for HeroResponse in the database
 */
@Data
@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @Column(name = "hero_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "health")
    private Integer health;

    @Column(name = "armour")
    private Integer armour;

    @Column(name = "shield")
    private Integer shield;

}
