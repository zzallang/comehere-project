package com.bitcamp.testproject.vo;

public class Health {

    private String title;
    private String writer;
    private String content;


    @Override
    public String toString() {
        return "Health{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
