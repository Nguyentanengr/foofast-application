package com.swingapplication.foofast;

import com.swingapplication.foofast.controllers.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MainApplication {

    public static void main(String[] args) {

        log.info("Hello Main Application!");

        Test test = new Test("We are testing for the application!");
        test.logging();
    }
}
