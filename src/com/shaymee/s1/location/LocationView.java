package com.shaymee.s1.location;

import java.util.ArrayList;

public class LocationView {

	
	public void view(LocationDTO locationDTO) {
		
		System.out.println(locationDTO.getLocation_id());
		System.out.println(locationDTO.getStreet_address());
		System.out.println(locationDTO.getPostal_code());
		System.out.println(locationDTO.getCity());
		System.out.println(locationDTO.getState_province());
		System.out.println(locationDTO.getCountry_id());		
		
	}
	
	public void view(ArrayList<LocationDTO> ar) { //매개변수를 다르게 해서 overloading
		
		for(int i=0;i<ar.size();i++) {
			this.view(ar.get(i));
			System.out.println("----------------------------------------------------------");
			
		}
		
		
	}
	
	public void view(int num) {
		
		System.out.println(num+"개");
		
	}

}