package com.shaymee.s1.location;

import java.util.Scanner;

public class LocationInput {

	public LocationDTO inputId(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("= Location_Id를 입력하세요 =");
		int location_id = sc.nextInt();
		
		locationDTO.setLocation_id(location_id);
		
			return locationDTO;

	}
	
	public LocationDTO inputLocationDTO(Scanner sc) {
		
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("== LOCATION_ID 입력 ==");
		int location_id = sc.nextInt();
		System.out.println("== STREET_ADDRESS 입력 ==");
		String street_address = sc.next();
		System.out.println("== POSTAL_CODE 입력 ==");
		String postal_code = sc.next();
		System.out.println("== CITY 입력 ==");
		String city = sc.next();
		System.out.println("== STATE_PROVINCE 입력 ==");
		String state_province = sc.next();
		System.out.println("== COUNTRY_ID 입력 ==");
		String country_id = sc.next();
		
		locationDTO.setLocation_id(location_id);
		locationDTO.setStreet_address(street_address);
		locationDTO.setPostal_code(postal_code);
		locationDTO.setCity(city);
		locationDTO.setState_province(state_province);
		locationDTO.setCountry_id(country_id);
		
		return locationDTO;
		
	}
	
	public LocationDTO deleteLocationDTO(Scanner sc) {
		
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("== 삭제할 Location_id 입력 ==");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		System.out.println(locationDTO.getLocation_id());
		
		return locationDTO;
		
		
	}
	
}
