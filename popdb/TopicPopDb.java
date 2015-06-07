package org.fabriquita.nucleus.popdb;

import org.fabriquita.nucleus.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TopicPopDb {

    @Autowired
    TopicService topicService;

    public void popDB() {
        topicService.add("Taller de Sistemas");
        topicService.add("Taller de Programacion");
    }
}
