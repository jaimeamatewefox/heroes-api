package com.stark.industries.mapper;

import com.stark.industries.document.HeroDBDocument;
import com.stark.industries.entity.Hero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DBHeroMapper {
    HeroDBDocument toDBDocument(Hero hero);
    Hero toDomainEntity(HeroDBDocument document);
}
