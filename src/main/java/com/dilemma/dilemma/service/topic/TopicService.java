package com.dilemma.dilemma.service.topic;

import com.dilemma.dilemma.common.CommonFault;
import com.dilemma.dilemma.entity.topic.Topic;
import com.dilemma.dilemma.repository.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by aslan.atasoy on 09/28/2017.
 */
@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public ResponseEntity<Topic> getTopic(String topicId) throws Exception{
        Topic topic = topicRepository.findOne(topicId);
        if(topic != null){
            return new ResponseEntity<Topic>(topic, HttpStatus.FOUND);
        }else{

            return new ResponseEntity<Topic>(topic,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Topic> addTopic(Topic topic) throws Exception{
        try{

            return new ResponseEntity<Topic>(topicRepository.save(topic),HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<Topic>(topic,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Topic> updateTopic(Topic topic) {
        Topic retrievedTopic = topicRepository.findOne(topic.getTopicId());

        if(retrievedTopic != null) {
            return new ResponseEntity<Topic>(topicRepository.save(topic), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Topic>(topic, HttpStatus.NOT_FOUND);
        }
    }
}
