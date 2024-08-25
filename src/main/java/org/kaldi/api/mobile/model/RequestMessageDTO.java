package org.kaldi.api.mobile.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.kaldi.model.MobileUser;

public class RequestMessageDTO {

    private String id;

    @NotEmpty(message = "There was no question sent")
    private String question;

    @NotEmpty(message = "Room missing")
    private String room;

    @NotNull (message = "Mobile user is missing")
    @Valid
    private MobileUser mobileUser;

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

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }
}
