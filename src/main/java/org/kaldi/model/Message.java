package org.kaldi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Message extends PanacheEntity {

    private String question;
    private String room;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mobile_user")
    private MobileUser mobileUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operator_user")
    private OperatorUser operatorUser;
    private String answer;

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

    public OperatorUser getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(OperatorUser operatorUser) {
        this.operatorUser = operatorUser;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
