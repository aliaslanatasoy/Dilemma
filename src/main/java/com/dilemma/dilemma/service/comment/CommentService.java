package com.dilemma.dilemma.service.comment;

import com.dilemma.dilemma.entity.comment.Comment;
import com.dilemma.dilemma.repository.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aslan.atasoy on 10/02/2017.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByTopicId(String topicId) {
        List<Comment> comments = commentRepository.findByTopicId(topicId);
        return comments;
    }

    public ResponseEntity<Comment> getComment(String commentId) {
        Comment comment = commentRepository.findOne(commentId);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Comment> addComment(Comment comment) {
        Comment addedComment = commentRepository.save(comment);
        if (addedComment != null) {
            return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Comment> updateComment(Comment comment) {
        Comment retrievedComment = commentRepository.findOne(comment.getCommentId());
        if (retrievedComment != null) {
            retrievedComment = comment;
            return new ResponseEntity<>(commentRepository.save(retrievedComment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Comment> deleteComment(Comment comment) {
        Comment retrievedComment = commentRepository.findOne(comment.getCommentId());
        if(retrievedComment != null){
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
    }
}
