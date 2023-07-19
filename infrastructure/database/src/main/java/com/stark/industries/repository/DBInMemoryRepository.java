package com.stark.industries.repository;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.output.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DBInMemoryRepository implements HeroRepository {
    private final List<Hero> heroesList = new ArrayList<>();

    @Override
    public Hero save(Hero hero) {
        heroesList.add(hero);

        return hero;
    }

    @Override
    public List<Hero> getAll() {
        return heroesList;
    }

    @Override
    public Optional<Hero> getById(UUID id) {
        return heroesList.stream()
                .filter(hero -> id.equals(hero.getId()))
                .findAny();
    }
}
