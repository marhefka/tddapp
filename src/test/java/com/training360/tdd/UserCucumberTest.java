package com.training360.tdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/greeting.feature", plugin = {"pretty"})
@Ignore
public class UserCucumberTest {
}
