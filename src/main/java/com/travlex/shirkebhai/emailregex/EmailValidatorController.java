package com.travlex.shirkebhai.emailregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailValidatorController {

	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static  Pattern pattern =  Pattern.compile(EMAIL_PATTERN);
	
	@RequestMapping(method=RequestMethod.POST,value="/checkEmail")
	public ResponseEntity<BaseResponse> checkEmailRegex(@RequestBody BaseRequest emailRequest)
	{
		 if(this.validate(emailRequest.getEmail()))
		 {
			 return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.OK, "Valid Email"), HttpStatus.OK);
		 }
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.BAD_REQUEST, "Invalid Email"), HttpStatus.BAD_REQUEST);
	}
	
	public boolean validate(final String hex) {
		Matcher matcher = pattern.matcher(hex);
		return matcher.matches();
	}
}
