package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class User extends AbstractEntity {
    @NotNull
    private  String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public Boolean isMatchingPassword(String password){
        String candidateHash = encoder.encode(password);
        return candidateHash.equals(pwHash);
    }

}
