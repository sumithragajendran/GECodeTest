package com.ge.exercise1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyGroup extends Group {
	
	@JsonProperty("Group") private MyGroup group;
	@JsonProperty("users") private List<MyUser> users;
	
	@JsonCreator
	public MyGroup(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("users") List<MyUser> users) {
		super(id, name);
		this.setId(id != null ? id.trim() : id);
		this.setName(name != null ? name.trim() : name);
		this.users = users;
		assignSize();
	}
	
	public void assignSize() {
		if(this.users != null) {
			this.size = this.users.size();
		}
	}
	public List<MyUser> getUsers() {
		return users;
	}
	public void setUsers(List<MyUser> users) {
		this.users = users;
	}
	
	public MyGroup getGroup() {
		return group;
	}
	public void setGroup(MyGroup group) {
		this.group = group;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.users.size();
	}
}
