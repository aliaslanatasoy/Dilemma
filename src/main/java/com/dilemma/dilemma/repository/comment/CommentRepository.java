package com.dilemma.dilemma.repository.comment;

import com.dilemma.dilemma.entity.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aslan.atasoy on 10/02/2017.
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment,String>, CrudRepository<Comment,String> {
    List<Comment> findByTopicId(String topicId);
}
