package com.stark.industries.port.input.mapper;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.UpdateHeroUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroMapper {
    Hero toDomainEntity(UpdateHeroUseCase.InputValues inputValues);
}
