package LongestSequence;

import java.util.Map;
import java.util.TreeMap;

public class MapSort {
	// method to put sorted entries by value using custom comparator into
	// TreeMap
	public static String sortByValue(Map<String, Integer> unsortedMap) {
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(
				new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return (sortedMap).pollFirstEntry().getKey();
	}
}
