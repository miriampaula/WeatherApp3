package com.dev.course.entity;

public class Person {
    private final String name;
    private final String surname;

    private Person(final String name, final String surname) {

        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();

        if (name != null) {
            builder.append(name);
            if (surname != null) {
                builder.append(" ");
                builder.append(surname);
            }
        } else if (surname != null) {
            builder.append(surname);
        }

        return builder.toString();
    }
}
