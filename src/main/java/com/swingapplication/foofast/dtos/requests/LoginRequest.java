package com.swingapplication.foofast.dtos.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
public class LoginRequest {

    @NotNull
    String username;
    String password;
}
