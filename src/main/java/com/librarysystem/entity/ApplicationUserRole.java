package com.librarysystem.entity;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.librarysystem.entity.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER_ROLE(Sets.newHashSet(BRON_BOOK)),
    ADMIN(Sets.newHashSet( MANITORING_BOOK_MANAGMENT,BOOK_ADD)),
    MODERATOR(Sets.newHashSet( MANITORING_BOOK_MANAGMENT,BOOK_ADD,CONTROL));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> collect = getPermissions().stream().map(e -> new SimpleGrantedAuthority(e.getPermission())).collect(Collectors.toSet());
        collect.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return collect;
    }
}
