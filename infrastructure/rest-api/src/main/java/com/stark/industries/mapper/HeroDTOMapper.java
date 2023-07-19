package com.stark.industries.mapper;

import com.stark.industries.dto.CreateHeroDTO;
import com.stark.industries.dto.GetHeroByIdDTO;
import com.stark.industries.entity.Hero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HeroDTOMapper {
    @Mapping(source = "superPowers", target = "super_powers")
    GetHeroByIdDTO heroToGetHeroById(Hero hero);

    @Mapping(source = "super_powers", target = "superPowers")
    Hero createHeroDtoToHero(CreateHeroDTO createHeroDTO);
}
