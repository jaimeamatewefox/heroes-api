package com.stark.industries.enums;

import com.wefox.server.lib.common.core.exception.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorDetailsEnum implements ErrorMessage {
    HERO_NOT_FOUND("HERO_NOT_FOUND", "Hero not found");

    private final String code;
    private final String message;
}
