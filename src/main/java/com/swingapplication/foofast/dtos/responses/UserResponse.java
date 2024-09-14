package com.swingapplication.foofast.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;
    private String username;

    @Override
    public String toString() {
        return "\n  [USER RESPONSE]" + "\n" +
                "       id: " + this.id + "\n" +
                "       firstName: " + this.firstName + "\n" +
                "       lastName: " + this.lastName + "\n" +
                "       dayOfBirth: " + this.dayOfBirth + "\n" +
                "       username: " + this.username + "\n";
    }
}
