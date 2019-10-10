package org.zhouhy.springboot.config.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User1 {
	
	@Value(value="#{1+2}")
	private int id;
	
	@Value(value="${user.username}")
	private String username;
	
	@Value(value="${user.password}")
	private String password;
	
	@Value(value="${user.birthday}")
	private Date birthday;
	
	@Value("true")
	private boolean sex;
	
	//@Value不能弄复杂数据
	//@Value(value="${user.list}")
	private List<String> list = new ArrayList<>();	
	
	//@Value(value="${user.map}")
	private Map<String,Object> map = new HashMap<>();
	
	//@Value(value="${user.address}")
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User1 [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday
				+ ", sex=" + sex + ", list=" + list + ", map=" + map + ", address=" + address + "]";
	}	
}
