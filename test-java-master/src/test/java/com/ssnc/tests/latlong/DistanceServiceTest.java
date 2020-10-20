package com.ssnc.tests.latlong;

import static com.ssnc.tests.latlong.TestDataFactory.CITY_A45_0_45;
import static com.ssnc.tests.latlong.TestDataFactory.CITY_A_0_0;
import static com.ssnc.tests.latlong.TestDataFactory.CITY_C_90_90;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class DistanceServiceTest {
	
	// This test will fail initially.
	//
	// a: (0,0)
	// a45: (0,45)
	// c: (90,90)
	// a and a45 are closest 
	// -- which should be intuitive thinking of this as a
	// mapped to flattened quadrant w Cartesian coordinates
	@Test
	public void simpleSuccess() throws LatLongException {
		Set<City> cities = new HashSet<>();
		cities.add(CITY_A_0_0);
		cities.add(CITY_A45_0_45);
		cities.add(CITY_C_90_90);
		
		DistanceService ds = new DistanceService(cities);
		
		Set<String> cityNames = cities.stream().
									map(c -> c.getName()).
									collect(Collectors.toCollection(HashSet::new));
		
		Pair<City> result = ds.findClosestCities(cityNames);
		Pair<City> a_a45 = new Pair<>(CITY_A_0_0, CITY_A45_0_45);
		
		assertThat( result, equalTo(a_a45) );
	}
	
}
