package com.ssnc.tests.latlong;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

//City Test
public class CityTest {
	@Test
	public void testLoadOneLine() {
		String[] successLines = { 
				"City,lat,long,ProvState,Country",
				"Birmingham,33.57,86.75,Alabama,USA" };
		
		Set<City> loadedData = City.
				readStreamLines(Arrays.stream(successLines));
		
		assertEquals( 1,  loadedData.size() );
		City city = loadedData.iterator().next();
		assertEquals( "Birmingham", city.getName() );
		assertEquals( 33.57, city.getCoordinates().getLatitude(), 0.001 );
		assertEquals( 86.75, city.getCoordinates().getLongitude(), 0.001 );
		assertEquals( 33.57, city.getLatitude(), 0.001 );
		assertEquals( 86.75, city.getLongitude(), 0.001 );
		assertEquals( "Alabama", city.getProvinceState() );
		assertEquals( "USA", city.getCountry() );
		
	}
}
