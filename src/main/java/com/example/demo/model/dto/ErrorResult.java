package com.example.demo.model.dto;

import java.util.List;

public record ErrorResult(
		Type type,
		List<String> messages
		) {

	public enum Type {
		Authentication, Authorization, Validation, Business, Platform
	}
}
