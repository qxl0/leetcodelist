package com.qiang;

import java.util.ArrayList;
import java.util.List;




public class AutocompleteSystem {
	TrieNode root;
	TrieNode cur;
	StringBuilder sb;
	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		cur = root;
		sb = new StringBuilder();
		for (int i = 0; i < times.length; i++) {
			add(sentences[i], times[i]);
		}
		
	}
	
	public void add(String sentence, int times) {
		TrieNode tmp = root;
		List<TrieNode> list = new ArrayList<TrieNode>();
		for (char c: sentence.toCharArray()) {
			if (tmp.children[c] == null) {
				tmp.children[c] = new TrieNode();
			}
			tmp = tmp.children[c];
			list.add(tmp);
		}
		tmp.s = sentence;
		tmp.times = times;
		for (TrieNode node: list) {
			node.Update(tmp);
		}
	}
	public List<String> input(char c){
		List<String> res = new ArrayList<String>();
		if (c == '#') {
			add(sb.toString(), 1);
			sb = new StringBuilder();
			cur = root;
			return res; 
		}
		
		sb.append(c);
		if (cur != null) {
			cur = cur.children[c];
		}
		
		if (cur == null) {
			return res;
		}
		
		for (TrieNode node: cur.hot) {
			res.add(node.s);
		}
		return res;
	}
}
