package com.example.geniusplazechallenge.model;

public class DataItem{
	private String lastName;
	private int id;
	private String avatar;
	private String firstName;
	private String email;

	public String getLastName(){
		return lastName;
	}

	public int getId(){
		return id;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
