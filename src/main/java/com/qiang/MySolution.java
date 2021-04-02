package com.qiang;

public class MySolution {
	
	public static void main(String[] args) {
		String[] sentenses = new String[] {
				"i love you",
				"island",
				"ironman",
				"i love leetcode"
			};
		int[] times = new int[] {5,3,2,2};
		AutocompleteSystem as = new AutocompleteSystem(sentenses, times);
		System.out.println("input('i')" + ":" + as.input('i'));
		System.out.println("input(' ')" + ":" + as.input(' '));
		System.out.println("input('l')" + ":" + as.input('l'));
		System.out.println("input('#')" + ":" + as.input('#'));
	}
	
}