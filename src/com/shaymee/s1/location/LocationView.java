package com.shaymee.s1.location;

import java.util.ArrayList;

public class LocationView {

	public void view(String message) {
		System.out.println(message);		
	}
	
	
	public void view(LocationDTO locationDTO) {
		
			System.out.println(locationDTO.getLocation_id());
			System.out.println(locationDTO.getStreet_address());
			System.out.println(locationDTO.getPostal_code());
			System.out.println(locationDTO.getCity());
			System.out.println(locationDTO.getState_province());
			System.out.println(locationDTO.getCountry_id());

	}
	
	
	
	public void view(ArrayList<LocationDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {		
			this.view(ar.get(i));				
			System.out.println("====================================");
		}

	}
	

}