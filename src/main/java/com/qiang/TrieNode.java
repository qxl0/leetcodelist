package com.qiang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrieNode implements Comparable<TrieNode> {
	TrieNode[] children;
	String s;
	int times;
	List<TrieNode> hot;
	
	public TrieNode() {
		children = new TrieNode[128];
		s = null;
		times = 0;
		hot = new ArrayList<>();
	}

	@Override
	public int compareTo(TrieNode o) {
		if (this.times == o.times) {
			return this.s.compareTo(o.s);
		}
		return o.times - this.times;
	}
	
	public void Update(TrieNode node) {
		if (!this.hot.contains(node)) {
			this.hot.add(node);
		}
		
		Collections.sort(hot);
		if (hot.size() > 3)
			hot.remove(hot.size()-1);
	}
}
