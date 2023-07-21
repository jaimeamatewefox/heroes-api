package com.stark.industries.service;

import com.stark.industries.entity.Hero;
import com.stark.industries.port.output.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository repository;

    public Hero save(Hero hero) {
        return repository.save(hero);
    }

    public Optional<Hero> getById(UUID id) { return repository.getById(id);};

    public List<Hero> getAll() { return repository.getAll();};

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
