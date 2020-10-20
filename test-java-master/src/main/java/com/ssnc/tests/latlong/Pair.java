package com.ssnc.tests.latlong;

import java.util.HashSet;
import java.util.Set;

public class Pair<T> {
	private final T lhs;
	private final T rhs;
	
	public Pair(T lhs, T rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public T lhs() { return lhs; }
	public T rhs() { return rhs; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
		result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
		return result;
	}

	// order-independent equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (! (obj instanceof Pair ) )
			return false;
		
		@SuppressWarnings("unchecked")
		Pair<T> other = (Pair<T>) obj;
		
		Set<T> otherItems = new HashSet<>();
		otherItems.add((T)other.lhs());
		otherItems.add((T)other.rhs());
		Set<T> theseItems = new HashSet<>();
		theseItems.add(this.lhs);
		theseItems.add(this.rhs);

		return otherItems.equals(theseItems);
	}

	@Override
	public String toString() {
		return "Pair [lhs=" + lhs + ", rhs=" + rhs + "]";
	}
	
	
}
