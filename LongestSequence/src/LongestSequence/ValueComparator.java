package LongestSequence;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Object> {
	Map<String, Integer> map;

	public ValueComparator(Map<String, Integer> map) {
		this.map = map;
	}

	// implemented comparator
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueA.compareTo(valueB);
	}
}
