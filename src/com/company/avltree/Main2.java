package com.company.avltree;

import com.company.map.BSTMap;
import com.company.utils.FileOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @version 1.0.0
 * @ClassName Main2.java
 * @Package com.company.avltree
 * @Author Joker
 * @Description ceshi
 * @CreateTime 2021年02月25日 15:30:00
 */
public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("sources/pride-and-prejudice.txt",words)) {
            Collections.sort(words);
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> bst = new AVLTree<>();
            long startTime = System.nanoTime();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.setValue(word,bst.getValue(word) + 1);
                } else {
                    bst.add(word,1);
                }
            }
            for (String word : words) {
                bst.contains(word);
            }
            long endTime = System.nanoTime();
            double time =  (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree : " + time + "s");
            System.out.println("-------------------------------------------");
//            BSTMap<String, Integer> map = new BSTMap<>();
//            long startTime1 = System.nanoTime();
//            for (String word : words) {
//                if (map.contains(word)) {
//                    map.setValue(word,map.getValue(word) + 1);
//                } else {
//                    map.add(word,1);
//                }
//            }
//            for (String word : words) {
//                map.contains(word);
//            }
//            long endTime1 = System.nanoTime();
//            double time1 =  (endTime1 - startTime1) / 1000000000.0;
//            System.out.println("bstmap : " + time1 + "s");
//            System.out.println("-------------------------------------------");
            for (String word : words) {
                bst.remove(word);
                if (!bst.isBalanced() || !bst.isBST()) {
                    throw new IllegalArgumentException("Error");
                }
            }

            System.out.println("success-------------------------------------------");

        }
    }
}
