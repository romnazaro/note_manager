package com.example.doto.domain;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private Integer priority;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String fileName;


    public Note() {

    }

    public Note(String text, Integer priority, User user) {
        this.author = user;
        this.text = text;
        this.priority = priority;
    }

    public String getAuthorName(){
        return author !=null ? author.getUsername() : "<None>";
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        author = author;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
