package com.training360.tdd;

import jakarta.validation.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TanarManagementTest {
    @Autowired
    private TanarService tanarService;

    @Autowired
    private TanarRepository tanarRepository;

    @Before
    public void dropDb() {
        tanarRepository.truncate();
    }

    @Test
    public void letrehozTanart() throws ParseException {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.rovidAzonosito = "mi";
        command.teljesNev = "Marhefka Istvan";
        command.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command);

        assertThat(tanarRepository.count()).isEqualTo(1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void letrehozTanartWithEmptyParamsShouldThrowException() throws ParseException {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.rovidAzonosito = null;
        command.teljesNev = null;
        command.szuletesiDatum = null;
        tanarService.letrehozTanart(command);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanartWithTheRovidNevShouldThrowException() throws Exception {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.rovidAzonosito = "mi";
        command.teljesNev = "Marhefka Istvan";
        command.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command);

        LetrehozTanartCommand command2 = new LetrehozTanartCommand();
        command2.rovidAzonosito = "mi";
        command2.teljesNev = "Marhefka Istvan2";
        command2.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command2);

        assertThat(tanarRepository.count()).isEqualTo(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanartWithTheSameTeljesNevAndSzuletesiDatumShouldThrowException() throws Exception {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.rovidAzonosito = "mi";
        command.teljesNev = "Marhefka Istvan";
        command.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command);

        LetrehozTanartCommand command2 = new LetrehozTanartCommand();
        command2.rovidAzonosito = "mi2";
        command2.teljesNev = "Marhefka Istvan";
        command2.szuletesiDatum = new SimpleDateFormat("yyyy-MM-dd").parse("1979-12-04");
        tanarService.letrehozTanart(command2);

        assertThat(tanarRepository.count()).isEqualTo(1);
    }
}
