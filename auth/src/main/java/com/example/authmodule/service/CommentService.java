package com.example.authmodule.service;

import com.example.authmodule.model.Comment;
import com.example.authmodule.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("CommentService")
public class CommentService {
    private CommentRepository cmRepository;

    @Autowired
    public CommentService(CommentRepository cmRepository) { this.cmRepository = cmRepository; }

    public String add(Comment comment) {
        boolean result = false;
        try {
            result = this.cmRepository.addCm(comment);
        } catch (Exception e) {
            e.getMessage();
        }
        return result ? "The comment is added successfully" : "Oops. Something went wrong";

    }


    public ArrayList<Comment> getAll(long bookId) {

        ArrayList<Comment> cms = null;
        try {
            cms = this.cmRepository.getAllCms(bookId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (cms);
    }
}
