package com.stark.industries.repository;

import com.stark.industries.document.HeroDBDocument;
import com.stark.industries.entity.Hero;
import com.stark.industries.mapper.DBHeroMapper;
import com.stark.industries.mapper.DBHeroMapperImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class DBHeroRepositoryTest {
    @Spy
    private DBHeroMapper mapper = new DBHeroMapperImpl();

    @Mock
    private SpringDataHeroRepository springDataHeroRepository;

    @InjectMocks
    private DBHeroRepository repository;

    @Test
    void save() {
        when(springDataHeroRepository.findAll(anyList())).thenReturn();
    }


}