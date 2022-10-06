package com.etstour.hotelbooking.temp;

import com.etstour.hotelbooking.validation.FieldMatch;
import com.etstour.hotelbooking.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password",second = "matchingPassword",message = "The password field must match")
})
public class CurrentUser {
    // temp class to filter data and get it from controller to database using services
    // currentuser fields and annotate to get the required data

    @NotNull(message = "is required ")
    @Size(min = 1,message = "is required")
    private String username;

    @NotNull(message = "is required ")
    @Size(min = 1,message = "is required")
    private String password;

    @NotNull(message = "is required ")
    @Size(min = 1,message = "is required")
    private String matchinPassword;

    @ValidEmail
    @NotNull(message = "is required ")
    @Size(min = 1,message = "is required")
    private String email;

    public CurrentUser() {
    }

    public CurrentUser(@NotNull(message = "is required ")
                       @Size(min = 1,message = "is required")String username,
                       @NotNull(message = "is required ")
                       @Size(min = 1,message = "is required")String password,
                       @NotNull(message = "is required ")
                       @Size(min = 1,message = "is required")String matchinPassword,
                       @NotNull(message = "is required ")
                       @Size(min = 1,message = "is required")String email) {
        this.username = username;
        this.password = password;
        this.matchinPassword = matchinPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchinPassword() {
        return matchinPassword;
    }

    public void setMatchinPassword(String matchinPassword) {
        this.matchinPassword = matchinPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", matchinPassword='" + matchinPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
