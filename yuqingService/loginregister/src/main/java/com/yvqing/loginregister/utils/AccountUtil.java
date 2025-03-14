package com.yvqing.loginregister.utils;

import java.util.Random;

public class AccountUtil {

//    char [] letters = new char[]{'a',};
//    char [] capletters = new char[]{'A','B','C','D','E'};
//    int [] numbers = new int[]{0,1,2,3,4,5,6,7,8,9};

    public static String createAccount(){
        Random random = new Random();
        int[ ] accountArr = new int[6];
        String accountStr = new String();
        for (int i = 0; i < accountArr.length; i++) {
            accountArr[i] = random.nextInt(9);
            accountStr += accountArr[i];
        }
        return accountStr;
    }

    public static void main(String[] args) {
        String account = createAccount();
        System.out.println("test createAccount:"+account);
    }
}
