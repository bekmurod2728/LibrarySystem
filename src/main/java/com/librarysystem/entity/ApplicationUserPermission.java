package com.librarysystem.entity;

public enum ApplicationUserPermission {
    MANITORING_BOOK_MANAGMENT("book:control"),
    BOOK_ADD("book:add"),
    BRON_BOOK("bron:book"),
    CONTROL("app:control");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
