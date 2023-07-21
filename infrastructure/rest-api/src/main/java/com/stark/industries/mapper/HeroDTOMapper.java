package com.stark.industries.mapper;

import com.stark.industries.dto.CreateHeroDTO;
import com.stark.industries.dto.GetHeroByIdDTO;
import com.stark.industries.dto.UpdateHeroDTO;
import com.stark.industries.entity.Hero;
import com.stark.industries.port.input.UpdateHeroUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;


@Mapper(componentModel = "spring")
public interface HeroDTOMapper {
    @Mapping(source = "superPowers", target = "super_powers")
    GetHeroByIdDTO heroToGetHeroById(Hero hero);

    @Mapping(source = "super_powers", target = "superPowers")
    Hero createHeroDtoToHero(CreateHeroDTO createHeroDTO);

    default UpdateHeroUseCase.InputValues updateHeroToDtoToInputValues(UUID id, UpdateHeroDTO updateHeroDTO) {
        return UpdateHeroUseCase.InputValues.builder()
                .id(id)
                .name(updateHeroDTO.getName())
                .superPowers(updateHeroDTO.getSuper_powers())
                .build();
    }
}
