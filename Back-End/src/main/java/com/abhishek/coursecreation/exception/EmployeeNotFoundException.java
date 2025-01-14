package com.abhishek.coursecreation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class EmployeeNotFoundException extends RuntimeException {
    private final String msg;
}
