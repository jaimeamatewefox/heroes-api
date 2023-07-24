package com.stark.industries.interactor;

import com.stark.industries.builder.ObjectBuilder;
import com.stark.industries.entity.Hero;
import com.stark.industries.service.HeroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetHeroesUseCaseImplTest {
    @Mock
    private HeroService service;

    @InjectMocks
    private GetHeroesUseCaseImpl useCase;

    @Test
    void givenHeroList_whenGetAll_thenReturnHeroList() {
        var heroList = Arrays.asList(ObjectBuilder.buildDomainHero(), ObjectBuilder.buildDomainHero());

        when(service.getAll()).thenReturn(heroList);

        var result = useCase.execute(null);

        assertTrue(result.containsAll(heroList));
    }

}