package com.kingteller.bs.framework.check;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

public abstract class StringUtils {

	public static boolean isEmpty(Object str) {
		return org.springframework.util.StringUtils.isEmpty(str);
	}

	public static boolean hasLength(CharSequence str) {
		return org.springframework.util.StringUtils.hasLength(str);
	}

	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}


	public static boolean hasText(CharSequence str) {
		return org.springframework.util.StringUtils.hasText(str);
	}

	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	public static boolean containsWhitespace(CharSequence str) {
		return org.springframework.util.StringUtils.containsWhitespace(str);
	}

	public static boolean containsWhitespace(String str) {
		return containsWhitespace((CharSequence) str);
	}

	public static String trimWhitespace(String str) {
		
		return  org.springframework.util.StringUtils.trimWhitespace(str);
	}

	public static String trimAllWhitespace(String str) {
		return org.springframework.util.StringUtils.trimAllWhitespace(str);
	}

	public static String trimLeadingWhitespace(String str) {
		return org.springframework.util.StringUtils.trimLeadingWhitespace(str) ;
	}

	public static String trimTrailingWhitespace(String str) {
		return org.springframework.util.StringUtils.trimTrailingWhitespace(str);
	}

	public static String trimLeadingCharacter(String str, char leadingCharacter) {
		return org.springframework.util.StringUtils.trimLeadingCharacter(str, leadingCharacter);
	}

	public static String trimTrailingCharacter(String str, char trailingCharacter) {
		return org.springframework.util.StringUtils.trimTrailingCharacter(str, trailingCharacter);
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		return org.springframework.util.StringUtils.startsWithIgnoreCase(str, prefix);
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		return org.springframework.util.StringUtils.endsWithIgnoreCase(str,  suffix);
	}

	public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
		return org.springframework.util.StringUtils.substringMatch(str,  index, substring);
	}

	public static int countOccurrencesOf(String str, String sub) {
		return org.springframework.util.StringUtils.countOccurrencesOf(str, sub);
	}

	public static String replace(String inString, String oldPattern, String newPattern) {
		return org.springframework.util.StringUtils.replace(inString,  oldPattern, newPattern) ;
	}

	public static String delete(String inString, String pattern) {
		return replace(inString, pattern, "");
	}

	public static String deleteAny(String inString, String charsToDelete) {
		return org.springframework.util.StringUtils.deleteAny(inString, charsToDelete);
	}

	public static String quote(String str) {
		return org.springframework.util.StringUtils.quote(str);
	}

	public static Object quoteIfString(Object obj) {
		return org.springframework.util.StringUtils.quoteIfString(obj);
	}

	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	public static String unqualify(String qualifiedName, char separator) {
		return org.springframework.util.StringUtils.unqualify(qualifiedName, separator);
	}

	public static String capitalize(String str) {
		return org.springframework.util.StringUtils.capitalize(str);
	}

	public static String uncapitalize(String str) {
		return org.springframework.util.StringUtils.uncapitalize(str);
	}

	public static String getFilename(String path) {
		return org.springframework.util.StringUtils.getFilename(path);
	}

	public static String getFilenameExtension(String path) {
		return org.springframework.util.StringUtils.getFilenameExtension(path);
	}

	public static String stripFilenameExtension(String path) {
		return org.springframework.util.StringUtils.stripFilenameExtension(path);
	}


	public static String applyRelativePath(String path, String relativePath) {
		return org.springframework.util.StringUtils.applyRelativePath(path, relativePath);
	}

	public static String cleanPath(String path) {
		return org.springframework.util.StringUtils.cleanPath(path);
	}

	public static boolean pathEquals(String path1, String path2) {
		return cleanPath(path1).equals(cleanPath(path2));
	}

	public static Locale parseLocaleString(String localeString) {
		return org.springframework.util.StringUtils.parseLocaleString(localeString);
	}

	public static String toLanguageTag(Locale locale) {
		return locale.getLanguage() + (hasText(locale.getCountry()) ? "-" + locale.getCountry() : "");
	}

	public static TimeZone parseTimeZoneString(String timeZoneString) {
		return org.springframework.util.StringUtils.parseTimeZoneString(timeZoneString); 
	}


	//---------------------------------------------------------------------
	// Convenience methods for working with String arrays
	//---------------------------------------------------------------------
	public static String[] addStringToArray(String[] array, String str) {
		return org.springframework.util.StringUtils.addStringToArray(array, str);
	}

	public static String[] concatenateStringArrays(String[] array1, String[] array2) {
		return org.springframework.util.StringUtils.concatenateStringArrays(array1,array2);
	}

	public static String[] mergeStringArrays(String[] array1, String[] array2) {
		return org.springframework.util.StringUtils.mergeStringArrays(array1,array2);
	}

	public static String[] sortStringArray(String[] array) {
		return org.springframework.util.StringUtils.sortStringArray(array);
	}

	public static String[] toStringArray(Collection<String> collection) {
		return org.springframework.util.StringUtils.toStringArray(collection);
	}

	public static String[] toStringArray(Enumeration<String> enumeration) {
		return org.springframework.util.StringUtils.toStringArray(enumeration) ;
	}

	public static String[] trimArrayElements(String[] array) {
		return org.springframework.util.StringUtils.trimArrayElements(array);
	}

	public static String[] removeDuplicateStrings(String[] array) {
		return org.springframework.util.StringUtils.removeDuplicateStrings(array);
	}

	public static String[] split(String toSplit, String delimiter) {
		return org.springframework.util.StringUtils.split(toSplit, delimiter);
	}

	public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
		return splitArrayElementsIntoProperties(array, delimiter, null);
	}

	public static Properties splitArrayElementsIntoProperties(
			String[] array, String delimiter, String charsToDelete) {

		return org.springframework.util.StringUtils.splitArrayElementsIntoProperties(
				array, delimiter, charsToDelete);
	}

	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}

	public static String[] tokenizeToStringArray(
			String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

		return org.springframework.util.StringUtils.tokenizeToStringArray(
				str, delimiters, trimTokens, ignoreEmptyTokens);
	}

	public static String[] delimitedListToStringArray(String str, String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}

	public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
		return org.springframework.util.StringUtils.delimitedListToStringArray(str, delimiter, charsToDelete);
	}

	public static String[] commaDelimitedListToStringArray(String str) {
		return delimitedListToStringArray(str, ",");
	}

	public static Set<String> commaDelimitedListToSet(String str) {
		return org.springframework.util.StringUtils.commaDelimitedListToSet(str);
	}

	public static String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix) {
		return org.springframework.util.StringUtils.collectionToDelimitedString( coll,  delim,  prefix,  suffix);
	}

	public static String collectionToDelimitedString(Collection<?> coll, String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}

	public static String collectionToCommaDelimitedString(Collection<?> coll) {
		return collectionToDelimitedString(coll, ",");
	}

	public static String arrayToDelimitedString(Object[] arr, String delim) {
		return org.springframework.util.StringUtils.arrayToDelimitedString(arr, delim);
	}

	public static String arrayToCommaDelimitedString(Object[] arr) {
		return arrayToDelimitedString(arr, ",");
	}
	
	/**
	 * 生成指定位数的随机数
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i)
		{
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public static String generateCheckCode(String str){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; ++i)
		{
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(generateCheckCode("18710105371"));
	}

}

