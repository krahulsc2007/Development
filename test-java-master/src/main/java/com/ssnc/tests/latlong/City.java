package com.ssnc.tests.latlong;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/** 
 * City information with a loader for your convenience.
 *
 */
public class City implements Location {
	private final String name;
	private final Coordinate coordinates;
	private final String provinceState;
	private final String country;
	
	public City(String city, Coordinate coordinates, String provinceState, String country) {
		this.name = city;
		this.coordinates = coordinates;
		this.provinceState = provinceState;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public Coordinate getCoordinates() {
		return coordinates;
	}
	
	public String getProvinceState() {
		return provinceState;
	}
	
	public String getCountry() {
		return country;
	}
	
	public static Set<City> readStreamLines(Stream<String> lines) {
		
		Set<City> cityCoordinates = new HashSet<>();
		
		lines.skip(1).forEach( line -> {
			String[] row = line.split(",");
			Coordinate coordinates = new Coordinate(
					Float.parseFloat(row[1]), 
					Float.parseFloat(row[2])
					);
			cityCoordinates.add(
					
					new City(row[0], coordinates, row[3], row[4])
				);
			
			
		});
		
		return cityCoordinates;
		
	}

	@Override
	public double getLatitude() {
		return this.coordinates.getLatitude();
	}

	@Override
	public double getLongitude() {
		return this.coordinates.getLongitude();
	}

	@Override
	public Location absoluteDifference(Location otherCoordinate) {
		return this.coordinates.absoluteDifference(otherCoordinate);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", coordinates=" + coordinates + "]";
	}
}
