package com.stark.industries.controller;

import com.stark.industries.dto.CreateHeroDTO;
import com.stark.industries.dto.GetHeroByIdDTO;
import com.stark.industries.entity.Hero;
import com.stark.industries.mapper.HeroDTOMapper;
import com.stark.industries.port.input.CreateHeroUseCase;
import com.stark.industries.port.input.GetHeroByIdUseCase;
import com.stark.industries.port.input.GetHeroesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HeroesController {
    private final CreateHeroUseCase createHeroUseCase;
    private final GetHeroByIdUseCase getHeroByIdUseCase;
    private final GetHeroesUseCase getHeroesUseCase;
    private final HeroDTOMapper heroDTOMapper;

    @PostMapping("heroes")
    ResponseEntity<GetHeroByIdDTO> createHero(@RequestBody CreateHeroDTO createHeroDTO) {
        Hero createdHero = createHeroUseCase.execute(heroDTOMapper.createHeroDtoToHero(createHeroDTO));

        return new ResponseEntity<>(heroDTOMapper.heroToGetHeroById(createdHero), HttpStatus.CREATED);
    }

    @GetMapping("heroes")
    ResponseEntity<List<GetHeroByIdDTO>> getHeroes() {
        List<Hero> heroList = getHeroesUseCase.execute(null);
        List<GetHeroByIdDTO> getHeroByIdDTOS  = heroList.stream().map(heroDTOMapper::heroToGetHeroById).toList();

        return new ResponseEntity<>(getHeroByIdDTOS, HttpStatus.OK);
    }

    @GetMapping("heroes/{id}")
    ResponseEntity<GetHeroByIdDTO> getHeroById(@PathVariable UUID id) {
        Hero hero = getHeroByIdUseCase.execute(id);

        return new ResponseEntity<>(heroDTOMapper.heroToGetHeroById(hero), HttpStatus.OK);
    }
}