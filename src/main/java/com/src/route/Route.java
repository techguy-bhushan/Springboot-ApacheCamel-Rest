package com.src.route;

import com.src.domain.User;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "User API").apiProperty("api.version", "1.0.0")
                .apiProperty("cors", "true");


        onException(RuntimeException.class)
                .maximumRedeliveries(1)
                .retryAttemptedLogLevel(LoggingLevel.WARN)
                .backOffMultiplier(5)
                .maximumRedeliveryDelay(60000)
                .useExponentialBackOff();


        rest("/users").description("User REST service")
                .consumes("application/json")
                .produces("application/json")

                .get().description("Find all users").outType(User[].class)
                .responseMessage().code(200).message("All users successfully returned").endResponseMessage()
                .route()
                .to("bean:userService?method=findUsers")
                .endRest()

                .get("/{id}").description("Find user by ID")
                .outType(User.class)
                .param().name("id").type(RestParamType.path).description("The ID of the user").dataType("integer").endParam()
                .responseMessage().code(200).message("User successfully returned").endResponseMessage()
                .route()
                .to("bean:userService?method=findUser(${header.id})")
                .endRest()

                .post().description("Create a user").type(User.class)
                .param().name("body").type(RestParamType.body).description("The user to create").endParam()
                .responseMessage().code(204).message("User successfully created").endResponseMessage()
                .to("bean:userService?method=create")

                .put("/{id}").description("Update a user").type(User.class)
                .param().name("id").type(RestParamType.path).description("The ID of the user to update").dataType("integer").endParam()
                .param().name("body").type(RestParamType.body).description("The user to update").endParam()
                .responseMessage().code(204).message("User successfully updated").endResponseMessage()
                .to("bean:userService?method=updateUser")

                .delete("/{id}").description("Delete user by ID")
                .outType(User.class)
                .param().name("id").type(RestParamType.path).description("The ID of the user").dataType("integer").endParam()
                .responseMessage().code(200).message("User successfully deleted").endResponseMessage()
                .to("bean:userService?method=delete(${header.id})");

    }
}
