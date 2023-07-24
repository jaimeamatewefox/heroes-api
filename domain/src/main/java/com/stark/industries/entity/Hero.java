package com.stark.industries.entity;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Hero {
    private UUID id;
    private String name;
    private Set<String> superPowers;

    public Hero(String name, Set<String> superPowers) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.superPowers = superPowers;
    }
}
