package com.stark.industries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateHeroDTO {
    @NotNull()
    private String name;
    @NotNull()
    private List<String> super_powers;
}
