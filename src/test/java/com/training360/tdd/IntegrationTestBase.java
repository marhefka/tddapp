package com.training360.tdd;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class IntegrationTestBase {
    @Autowired
    protected TanarManagementDriver tanarManagementDriver;

    @Autowired
    protected TestHelper testHelper;

    @Before
    public void dropDb() {
        testHelper.truncateTables();
    }
}
