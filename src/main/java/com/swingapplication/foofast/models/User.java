package com.swingapplication.foofast.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "\n  [USER]" + "\n" +
                "       id: " + this.id + "\n" +
                "       firstName: " + this.firstName + "\n" +
                "       lastName: " + this.lastName + "\n" +
                "       dayOfBirth: " + this.dayOfBirth + "\n" +
                "       username: " + this.username + "\n" +
                "       password: " + this.password + "\n";
    }
}
