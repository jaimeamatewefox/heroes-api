package com.stark.industries.port.input;

import com.stark.industries.entity.Hero;
import com.wefox.server.lib.common.core.application.UseCase;

import java.util.UUID;

public interface GetHeroByIdUseCase extends UseCase<UUID, Hero> {}
