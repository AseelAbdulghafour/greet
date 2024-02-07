package com.letcode.SecureBankSystem.entity;


import javax.persistence.*;


@Entity
@Table(name = "user_settings")
public class UserSettingsEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean recieveNewletter;

    private String preferredLanguage;



    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRecieveNewletter() {
        return recieveNewletter;
    }

    public void setRecieveNewletter(boolean recieveNewletter) {
        this.recieveNewletter = recieveNewletter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}

