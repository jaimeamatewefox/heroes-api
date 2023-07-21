package com.stark.industries.interactor;

import com.stark.industries.entity.Hero;
import com.stark.industries.enums.ErrorDetailsEnum;
import com.stark.industries.port.input.mapper.HeroMapper;
import com.stark.industries.port.input.UpdateHeroUseCase;
import com.stark.industries.service.HeroService;
import com.wefox.server.lib.common.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateHeroUseCaseImpl implements UpdateHeroUseCase {
    private final HeroService heroService;
    private final HeroMapper heroMapper;

    @Override
    public Hero execute(InputValues inputValues) {
        heroService.getById(inputValues.getId()).orElseThrow(() -> new NotFoundException(ErrorDetailsEnum.HERO_NOT_FOUND));

        return heroService.save(heroMapper.toDomainEntity(inputValues));
    }
}
