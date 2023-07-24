package com.stark.industries.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("com.stark.industries")
@EnableAsync
public class ApplicationAutoConfiguration { }
