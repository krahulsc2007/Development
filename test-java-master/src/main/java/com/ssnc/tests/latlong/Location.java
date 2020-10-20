package com.ssnc.tests.latlong;

public interface Location {

	double getLatitude();

	double getLongitude();

	Location absoluteDifference(Location otherCoordinate);

}