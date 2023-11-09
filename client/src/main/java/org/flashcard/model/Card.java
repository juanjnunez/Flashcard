package org.flashcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {
    private int id;
    private String question;
    private String answer;
    @JsonProperty("tag_id")
    private int tagId;

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    //Constructor
    public Card() {
    }

    public Card(int id, String question, String answer, int tagId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.tagId = tagId;
    }

    //To String
    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", tagId=" + tagId +
                '}';
    }
}
