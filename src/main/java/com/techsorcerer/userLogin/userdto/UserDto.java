package com.techsorcerer.userLogin.userdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	    @NotBlank(message = "Firstname is required")
	    private String firstName;
	    @NotBlank(message = "Lastname is required")
	    private String lastName;
	    @NotBlank
	    @Size(min = 3, max = 25, message = "Username should be between 3 & 25 characters")
	    private String username;
	    @NotBlank
	    @Size(min = 4, message = "Password must be minimum 4 characters")
	    private String password;
	    
	    // Getters and Setters
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}



