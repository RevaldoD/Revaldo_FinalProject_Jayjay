package com.additional;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@ui")
    public void setUp() {
        Driver.getDriver(); // Initializes the driver if not already
    }

    @After("@ui")
    public void tearDown() {
        Driver.quitDriver();
    }
}
