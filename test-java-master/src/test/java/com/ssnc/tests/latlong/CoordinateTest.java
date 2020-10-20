package com.ssnc.tests.latlong;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CoordinateTest {
	@Test
	public void createSuccess() {
		double latitude = 23.23;
		double longitude = 44.44;
		
		Location c = new Coordinate(latitude, longitude);
		
		assertEquals( 23.23, c.getLatitude(), 0.001) ;
		assertEquals( 44.44, c.getLongitude(), 0.001) ;
	}
	
	@Test
	public void simpleDistance() {
		//                            (lat,long)
		Location c1 = new Coordinate( 10, 10 );
		Location c2 = new Coordinate( 5, 2 );
		
		Location d= c1.absoluteDifference(c2);

		assertEquals( 5, d.getLatitude(), 0.001 );
		assertEquals( 8, d.getLongitude(), 0.001 );

	}
	
	@Test
	public void string() {
		Coordinate c1 = new Coordinate(1.0,  1.0);
		
		assertThat( c1.toString(), equalTo("Coordinate [latitude=1.0, longitude=1.0]") );
	}
}
