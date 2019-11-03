package com.ge.exercise1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyUser extends User {
	
	@JsonProperty("User") private MyUser user;
	
	@JsonCreator
	public MyUser(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		super(id, name);
		this.setId(id != null ? id.trim() : id);
		this.setName(name != null ? name.trim() : name);
	}
	
	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}
