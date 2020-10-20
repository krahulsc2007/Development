package com.ssnc.tests.latlong;

import java.util.HashSet;
import java.util.Set;

public class TestDataFactory {
	public static final City CITY_A_0_0 = new City("a",
			new Coordinate(0.0, 0.0), 
			"XX-prov", 
			"YY-ctry");
	
	public static final City CITY_A45_0_45 = new City("a45",
			new Coordinate(0.0, 45.0), 
			"XX-prov", 
			"YY-ctry");
	
	public static final City CITY_A45_45_0 = new City("a45p",
			new Coordinate(45.0, 0.0), 
			"XX-prov", 
			"YY-ctry");
	
	public static final City CITY_B_0_90 = new City("b",
			new Coordinate(0.0, 90.0), 
			"XX-prov", 
			"YY-ctry");
	
	
	public static final City CITY_C_90_90 = new City("c",
			new Coordinate(90.0, 90.0), 
			"XX-prov", 
			"YY-ctry");
	
	
	public static final City CITY_D_90_45 = new City("d",
			new Coordinate(90.0, 45.0), 
			"XX-prov", 
			"YY-ctry");
	
	
	public static final City CITY_E_45_45 = new City("e",
			new Coordinate(45.0, 45.0), 
			"XX-prov", 
			"YY-ctry");
	
	public static Set<City> firstThreeCities() {
		Set<City> cities  = new HashSet<>();
		cities.add(CITY_A_0_0);
		cities.add(CITY_B_0_90);
		cities.add(CITY_C_90_90);
		return cities;
	}
	
	public static Set<City> firstFiveCities() {
		Set<City> cities = firstThreeCities();
		cities.add(CITY_D_90_45);
		cities.add(CITY_E_45_45);
		
		return cities;
	}
	
}
