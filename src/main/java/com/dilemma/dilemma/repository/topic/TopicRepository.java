package com.dilemma.dilemma.repository.topic;

import com.dilemma.dilemma.entity.topic.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aslan.atasoy on 09/28/2017.
 */
@Repository
public interface TopicRepository extends MongoRepository<Topic,String>,CrudRepository<Topic,String> {
}
