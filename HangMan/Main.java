package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        HangMan hangMan = new HangMan();
        String next = input.nextLine();
        hangMan.setWord(next);
        while(hangMan.getCount() <= 7){
            hangMan.playGame();
        }

    }
}
