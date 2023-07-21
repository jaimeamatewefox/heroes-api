package com.stark.industries.interactor;

import com.stark.industries.enums.ErrorDetailsEnum;
import com.stark.industries.port.input.DeleteHeroUseCase;
import com.stark.industries.service.HeroService;
import com.wefox.server.lib.common.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteHeroUseCaseImpl implements DeleteHeroUseCase {
    private final HeroService heroService;

    @Override
    public Void execute(UUID id) {
        heroService.getById(id).orElseThrow(() -> new NotFoundException(ErrorDetailsEnum.HERO_NOT_FOUND));
        heroService.deleteById(id);

        return null;
    }
}
