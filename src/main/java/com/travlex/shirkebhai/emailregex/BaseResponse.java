package com.travlex.shirkebhai.emailregex;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BaseResponse {

	protected HttpStatus status;
	protected String message;

	public BaseResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	
	
}
