package com.dev.course.service;

import com.dev.course.entity.Person;

public class PersonService {

    public static Object sayHello(final Person person) {
        return "Hey " + person;
    }
}
