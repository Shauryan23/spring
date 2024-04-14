package com.spring.springEMS.exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.springEMS.entity.CustomErrorObj;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorObj> handleEmployeeNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {

		CustomErrorObj err = new CustomErrorObj();
		err.setStatusCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(exception.getMessage());

		return new ResponseEntity<CustomErrorObj>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<CustomErrorObj> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,
			WebRequest request) {

		CustomErrorObj err = new CustomErrorObj();
		err.setStatusCode(HttpStatus.BAD_REQUEST.value());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<CustomErrorObj>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorObj> handleGeneralException(Exception ex, WebRequest request) {

		CustomErrorObj err = new CustomErrorObj();
		err.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<CustomErrorObj>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		
		List<String> errors = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
		
		body.put("messages", errors);

		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}

}
