package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class MyApplication extends Application {
	
	private List<MyUser> users;
	private List<MyGroup> groups; 
	@JsonProperty("Application") private MyApplication application;
	
	@JsonCreator
	public MyApplication(@JsonProperty("id") String id, @JsonProperty("name") String name,
			@JsonProperty("users")  List<MyUser> users, @JsonProperty("groups") List<MyGroup> groups) {
		super(id, name);
		this.setId(id != null ? id.trim() : id);
		this.setName(name != null ? name.trim() : name);
		this.users = users;
		this.groups = groups;
	}
	
	public void setGroupSize() {
		this.groups.forEach(
				group -> group.getGroup().setSize(
					(int)this.groups.stream().filter(g -> g.getGroup().getId().trim().equalsIgnoreCase(group.getGroup().getId())).count())
				);
	}
	
	
	@Override
	public Collection<User> getUsers() {
		List<User> myusers = new ArrayList<User>();
		for(MyUser u:this.users) {
			myusers.add(u.getUser());
			System.out.println(u.getUser().getId() + u.getUser().getName());
		}
		return myusers;
	}

	@Override
	public User getUser(String userId) {
		return this.users.stream().filter(user -> user.getUser().getId().trim().equals(userId.trim())).
				collect(Collectors.toList()).get(0).getUser();
	}

	@Override
	public Collection<Group> getGroups() {
		List<Group> myGroups = new ArrayList<Group>();
		for(MyGroup group: groups) {
			myGroups.add(group.getGroup());
		}
		return myGroups;
	}

	@Override
	public MyGroup getGroup(String groupId) {
		return this.groups.stream().filter(group -> group.getGroup().getId().trim().equalsIgnoreCase(groupId.trim())).
		collect(Collectors.toList()).get(0).getGroup();
		
	}
	
	public MyApplication getApplication() {
		return application;
	}
	public void setApplication(MyApplication application) {
		this.application = application;
	}
	public void setUsers(List<MyUser> users) {
		this.users = users;
	}
	public void setGroups(List<MyGroup> groups) {
		this.groups = groups;
	}
}

