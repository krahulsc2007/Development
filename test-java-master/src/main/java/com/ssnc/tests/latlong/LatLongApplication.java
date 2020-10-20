package com.ssnc.tests.latlong;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatLongApplication {
	public static final String LATLONG_CSV = "src\\main\\resources\\latlong.csv";

	/**
	 * 
	 * @param args is a list of city names
	 * latlong.csv is expected to be in the current directory
	 * @throws IOException if read of the latlong.csv throws
	 * 
	 */
	public static void main(String[] args) throws IOException {

	//	Set<String> cityNames = new HashSet<>( Arrays.asList(args) );
		Set<String> cityNames = new HashSet<String>( Arrays.asList(new String[]{"Tuscon","Honolulu","Boise","NewYork","Kalamazoo"}));

		Path latlongcsv = Paths.get(LATLONG_CSV);
		if ( latlongcsv.toFile().exists() ) {
			
			Set<City> cities = City.readStreamLines(Files.lines(latlongcsv) );
			DistanceService service = new DistanceService(cities);
			
			try {
				Pair<City> result = service.findClosestCities(cityNames);
				System.out.println(result.lhs().getName() + " " + result.rhs().getName());
			} catch (LatLongException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		} else {
			System.out.println(LATLONG_CSV + " not found");
		}

	}

}
