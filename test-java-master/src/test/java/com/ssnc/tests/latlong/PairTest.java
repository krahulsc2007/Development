package com.ssnc.tests.latlong;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import static com.ssnc.tests.latlong.TestDataFactory.*;

public class PairTest {
	
	@Test
	public void initialize() {
		Pair<City> p1 = new Pair<>(CITY_A_0_0, CITY_B_0_90);
		
		assertThat( p1.lhs(), is(CITY_A_0_0) );
		assertThat( p1.rhs(), is(CITY_B_0_90) );
	}
	
	@Test
	public void equals() {
		Pair<City> p1 = new Pair<City>(CITY_A_0_0, CITY_B_0_90);
		Pair<City> p2 = new Pair<City>(CITY_A_0_0, CITY_B_0_90);
		
		assertThat(p1, equalTo(p2) );
	}

	@Test
	public void equalsIsOrderIndepedent() {
		Pair<City> p1 = new Pair<City>(CITY_A_0_0, CITY_B_0_90);
		Pair<City> p2 = new Pair<City>(CITY_B_0_90, CITY_A_0_0);
		
		assertThat(p1, equalTo(p2) );
	}
}
