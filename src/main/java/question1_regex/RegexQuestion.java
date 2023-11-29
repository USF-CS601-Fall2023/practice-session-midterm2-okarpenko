package question1_regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuestion {

    /**
     * Write a function that takes a html file that contains information
     * about books in paragraph tags (such as input/books.html) and prints
     * information about each book to the console.
     * You are required to use regex groups (use Pattern and Matcher) for this problem.
     * Your code must be general.
     * @param filename
     */
    public static void extractBookInfo(String filename) {
       // FILL IN CODE

    }

    public static void main(String[] args) {
        RegexQuestion.extractBookInfo("input/books.html");
    }
}
