package com.training360.tdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/greeting.feature", plugin = {"pretty"})
public class GreetingCucumberTest {
}
