package com.stark.industries.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.stark.industries")
@EnableMongoRepositories("com.stark.industries")
@EnableMongoAuditing
public class InfrastructureDatabaseAutoConfiguration { }
