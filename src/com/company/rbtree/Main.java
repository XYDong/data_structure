package com.company.rbtree;

import com.company.avltree.AVLTree;
import com.company.map.BSTMap;
import com.company.utils.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @version 1.0.0
 * @ClassName Main2.java
 * @Package com.company.avltree
 * @Author Joker
 * @Description ceshi
 * @CreateTime 2021年02月25日 15:30:00
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("sources/pride-and-prejudice.txt",words)) {
            Collections.sort(words);
            System.out.println("Total words: " + words.size());
            RBTree<String, Integer> bst = new RBTree<>();
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
            System.out.println("RBTree : " + time + "s");
            System.out.println("-------------------------------------------");
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            long startTime2 = System.nanoTime();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.setValue(word,avlTree.getValue(word) + 1);
                } else {
                    avlTree.add(word,1);
                }
            }
            for (String word : words) {
                avlTree.contains(word);
            }
            long endTime2 = System.nanoTime();
            double time2 =  (endTime2 - startTime2) / 1000000000.0;
            System.out.println("AVLTree : " + time2 + "s");
            System.out.println("-------------------------------------------");

        }
    }
}
