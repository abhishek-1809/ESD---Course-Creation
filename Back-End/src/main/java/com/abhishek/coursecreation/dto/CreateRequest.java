package com.abhishek.coursecreation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public record CreateRequest (

        @NotNull(message = "Course Code should be present")
        @NotEmpty(message = "Course Code should be present")
        @NotBlank(message = "Course Code should be present")
//        @JsonProperty("course_code")
        String courseCode,

//        @JsonProperty("name")
        String name,

//        @JsonProperty("description")
        String description,

//        @JsonProperty("year")
        Integer year,

//        @JsonProperty("term")
        Integer term,

//        @JsonProperty("faculty")
        String faculty,

//        @JsonProperty("credits")
        Integer credits,

//        @JsonProperty("capacity")
        Integer capacity,

//        @JsonProperty("time")
        String time,

//        @JsonProperty("day")
        List<String> day,

//        @JsonProperty("room")
        String room,

//        @JsonProperty("building")
        String building,

//        @JsonProperty("specialisation_name")
        String specialisationName,


//        @JsonProperty("prerequisite_name")
        List<String> prerequisiteName,


//        @JsonProperty("pre_description")
        String preDescription
        ){
}
