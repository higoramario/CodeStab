package br.usp.each.saeg.code.stab.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * author: Carter Page
 * http://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
 * */

public class MapUtil {
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
	{
	    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
	    Collections.sort(list, new Comparator<Map.Entry<K, V>>()
	    {
	        @Override
	        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
	        {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });
	
	    Map<K, V> result = new LinkedHashMap<>();
	    for (Map.Entry<K, V> entry : list)
	    {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
}
