package com.abhishek.coursecreation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.Date;

public record CreateRequest (

        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        @JsonProperty("course_code")
        String courseCode,

        @JsonProperty("name")
        String name,

        @JsonProperty("description")
        String description,

        @JsonProperty("year")
        Integer year,

        @JsonProperty("term")
        Integer term,

        @JsonProperty("faculty")
        String faculty,

        @JsonProperty("credits")
        Integer credits,

        @JsonProperty("capacity")
        Integer capacity,

        @JsonProperty("time")
        Date time,

        @JsonProperty("day")
        String day,

        @JsonProperty("room")
        String room,

        @JsonProperty("building")
        String building,

        @JsonProperty("specialisation_id")
        String specialisationId,


        @JsonProperty("prerequisite")
        Integer prerequisite,


        @JsonProperty("description")
        String preDescription
        ){
}
