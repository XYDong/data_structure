package com.company.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 功能描述: <br>
 * <p>〈〉</p>
 *
 * @author Joker
 * @ClassName Solution
 * @date 2020/12/22 14:57
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/22 14:57
 */
public class Solution {
    public static boolean isValid(String s) {
        List<Character> data = Arrays.asList('(','[','{');
        List<Character> data2 = Arrays.asList(')',']','}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (data.contains(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (c == ')' && pop != '(') {
                        return false;
                    }
                    if (c == ']' && pop != '[') {
                        return false;
                    }
                    if ( c== '}' && pop != '{') {
                        return false;
                    }
                } else if (data2.contains(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        List<String> data = Arrays.asList("+","D","C");
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (i == 0 && data.contains(op)) {
                return 0;
            }
            if (op.matches("(-|\\+)?\\d+")) {
                stack.push(Integer.valueOf(op));
            } else {
                if (stack.isEmpty()) {
                    return 0;
                } else if ("+".equals(op) && stack.size() > 1 ){
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    Integer pop3 = pop1 + pop2;
                    stack.push(pop2);
                    stack.push(pop1);
                    stack.push(pop3);
                } else if ("D".equals(op)) {
                    Integer pop = stack.pop();
                    stack.push(pop);
                    stack.push( pop * 2);
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty() ? 0 : getCount(stack);
    }
    public static int calPoints2(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.matches("(-|\\+)?\\d+")) {
                stack.push(Integer.valueOf(op));
            }
            if (stack.isEmpty()) {
                return 0;
            }
            if ("+".equals(op) && stack.size() > 1 ){
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                Integer pop3 = pop1 + pop2;
                stack.push(pop2);
                stack.push(pop1);
                stack.push(pop3);
            }
            if ("D".equals(op)) {
                Integer pop = stack.pop();
                stack.push(pop);
                stack.push( pop * 2);
            }
            if ("C".equals(op)){
                stack.pop();
            }
        }
        return stack.isEmpty() ? 0 : getCount(stack);
    }

    private static int getCount(Stack<Integer> stack) {
        Integer count = 0;
        for (int size = stack.size(); size > 0; size--) {
            count += stack.pop();
        }
        return count;
    }

    public static void main(String[] args) {
        int valid = calPoints2(new String[]{"5","2","C","D","+"});
        System.out.println(valid);
    }
}
