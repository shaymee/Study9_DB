package com.shaymee.s1.location;

public class LocationDTO {
	//DTO : Data Transfer Object == 데이터를 운반하는 객체(이 객체 안에 데이터를 담아 운반하는 용도, 데이터 덩어리)

	//1. 멤버변수는 접근지정자를 모두 private으로 설정
	//2. 멤버변수의 데이터타입과 변수명의 DB Table의 Column명과 일치
	//3. Getter/Setter가 존재해야 함
	//4. 생성자는 여러개 가능. 단, default생성자 필요(DTO만들 때 규칙 중 default생성자는 무조건 있어야 함)

	private int location_id;
	private String street_address;
	private	String postal_code;
	private String city;
	private String state_province;
	private String country_id;
	
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	
	
	
	
	
	
	
}
