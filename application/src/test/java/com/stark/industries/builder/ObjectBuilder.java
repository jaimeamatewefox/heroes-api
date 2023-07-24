package com.stark.industries.builder;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.UpdateHeroUseCase;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class ObjectBuilder {

    public static Hero buildDomainHero() {
        return Hero.builder().id(UUID.randomUUID()).name("superman").superPowers(new HashSet<>(List.of("Strength"))).build();
    }

    public static UpdateHeroUseCase.InputValues buildUpdateHeroInputValues() {
        return UpdateHeroUseCase.InputValues.builder().id(UUID.randomUUID()).name("superman").superPowers(new HashSet<>(List.of("Strength"))).build();
    }
}
