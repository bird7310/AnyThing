package com.ahacool.anything;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountMain {

	private static final int MAX_NUMBER = 100;
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String WHIZZ = "Whizz";
	private static final int ZERO_INDEX = 0;
	private static final int FIRST_INDEX = 1;
	private static final int SECOND_INDEX = 2;
	private static final String EXIT_COMMAND = "qq";

	public static void main(String[] args) {
		System.out.println("请输入3个不重复的个位正整数,格式如下3;5;7;(输入qq退出)");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String inputString = scanner.next();
			if (EXIT_COMMAND.equals(inputString)) {
				System.out.println("同学们再见！");
				scanner.close();
				System.exit(0);
			}
			else {
				boolean flag = checkInput(inputString);
				if (flag) {
					int[] mumberArray = getNumberArray(inputString);
					numberOff(mumberArray);
					System.out.println("老师，报数结束！请再输入：");
				} else {
					System.out.println("老师，输入错误，请再次输入！");
				}
			}
		}
	}

	private static boolean checkInput(String pString) {
		String regex1 = "([1-9])";
		String regex2 = "(;)";
		String regex3 = "([1-9])";
		String regex4 = "(;)";
		String regex5 = "([1-9])";
		String regex6 = "(;)";

		Pattern pattern = Pattern.compile(regex1 + regex2 + regex3 + regex4 + regex5 + regex6, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(pString);
		return matcher.find();
	}

	private static int[] getNumberArray(String pString) {
		int[] numberArray = new int[] { 0, 0, 0 };
		String[] inputString = pString.split(";");
		int length = inputString.length;
		for (int i = 0; i < length; i++) {
			if (inputString[i] != null) {
				numberArray[i] = Integer.parseInt(inputString[i]);
			}
		}
		return numberArray;
	}

	private static void numberOff(int[] pArray) {
		for (int i = 0; i <= MAX_NUMBER; i++) {
			String count = String.valueOf(i);
			String firstNumber = String.valueOf(pArray[ZERO_INDEX]);
			// contain
			if (count.contains(firstNumber)) {
				System.out.println(FIZZ);
				continue;
			}
			// devide
			if (doDevide(i, pArray)) {
				System.out.println("");
			} else {
				System.out.println(count);
			}
		}
	}

	private static boolean doDevide(int pCount, int[] pArray) {
		boolean devideFlag = false;
		if (pCount % pArray[ZERO_INDEX] == 0) {
			devideFlag = true;
			System.out.print(FIZZ);
		}
		if (pCount % pArray[FIRST_INDEX] == 0) {
			devideFlag = true;
			System.out.print(BUZZ);
		}
		if (pCount % pArray[SECOND_INDEX] == 0) {
			devideFlag = true;
			System.out.print(WHIZZ);
		}
		return devideFlag;
	}

}
