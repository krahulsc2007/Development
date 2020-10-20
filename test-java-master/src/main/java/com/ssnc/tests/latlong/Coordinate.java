package com.ssnc.tests.latlong;

import static java.lang.Math.abs;

/**
 * A coordinate on earth specified by a lat long float pair.
 *
 */
public class Coordinate implements Location {
	private double latitude;
	private double longitude;
	
	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString() {
		return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	@Override
	public Location absoluteDifference(Location otherCoordinate) {
		double latitudeDistance = abs( this.latitude - otherCoordinate.getLatitude() );
		double longitudeDistance = abs( this.longitude - otherCoordinate.getLongitude() );
		
		return new Coordinate(latitudeDistance, longitudeDistance);
	}
	
}
