package com.stark.industries.interactor;

import com.stark.industries.builder.ObjectBuilder;
import com.stark.industries.service.HeroService;
import com.wefox.server.lib.common.core.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteHeroUseCaseImplTest {
    @Mock
    private HeroService service;

    @InjectMocks
    private DeleteHeroUseCaseImpl useCase;

    @Test
    void givenHero_whenDeleteById_thenDeleteHero() {
        var foundHero = ObjectBuilder.buildDomainHero();
        when(service.getById(any())).thenReturn(Optional.of(foundHero));

        useCase.execute(UUID.randomUUID());
    }

    @Test
    void givenHero_whenDeleteByid_throwNotFoundException() {
        when(service.getById(any())).thenReturn(Optional.empty());

        Executable executable = () -> useCase.execute(UUID.randomUUID());

        assertThrows(NotFoundException.class, executable);
    }
}