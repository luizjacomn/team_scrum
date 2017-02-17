package com.github.teamscrum.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -159739610582453231L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
