package org.kaldi.api.model;

public class MessageDTO {
    private String id;
    private String question;
    private String room;
    private String mobileUserDesignation;
    private String answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMobileUserDesignation() {
        return mobileUserDesignation;
    }

    public void setMobileUserDesignation(String mobileUserDesignation) {
        this.mobileUserDesignation = mobileUserDesignation;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
