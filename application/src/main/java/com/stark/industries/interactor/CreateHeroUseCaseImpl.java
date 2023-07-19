package com.stark.industries.interactor;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.CreateHeroUseCase;
import com.stark.industries.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CreateHeroUseCaseImpl implements CreateHeroUseCase {
    private final HeroService service;

    @Override
    public Hero execute(@Valid Hero input) {
        return service.save(input);
    }
}
