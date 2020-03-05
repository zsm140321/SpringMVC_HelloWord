package cn.net.yiyun.model;

public class User {

	private String name;
	private String username;
	private String password;
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + ", address=" + address
				+ "]";
	}
	
}
