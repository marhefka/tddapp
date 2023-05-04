package com.training360.tdd;

import jakarta.validation.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.training360.tdd.Response.isNotOk;
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

    @Test
    public void letrehozKetTanart() throws Exception {
        tanarManagementDriver.letrehozTanartCsakAzonositoval("X");
        tanarManagementDriver.letrehozTanartCsakAzonositoval("Y");

        List<TanarDTO> tanarList = tanarManagementDriver.listTanarok();
        assertThat(tanarList).hasSize(2);
    }

    @Test
    public void letrehozTanarokatWithTheSameAzonositoShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");

        Response response = tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");
        assertThat(isNotOk(response)).isTrue();
    }

    @Test
    public void letrehozTanartWithTheSameTeljesNevAndSzuletesiDatumShouldThrowException() throws Exception {
        tanarManagementDriver.letrehozTanart("mi", "Marhefka Istvan", "1979.12.04");

        Response response = tanarManagementDriver.letrehozTanart("mi2", "Marhefka Istvan", "1979.12.04");
        assertThat(isNotOk(response)).isTrue();
    }

    @Test
    public void modositAdatokat() throws Exception {
        tanarManagementDriver.letrehozTanartCsakAzonositoval("mi");
        tanarManagementDriver.modositTanarAdatait("mi", "Meredek Ibolya", "1956.07.12");

        List<TanarDTO> tanarList = tanarManagementDriver.listTanarok();
        assertThat(tanarList).containsExactly(new TanarDTO("mi", "Meredek Ibolya", "1956.07.12"));
    }
}
