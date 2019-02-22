package com.faisal.exercise.rezdy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;

public class Ingredient {

    private String title;

    @JsonProperty("best-before")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate bestBefore;

    @JsonProperty("use-by")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate useBy;

    public String getTitle() {
        return title;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDate getUseBy() {
        return useBy;
    }
}
