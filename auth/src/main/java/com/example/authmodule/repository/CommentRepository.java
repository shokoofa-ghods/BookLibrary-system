package com.example.authmodule.repository;

import com.example.authmodule.model.Comment;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentRepository {

    File file;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;
    private String path = "comment.batz";

    public CommentRepository() throws IOException {
        this.file = new File(path);

    }

    public boolean addCm(Comment cm) throws IOException {
        fileOutputStream = new FileOutputStream(this.file, true);
        objectOutputStream = new ObjectOutputStream(this.fileOutputStream);
        this.objectOutputStream.writeObject(cm);
        this.fileOutputStream.close();
        return true;
    }

    public ArrayList<Comment> getAllCms(long bookId) throws IOException, ClassNotFoundException {
        this.fileInputStream = new FileInputStream(this.file);
        ArrayList<Comment> cms = new ArrayList<>();
        try {
            while (true) {
                this.objectInputStream = new ObjectInputStream(this.fileInputStream);
                Object object = this.objectInputStream.readObject();
                if (object == null) {
                    break;
                }
                Comment temp = (Comment) object;
                if (temp.getBid() == bookId)
                    cms.add(temp);
            }
            }catch (EOFException e) {
                System.out.println("end of file");
            }

            this.fileInputStream.close();
            return cms;
    }
}