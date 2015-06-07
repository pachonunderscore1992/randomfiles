package org.fabriquita.nucleus.popdb;

import org.fabriquita.nucleus.models.Topic;
import org.fabriquita.nucleus.services.PostService;
import org.fabriquita.nucleus.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostPopDb {

    @Autowired
    PostService postService;

    @Autowired
    TopicService topicService;

    public void popDB() {
        Topic topic1 = topicService.get(1L);
        Topic topic2 = topicService.get(2L);
        postService.add(topic1.getId(), "Javi", "No se olviden hacer la tarea");
        postService.add(topic1.getId(), "Ben", "Hoy es la presentacion del Scrum");
        postService.add(topic2.getId(), "Yama", "Pero es facil");
    }
}
