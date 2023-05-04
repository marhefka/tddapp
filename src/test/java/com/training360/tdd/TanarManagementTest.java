package com.training360.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TanarManagementTest {
    @Autowired
    private TanarService tanarService;

    @Test
    public void letrehozTanart() throws ParseException {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.rovidAzonosito = "mi";
        command.teljesNev = "Marhefka Istvan";
        command.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command);
    }
}
