package com.stark.industries.repository;

import com.stark.industries.entity.Hero;
import com.stark.industries.mapper.DBHeroMapper;
import com.stark.industries.port.output.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DBHeroRepository implements HeroRepository {
    private final SpringDataHeroRepository repository;
    private final DBHeroMapper mapper;

    @Override
    public Hero save(Hero hero) {
        return mapper.toDomainEntity(repository.save(mapper.toDBDocument(hero)));
    }

    @Override
    public List<Hero> getAll() {
        return repository.findAll().stream().map(mapper::toDomainEntity).toList();
    }

    @Override
    public Optional<Hero> getById(UUID id) {
        return repository.findById(id.toString()).map(mapper::toDomainEntity);
    }
}
