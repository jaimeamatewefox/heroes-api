package com.stark.industries.repository;

import com.stark.industries.document.HeroDBDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataHeroRepository extends MongoRepository<HeroDBDocument, String> { }
