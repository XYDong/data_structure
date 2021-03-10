package com.company.trie;

import java.util.TreeMap;

/**
 * @version 1.0.0
 * @ClassName Trie.java
 * @Package com.company.trie
 * @Author Joker
 * @Description 字典树
 * @CreateTime 2021年02月18日 14:09:00
 */
public class Trie {
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
    private int size;
    public Trie() {
        root = null;
        size = 0;
    }

    /**
     * 方法描述: <br>
     * <p> 获取Trie中的元素个数 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/19 9:46
     * @return int
     * @ReviseName
     * @ReviseTime 2021/2/19 9:46
     **/
    public int getSize(){
        return size;
    }

    /**
     * 方法描述: <br>
     * <p> 向Trie中添加新的单词 (非递归)</p>
     *
     * @Author Joker
     * @CreateDate 2021/2/19 9:46
     * @param word 需要新插入的单词
     * @return void
     * @ReviseName
     * @ReviseTime 2021/2/19 9:46
     **/
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c , new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 递归添加
     * @param word
     */
    public void addNew(String word){
        addNew(root,word,0);
    }

    private void addNew(Node node, String word, int index) {
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
        }
        if (word.length() > index) {
            char c = word.charAt(index);
            if (node.next.get(c) == null) {
                node.next.put(c,new Node());
            }
            addNew(node.next.get(c),word,index+1);
        }
    }

    /**
     * 方法描述: <br>
     * <p> 查询单词word是否在Trie中 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/19 10:32
     * @param word
     * @return boolean
     * @ReviseName
     * @ReviseTime 2021/2/19 10:32
     **/
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 方法描述: <br>
     * <p> 递归实现查询 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/19 10:35
     * @param word
     * @return boolean
     * @ReviseName
     * @ReviseTime 2021/2/19 10:35
     **/
    public boolean containsNew(String word) {
        return containsNew(root,word,0);
    }

    private boolean containsNew(Node node, String word, int index) {
        if (word.length() == index) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        }
        return containsNew(node.next.get(c),word,index+1);
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }


}
