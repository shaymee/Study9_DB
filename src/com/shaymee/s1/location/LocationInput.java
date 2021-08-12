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
	
}
