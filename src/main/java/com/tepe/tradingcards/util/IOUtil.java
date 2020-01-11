package com.tepe.tradingcards.util;

import java.util.Objects;
import java.util.Scanner;

public class IOUtil {
    private static volatile IOUtil instance;

    private IOUtil(){}

    public static IOUtil getInstance() {
        if(Objects.isNull(instance)) {
            instance = new IOUtil();
        }
        return instance;
    }

    public void print(String output) {
        System.out.println(output);
    }

    public String askPlayableIdOrName(){
        System.out.println("Which card do you want to play? Enter either ID or Name of the Card. Enter invalid to skip turn");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printBreak() {
        System.out.println("---------------------------------------------------------------------------");
    }
}
