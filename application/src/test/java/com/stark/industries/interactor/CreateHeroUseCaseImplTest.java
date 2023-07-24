package com.stark.industries.interactor;


import com.stark.industries.builder.ObjectBuilder;
import com.stark.industries.service.HeroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateHeroUseCaseImplTest {
    @Mock
    private HeroService service;

    @InjectMocks
    private CreateHeroUseCaseImpl useCase;

    @Test
    void givenHero_whenSave_thenReturnSavedHero() {
        var hero = ObjectBuilder.buildDomainHero();

        when(service.save(hero)).thenReturn(hero);

        var result = useCase.execute(hero);

        assertEquals(result, hero);
    }
}