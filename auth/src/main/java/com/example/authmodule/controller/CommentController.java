package com.example.authmodule.controller;

import com.example.authmodule.model.Comment;
import com.example.authmodule.service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class CommentController {

    ArrayList<Comment> allComments = new ArrayList<>();
    ArrayList<Comment> comments = new ArrayList<>();
    private CommentService commentService;


    @PostMapping(value = "/get_book/{bookID}/add_cm")
    public String addcm(@RequestBody String content, @RequestParam long bookID) {
        //enter cm : first your name,the content of comment
        String[] input = content.split(",");
        Comment comment = new Comment(input[0], input[1], bookID);
        String response = this.commentService.add(comment);
        return response;
    }

    @GetMapping(value = "/get_book/{bookId}/getAllCm")
    public ArrayList<Comment> getcm(@RequestParam long bookId) {
        comments = commentService.getAll(bookId);
        return comments;
    }
}
