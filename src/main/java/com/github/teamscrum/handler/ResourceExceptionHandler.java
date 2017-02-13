package com.github.teamscrum.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.teamscrum.exception.SectorNotFoundException;
import com.github.teamscrum.ws.model.ErrorDetails;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(SectorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleSectorNotFoundException(SectorNotFoundException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus("404");
		error.setTitle("Setor inexistente.");
		error.setTimestamp(System.currentTimeMillis());
		error.setDeveloperMessage("http://error.team-scrum.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
