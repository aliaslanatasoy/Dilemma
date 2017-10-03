package com.dilemma.dilemma.controller.comment;

import com.dilemma.dilemma.entity.comment.Comment;
import com.dilemma.dilemma.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aslan.atasoy on 10/02/2017.
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getCommentsByTopic(@RequestParam(value = "topicId") String topicId) {
        return new ResponseEntity<>(commentService.getCommentsByTopicId(topicId), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getCommentByCommentId(@RequestParam(value = "commentId") String commentId) {
        return commentService.getComment(commentId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> deletComment(@RequestBody Comment comment){
        return commentService.deleteComment(comment);
    }

}
