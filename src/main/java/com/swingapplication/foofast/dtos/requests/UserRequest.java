package com.swingapplication.foofast.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "\n  [USER]" + "\n" +
                "       firstName: " + this.firstName + "\n" +
                "       lastName: " + this.lastName + "\n" +
                "       dayOfBirth: " + this.dayOfBirth + "\n" +
                "       username: " + this.username + "\n" +
                "       password: " + this.password + "\n";
    }
}
