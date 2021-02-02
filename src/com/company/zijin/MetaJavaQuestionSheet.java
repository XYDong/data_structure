package com.company.zijin;


/**
 * @version 1.0.0
 * @ClassName mate_java_夏远东.java
 * @Package com.company.zijin
 * @Author Joker
 * @Description 本试卷唯一 ID: 5BF5B35C12DA49C6E8C5B5FDE3A61D02, 请勿修改本行内容
 * @CreateTime 2021年01月29日 13:46:00
 */
// 本试卷唯一 ID: CBCAEB12F0A6CCA4A79E31E4CE9C5A65, 请勿修改本行内容
/* 注意, 这里不要写包名. 留空 */
/* 这里如果用到其他的类, 记得要引用, 否则编译不过 */
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 回答方式: 直接保存或者复制本java文件, 然后在原处作答. 建议重命名成 meta-java-<姓名>.java
 * 选择题改变量赋值的字符串
 * 实现题在原本的函数体里返回正确答案, 注意不要改动函数结构. 用这一个Java文件完成
 * 本卷直接用代码判卷, 没有人工干预. 格式错误, 语法错误, 格式改动会导致试卷无效
 *
 * 注: 一个java文件可以有多个类, 但只能有一个public类. 所以你的实现中可以建内部类, 辅助类. 可以javac编译确认自己语法无误
 * 以下带public static修饰的实现题方法, 不要改变这个签名
 *
 *
 * 这里不要更改默认的类名, 也不要更改修饰符不要加public. 类名保持为 MetaJavaQuestionSheet
 * 可以改文件名, 建议改为 meta-java-<姓名>.java
 */
public class MetaJavaQuestionSheet {

    /* ============
     *  以下是实现题
     * ============
     */

    /**
     * 对字符串进行去重处理，并且保持原来的输入顺序。举例：
     * 输入的字符串 String  s = "ADABEFFFDCBGH发货价啦AFG"；
     * 经过处理之后结果应该是："ADBEFCGH发货价啦"
     * （考虑时间复杂度, 要求时间复杂度O(n)）
     *
     * @param str: 要去重的字符串
     * @return: 去重后的字符串
     */
    public static String removeDuplicate(String str) {
        // TODO: Your Code Here
        // 使用栈处理
        ConcurrentLinkedQueue<Character> queue = new ConcurrentLinkedQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 对每一个字符进行判断
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
                if (!queue.contains(c)) {
                    queue.add(c);
                }
            }
            if((c >= 0x4e00)&&(c <= 0x9fbb)) {
                stringBuilder.append(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        sb.append(stringBuilder);
        return sb.toString();
    }


    /**
     * 两个大数相加。
     * String numA = "5135156864146198510515713546981304...";
     * String numB = "14105283157813257031975091759832782750923...";
     * 两个字符串长度不一定相等，都可能特别长，甚至超过long的范围。求numA 和 numB的和（两个数字都是正整数）。
     *
     * ** 注意：不能直接使用 Java BigDecimal 系列 API**
     *
     * @param numA: 加数
     * @param numB: 加数
     */
    public static String addStrings(String numA, String numB) {
        if (numA.length() > numB.length()) {
            int diff = numA.length() - numB.length();
            numB = fillZero(numB, diff);
        }
        if (numA.length() < numB.length()) {
            int diff = numB.length() - numA.length();
            numA = fillZero(numA, diff);
        }
        char[] arr1 = numA.toCharArray();
        char[] arr2 = numB.toCharArray();
        StringBuffer result = new StringBuffer();
        int i = arr1.length - 1;
        int carryFlag = 0;
        int c0 = '0';
        while (i >= 0) {
            int temp = arr1[i] + arr2[i] - 2 * c0 + carryFlag;
            carryFlag = 0;
            if (temp >= 10) {
                temp -= 10;
                carryFlag = 1;
            }
            result.insert(0, temp);
            i--;
        }
        if (carryFlag == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }

    private static String fillZero(String str, int diff) {
        StringBuffer sb = new StringBuffer(str);
        StringBuffer zeros = new StringBuffer();
        for (int i = 0; i < diff; i++) {
            zeros.insert(0, "0");
        }
        sb.insert(0, zeros);
        return sb.toString();
    }

    public static void main(String[] args) {
        // slution1
        System.out.println(removeDuplicate("ADABEFFFDCBGH发货价啦AFG"));
        System.out.println();
        // slution1
        System.out.println(addStrings("5135156864146198510515713546981304","14105283157813257031975091759832782750923"));
    }
}
