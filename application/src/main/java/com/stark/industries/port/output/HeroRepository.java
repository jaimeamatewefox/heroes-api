package com.stark.industries.port.output;

import com.stark.industries.entity.Hero;

import java.util.List;
import java.util.UUID;

public interface HeroRepository {
    Hero save(Hero hero);

    List<Hero> getAll();

    Hero getById(UUID id);
}
