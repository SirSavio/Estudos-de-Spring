package com.sirsavio.estudo.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class URL {
	public static List<Integer> decodeStringToInteger(String str){
		return Arrays.asList(str.split(",")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
	}
	
	public static String decodeParam(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
