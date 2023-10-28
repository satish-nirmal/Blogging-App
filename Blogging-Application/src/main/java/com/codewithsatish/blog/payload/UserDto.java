package com.codewithsatish.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

	
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Validated
public class UserDto {

	private long id;

	@NotNull
	@Size(min = 4, message = "this is not perfect name", max = 20)
	private String name;

	@Email(message = "Invalid email address")
	private String email;

	@NotNull
	@Size(min = 3, max = 15, message = "password must be minimum 3-15")
	@Pattern(regexp = "[A-Za-z0-9]+")
	private String password;

	@NotEmpty
	@Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+")
	private String about;

}
