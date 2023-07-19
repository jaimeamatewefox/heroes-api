package com.stark.industries.interactor;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.GetHeroesUseCase;
import com.stark.industries.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetHeroesUseCaseImpl  implements GetHeroesUseCase {
    private final HeroService heroService;

    @Override
    public List<Hero> execute(Void input) {
        return heroService.getAll();
    }
}
