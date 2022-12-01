package com.example.note.Entity.Users;

public enum Permission {
    READ("user"),
    All("all");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
