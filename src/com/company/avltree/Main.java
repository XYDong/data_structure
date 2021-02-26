package com.company.avltree;

import com.company.utils.FileOperation;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @ClassName Main.java
 * @Package com.company.avltree
 * @Author Joker
 * @Description 测试
 * @CreateTime 2021年02月25日 10:52:00
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("sources/pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.setValue(word,map.getValue(word) + 1);
                } else {
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.getValue("pride"));
            System.out.println("Frequency of PREJUDICE: " +map.getValue("prejudice"));
            System.out.println("isBalanced : " + map.isBalanced());

        }
        System.out.println();
    }
}
