package com.home.english.dao;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    final String name;

    Role(String name) {
        this.name = name;
    }
}
