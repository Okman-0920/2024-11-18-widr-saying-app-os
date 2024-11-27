package org.example.domain.domain.wiseSaying.entity;

public class WiseSaying {
    private int id;
    private String author;
    private String content;


    public WiseSaying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int setId(int id) { return this.id = id; }

    public String setAuthor(String author) {
        return this.author = author;
    }

    public String setContent(String content) {
        return this.content = content;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, author=\"%s\", content=\"%s\")".formatted(id, author, content);
    }


}
