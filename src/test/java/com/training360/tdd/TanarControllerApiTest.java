package com.training360.tdd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TanarController.class)
public class TanarControllerApiTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TanarService tanarService;

    @MockBean
    private TanarRepository tanarRepository;

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @Test
    public void letrehozTanart() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("azonosito", "ABC123");
        json.addProperty("teljesNev", "John Doe");
        json.addProperty("szuletesiDatum", "1990-01-01");
        String jsonRequest = gson.toJson(json);

        JsonObject json2 = new JsonObject();
        json2.addProperty("resultCode", "OK");
        json2.addProperty("payload", (String) null);
        String jsonResponse = gson.toJson(json2);

        Mockito.doNothing().when(tanarService).letrehozTanart(Mockito.any(LetrehozTanartCommand.class));

        mockMvc.perform(post("/tanar/letrehoz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonResponse));

    }

    @Test
    public void letrehozTanartWithMissingParameters() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("azonosito", "");
        json.addProperty("teljesNev", "John Doe");
        json.addProperty("szuletesiDatum", "1990-01-01");
        String jsonRequest = gson.toJson(json);

        Mockito.doNothing().when(tanarService).letrehozTanart(Mockito.any(LetrehozTanartCommand.class));

        mockMvc.perform(post("/tanar/letrehoz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

        /*
        curl -i -X POST -H "Content-Type: application/json" -d '{
    "azonosito": "ABC124",
    "teljesNev": "John Doo",
    "szuletesiDatum": "1991-01-01"
}' -w "\nResponse code: %{http_code}\nResponse body: %{response_body}\n" http://localhost:8081/tanar/letrehoz
         */

}
