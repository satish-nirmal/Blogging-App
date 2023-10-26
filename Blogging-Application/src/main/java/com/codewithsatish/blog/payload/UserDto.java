package com.codewithsatish.blog.payload;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
		
		private long id;
		
		@NotEmpty
		@Size(min = 4, message = "this is not perfect name", max = 20)
		private String name;
		
		@Email
		private String email;
		
		@NotEmpty
		private String password;
		
        @NotEmpty
		private String about;
		

	}
