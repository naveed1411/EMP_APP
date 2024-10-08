package com.example.demo.service.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoAddressFoundException extends RuntimeException {
private String message;
}
