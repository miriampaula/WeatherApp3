package com.dev.course.route;

import com.dev.course.entity.Person;
import com.dev.course.spark.JsonResponseTransformer;
import com.dev.course.spark.RouteBuilder;
import com.dev.course.service.PersonService;

import spark.Service;

public class PersonRoute implements RouteBuilder {

    @Override
    public void configure(final Service spark, final String basePath) {  
        spark.post(basePath + "/hello",
                "application/json",
                (request, response) -> {
                    return new JsonResponseTransformer().render(
                            PersonService.sayHello(new RequestPayload<>(request, Person.class).get()));
                });
    }

}
