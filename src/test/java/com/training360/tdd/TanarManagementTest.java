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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TanarManagementTest {
    @Autowired
    private TanarService tanarService;

    @Autowired
    private TanarRepository tanarRepository;

    @Autowired
    private TanarManagementDriver tanarManagementDriver;

    @Before
    public void dropDb() {
        tanarRepository.truncate();
    }

    @Test
    public void letrehozTanart() throws ParseException {
        tanarManagementDriver.letrehozTanart("mi", "Marhefka Istvan", "1979.12.04");
        List<TanarDTO> tanarList = tanarManagementDriver.listTanarok();
        assertThat(tanarList).containsExactly(new TanarDTO("mi", "Marhefka Istvan", "1979.12.04"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void letrehozTanartWithEmptyParamsShouldThrowException() throws ParseException {
        tanarManagementDriver.letrehozTanart(null, null, null);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanarokatWithTheSameAzonositoShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");

        assertThat(tanarRepository.count()).isEqualTo(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanartWithTheSameTeljesNevAndSzuletesiDatumShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanart("mi", "Marhefka Istvan", "1979.12.04");
        tanarManagementDriver.letrehozTanart("mi2", "Marhefka Istvan", "1979.12.04");

        assertThat(tanarRepository.count()).isEqualTo(1);
    }
}
