package com.src.init;

import com.src.domain.User;
import com.src.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BootStrap implements ApplicationListener<ApplicationReadyEvent> {

    Logger logger = Logger.getLogger(BootStrap.class.getName());

    private UserService userService;

    public BootStrap(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        if(userService.count()  == 0) {
            User user = new User();
            user.setName("Bhushan Uniyal");
            user = userService.create(user);
            logger.info("User successfully created with Id:"+user.getId());
        }

    }
}
