package com.stark.industries.interactor;

import com.stark.industries.builder.ObjectBuilder;
import com.stark.industries.port.input.UpdateHeroUseCase;
import com.stark.industries.port.input.mapper.HeroMapper;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateHeroUseCaseImplTest {
    @Mock
    private HeroService service;

    @Mock
    private HeroMapper mapper;

    @InjectMocks
    private UpdateHeroUseCaseImpl useCase;


    @Test
    void givenHero_WhenUpdate_thenReturnUpdatedHero() {
        var foundHero = ObjectBuilder.buildDomainHero();
        var inputValues = ObjectBuilder.buildUpdateHeroInputValues();

        when(service.getById(any())).thenReturn(Optional.of(foundHero));
        when(service.save(any())).thenReturn(foundHero);

        var result = useCase.execute(inputValues);

        assertNotNull(result);
    }

    @Test
    void givenHero_whenUpdate_thenThrowNotFoundError() {
        when(service.getById(any())).thenReturn(Optional.empty());

        Executable executable = () -> useCase.execute(ObjectBuilder.buildUpdateHeroInputValues());

        assertThrows(NotFoundException.class, executable);
    }
}