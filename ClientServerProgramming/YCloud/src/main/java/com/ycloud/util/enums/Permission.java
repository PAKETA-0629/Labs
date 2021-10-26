package com.ycloud.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  Permission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write");

    private final String permission;
}
