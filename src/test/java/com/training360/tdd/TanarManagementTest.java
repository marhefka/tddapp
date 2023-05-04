package com.training360.tdd;

import jakarta.validation.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TanarManagementTest extends IntegrationTestBase {
    @Test
    public void letrehozTanart() throws Exception {
        tanarManagementDriver.letrehozTanart("mi", "Marhefka Istvan", "1979.12.04");

        List<TanarDTO> tanarList = tanarManagementDriver.listTanarok();
        assertThat(tanarList).containsExactly(new TanarDTO("mi", "Marhefka Istvan", "1979.12.04"));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanarokatWithTheSameAzonositoShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");

        List<TanarDTO> tanarList = tanarManagementDriver.listTanarok();
        assertThat(tanarList).hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void letrehozTanartWithTheSameTeljesNevAndSzuletesiDatumShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanart("mi", "Marhefka Istvan", "1979.12.04");
        tanarManagementDriver.letrehozTanart("mi2", "Marhefka Istvan", "1979.12.04");
    }

    @Test(expected = ConstraintViolationException.class) // ez tipikusan nem BDD teszt
    public void letrehozTanartWithEmptyParamsShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanart(null, null, null);
    }
}
