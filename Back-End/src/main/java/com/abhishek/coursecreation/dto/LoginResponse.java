package com.abhishek.coursecreation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(
        @JsonProperty("message") String message
) {}
