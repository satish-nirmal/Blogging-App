package com.codewithsatish.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFountException extends RuntimeException {

	private String resouseName;
	private String fieldName;
	private long feildValue;

	public ResourseNotFountException(String resouseName, String fieldName, long feildValue) {
		super(String.format("%s not found with %s: %s", resouseName, fieldName, feildValue));
		this.resouseName = resouseName;
		this.fieldName = fieldName;
		this.feildValue = feildValue;
	}

}
