package com.swingapplication.foofast.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ListUserResponse {

    private int totalPages;
    List<UserResponse> userResponses;

    @Override
    public String toString() {
        return "\n  [LIST USER RESPONSE]" + "\n" +
                "       totalPages: " + this.totalPages + "\n" +
                "       listUserResponse: \n" + this.userResponses + "\n";
    }
}
