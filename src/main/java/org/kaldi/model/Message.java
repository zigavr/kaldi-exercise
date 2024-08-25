package org.kaldi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Message extends PanacheEntity {

    private String question;

    private String room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_user")
    private MobileUser mobileUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "web_user")
    private WebUser webUser;

    private String reply;

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

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
