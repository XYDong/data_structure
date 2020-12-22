package com.company.stack;

/**
 * 功能描述: <br>
 * <p>〈〉</p>
 *
 * @author Joker
 * @ClassName StackTest
 * @date 2020/12/22 14:33
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/22 14:33
 */
public class StackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        Integer pop = stack.pop();
        System.out.println("栈顶为：" + pop);
        System.out.println(stack);

    }
}
