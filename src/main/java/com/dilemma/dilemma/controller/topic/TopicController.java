package com.dilemma.dilemma.controller.topic;

import com.dilemma.dilemma.entity.topic.Topic;
import com.dilemma.dilemma.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

/**
 * Created by aslan.atasoy on 09/28/2017.
 */
@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> getTopic(@RequestParam (value = "topicId")String topicId) throws Exception{

        return topicService.getTopic(topicId);
    }

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) throws Exception{
        return topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic){
        return topicService.updateTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> deleteTopic(@RequestBody Topic topic){
        return topicService.deleteTopic(topic);
    }
}
