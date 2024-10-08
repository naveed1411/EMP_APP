package com.example.demo.exceptionclasses;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class NoEducationFoundException extends RuntimeException {
	String message;

}
