package com.swingapplication.foofast.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@AllArgsConstructor
public class Test {

    private String message;

    public void logging() {
        log.info(this.message);
    }
}
