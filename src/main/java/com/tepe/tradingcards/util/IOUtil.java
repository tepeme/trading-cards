package com.tepe.tradingcards.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Scanner;

public class IOUtil {
    private static IOUtil instance;
    private static Logger logger = LoggerFactory.getLogger(IOUtil.class);

    private IOUtil(){}

    public static IOUtil getInstance() {
        if(Objects.isNull(instance)) {
            instance = new IOUtil();
        }
        return instance;
    }

    public void print(String output) {
        logger.info(output);
    }

    public String askPlayableIdOrName(){
        logger.info("Which card do you want to play? Enter either ID or Name of the Card. Enter invalid to skip turn");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printBreak() {
        logger.info("---------------------------------------------------------------------------");
    }
}
