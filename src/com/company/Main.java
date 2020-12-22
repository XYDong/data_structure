package com.company;

import com.company.array.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        array.add(1,100);
        System.out.println(array);
        array.add(1,-1);
        System.out.println(array);
        array.remove(2);
        System.out.println(array);
        array.removeElement(2);
        System.out.println(array);
    }
}
