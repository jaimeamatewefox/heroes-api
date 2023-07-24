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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetHeroByIdUseCaseImplTest {
    @Mock
    private HeroService service;

    @InjectMocks
    private GetHeroByIdUseCaseImpl useCase;

    @Test
    void givenId_whenGetById_thenReturnHero() {
        UUID id = UUID.randomUUID();
        var expectedHero = ObjectBuilder.buildDomainHero();

        when(service.getById(id)).thenReturn(Optional.of(expectedHero));
        useCase.execute(id);
    }

    @Test
    void givenNonExistingId_whenFindById_thenThrowNotFoundError() {
        var id = UUID.randomUUID();

        when(service.getById(id)).thenReturn(Optional.empty());

        Executable e = () -> useCase.execute(id);
        var exception = assertThrows(NotFoundException.class, e);
    }
}
