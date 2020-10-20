package com.ssnc.tests.latlong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistanceService {
	private Map<String, City> cityLocations = new HashMap<>();
	private static final double RADIUS_OF_THE_EARTH = 6371.0;

	public DistanceService(Set<City> cities) {
		cities.stream().forEach(city -> cityLocations.put(city.getName(), city));
	}

	public Pair<City> findClosestCities(Set<String> cityNames) throws LatLongException {
		if (null == cityNames || cityNames.isEmpty()) {
			throw new LatLongException("City names input is empty...");
		}
		if (cityNames.size() < 2) {
			throw new LatLongException("City size is less than 2. Not enough cities to compare...");
		}
		for (String city : cityNames) {
			if (!cityLocations.containsKey(city)) {
				throw new LatLongException("Provided city name does not exist in the latlong csv...");
			}
		}
		Pair<City> pair = null;
		try {
			List<List<String>> cityCombinations = combinations(new ArrayList<String>(cityNames), 2)
					.collect(Collectors.toList());
			double minDist = 0;
			double currentDist = 0;
			int counter = 1;
			for (List<String> comb : cityCombinations) {
				City firstCity = cityLocations.get(comb.get(0));
				City secondCity = cityLocations.get(comb.get(1));
				currentDist = calculateDistance(firstCity, secondCity);
				if (counter == 1) {
					minDist = currentDist;
					pair = new Pair<City>(firstCity, secondCity);
				}
				if (minDist > currentDist) {
					minDist = currentDist;
					pair = new Pair<City>(firstCity, secondCity);
				}
				counter++;
			}
		} catch (Exception e) {
			throw new LatLongException("Processing issue while calculating distance via Vincenty's formula ...");
		}
		return pair;
	}

	// Using Vincenty's formula to calculate distance between 2 cities
	private double calculateDistance(City firstCity, City secondCity) throws LatLongException {
		double flatteningConst = 1 / 298.257223563;
		double lambda = Math.toRadians(secondCity.getLongitude() - firstCity.getLongitude());
		double U1 = Math.atan((1 - flatteningConst) * Math.tan(Math.toRadians(firstCity.getLatitude())));
		double U2 = Math.atan((1 - flatteningConst) * Math.tan(Math.toRadians(secondCity.getLatitude())));
		double sinU1 = Math.sin(U1), cosU1 = Math.cos(U1);
		double sinU2 = Math.sin(U2), cosU2 = Math.cos(U2);
		double sinLambda, cosLambda, sinSigma, cosSigma, sigma;
		sinLambda = Math.sin(lambda);
		cosLambda = Math.cos(lambda);
		sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda)+ (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
		if (sinSigma == 0) {
			throw new LatLongException("Numerator is 0...");
		}
		cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
		sigma = Math.atan2(sinSigma, cosSigma);
		return sigma;
	}

	// Get all possible combinations of cities
	private <E> Stream<List<E>> combinations(List<E> l, int size) {
		if (size == 0) {
			return Stream.of(Collections.emptyList());
		} else {
			return IntStream.range(0, l.size()).boxed().<List<E>>flatMap(
					i -> combinations(l.subList(i + 1, l.size()), size - 1).map(t -> pipe(l.get(i), t)));
		}
	}

	// Helper method for combinations()
	private <E> List<E> pipe(E head, List<E> tail) {
		List<E> newList = new ArrayList<>(tail);
		newList.add(0, head);
		return newList;
	}
}
