package com.training360.tdd;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ModositTanarAdataitCommand {
    @NotEmpty
    public String teljesNev;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    public LocalDate szuletesiDatum;
}
