package com.stark.industries.interactor;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.GetHeroByIdUseCase;
import com.stark.industries.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetHeroByIdUseCaseImpl implements GetHeroByIdUseCase {
    private final HeroService heroService;

    @Override
    public Hero execute(UUID id) {
        return heroService.getById(id);
    }
}
