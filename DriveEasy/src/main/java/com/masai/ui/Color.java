package com.masai.ui;
public class Color {
	public static final String RESET = "\u001B[0m";

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String BG_BLACK = "\u001B[40m";
	public static final String BG_RED = "\u001B[41m";
	public static final String BG_GREEN = "\u001B[42m";
	public static final String BG_YELLOW = "\u001B[43m";
	public static final String BG_BLUE = "\u001B[44m";
	public static final String BG_MAGENTA = "\u001B[45m";
	public static final String BG_CYAN = "\u001B[46m";
	public static final String BG_WHITE = "\u001B[47m";

	public static void printColored(String text, String textColor, String bgColor) {
		System.out.print(textColor + bgColor + text + RESET);
	}

	public static void printlnColored(String text, String textColor, String bgColor) {
		System.out.println(textColor + bgColor + text + RESET);
	}

//	public static void main(String[] args) {
//		printColored("Hello, ", RED, BG_GREEN);
//		printlnColored("Colorful World!", BLUE, BG_YELLOW);
//	}
}
