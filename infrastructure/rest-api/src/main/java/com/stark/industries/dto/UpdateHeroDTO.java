package com.stark.industries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHeroDTO {
    @NotNull()
    private String name;
    @NotNull()
    private Set<String> super_powers;
}
