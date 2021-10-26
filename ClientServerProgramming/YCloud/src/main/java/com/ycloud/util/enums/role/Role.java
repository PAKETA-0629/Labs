package com.ycloud.util.enums.role;

import com.ycloud.util.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Role {
    CLIENT(new HashSet<>(Arrays.asList(Permission.CLIENT_READ,Permission.CLIENT_WRITE))),
    ADMIN(new HashSet<>(Arrays.asList(Permission.CLIENT_READ,Permission.CLIENT_WRITE))),
    MASTER(new HashSet<>(Arrays.asList(Permission.CLIENT_READ,Permission.CLIENT_WRITE)));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
