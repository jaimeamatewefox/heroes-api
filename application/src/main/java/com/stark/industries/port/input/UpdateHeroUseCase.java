package com.stark.industries.port.input;

import com.stark.industries.entity.Hero;
import com.wefox.server.lib.common.core.application.UseCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public interface UpdateHeroUseCase extends UseCase<UpdateHeroUseCase.InputValues, Hero> {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class InputValues {

        @NotNull
        private UUID id;
        @NotNull
        private String name;
        @NotNull
        private Set<String> superPowers;
    }
}
