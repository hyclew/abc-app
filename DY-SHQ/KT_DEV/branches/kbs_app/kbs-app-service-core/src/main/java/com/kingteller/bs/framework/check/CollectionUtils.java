package com.kingteller.bs.framework.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.MultiValueMap;


public abstract class CollectionUtils {
	public static boolean isEmpty(Collection<?> collection) {
		return org.springframework.util.CollectionUtils.isEmpty(collection);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return org.springframework.util.CollectionUtils.isEmpty(map);
	}

	public static List arrayToList(Object source) {
		return org.springframework.util.CollectionUtils.arrayToList(source);
	}

	public static <E> void mergeArrayIntoCollection(Object array, Collection<E> collection) {
		org.springframework.util.CollectionUtils.mergeArrayIntoCollection(array, collection);
	}

	public static <K, V> void mergePropertiesIntoMap(Properties props, Map<K, V> map) {
		org.springframework.util.CollectionUtils.mergePropertiesIntoMap(props, map);
	}


	public static boolean contains(Iterator<?> iterator, Object element) {
		return org.springframework.util.CollectionUtils.contains(iterator, element);
	}

	public static boolean contains(Enumeration<?> enumeration, Object element) {
		return org.springframework.util.CollectionUtils.contains(enumeration, element);
	}

	public static boolean containsInstance(Collection<?> collection, Object element) {
		return org.springframework.util.CollectionUtils.containsInstance(collection, element);
	}

	public static boolean containsAny(Collection<?> source, Collection<?> candidates) {
		return org.springframework.util.CollectionUtils.containsAny(source, candidates);
	}

	public static <E> E findFirstMatch(Collection<?> source, Collection<E> candidates) {
		return org.springframework.util.CollectionUtils.findFirstMatch(source, candidates);
	}

	public static <T> T findValueOfType(Collection<?> collection, Class<T> type) {
		return org.springframework.util.CollectionUtils.findValueOfType(collection, type);
	}

	/**
	 * Find a single value of one of the given types in the given Collection:
	 * searching the Collection for a value of the first type, then
	 * searching for a value of the second type, etc.
	 * @param collection the collection to search
	 * @param types the types to look for, in prioritized order
	 * @return a value of one of the given types found if there is a clear match,
	 * or {@code null} if none or more than one such value found
	 */
	public static Object findValueOfType(Collection<?> collection, Class<?>[] types) {
		return org.springframework.util.CollectionUtils.findValueOfType(collection, types);
	}

	public static boolean hasUniqueObject(Collection<?> collection) {
		return org.springframework.util.CollectionUtils.hasUniqueObject(collection);
	}

	public static Class<?> findCommonElementType(Collection<?> collection) {
		return org.springframework.util.CollectionUtils.findCommonElementType(collection);
	}

	public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] array) {
		return org.springframework.util.CollectionUtils.toArray(enumeration, array);
	}

	public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
		return org.springframework.util.CollectionUtils.toIterator(enumeration);
	}

	public static <K, V> MultiValueMap<K, V> toMultiValueMap(Map<K, List<V>> map) {
		return org.springframework.util.CollectionUtils.toMultiValueMap(map);

	}

	public static <K,V> MultiValueMap<K,V> unmodifiableMultiValueMap(MultiValueMap<? extends K, ? extends V> map) {
		 return org.springframework.util.CollectionUtils.unmodifiableMultiValueMap(map);
	}

}
