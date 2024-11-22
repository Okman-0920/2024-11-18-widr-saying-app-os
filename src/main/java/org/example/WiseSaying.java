package org.example;

public class WiseSaying {
    public int id;
    public String author;
    public String content;


    public WiseSaying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, author=\"%s\", content=\"%s\")".formatted(id, author, content);
    }
}
