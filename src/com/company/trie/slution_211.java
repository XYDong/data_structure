package com.company.trie;

import java.util.TreeMap;

/**
 * @version 1.0.0
 * @ClassName slution_211.java
 * @Package com.company.trie
 * @Author Joker
 * @Description 力扣211
 * @CreateTime 2021年02月19日 15:31:00
 */
public class slution_211 {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public slution_211() {
        this.root = null;
    }

    public void addWord(String word) {
        addWord(root,word,0);
    }
    private void addWord(Node node, String word, int index) {
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
        }
        if (word.length() > index) {
            char c = word.charAt(index);
            if (node.next.get(c) == null) {
                node.next.put(c,new Node());
            }
            addWord(node.next.get(c),word,index+1);
        }
    }

    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) {
            return false;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return search(node.next.get(c),word,index + 1);
        } else {
            for (Character character : node.next.keySet()) {
                if (search(node.next.get(character),word,index +1)) {

                    return true;
                }
            }
            return false;
        }
    }
}
