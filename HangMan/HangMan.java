package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HangMan
{
    private final Scanner scanner = new Scanner(System.in);
    private String word;
    private boolean correctAnswer = false;
    private int count = 0;
    private String[] guessTable;
    private String[][] map=
            {{"+","--","--","+"," "},
            {"|","  ","  "," "," "},
            {"|","  ","  "," ","  "},
            {"|","  ","  ","  "," "},
            {"|","  ","  "," ","  " }};

    public void playGame()
    {
        printMap();
        if(count == 7)
        {
            System.out.println("You died!");
            count++;
            return;
        }
        checkGuessTable();
            String input = scanner.next();
        for (int i = 0; i < word.length(); i++) {
            if(input.equals(String.valueOf(word.charAt(i)))) {
                if(guessTable[i].equals(input))
                    continue;
                guessTable[i] = input;
                correctAnswer = true;
                break;
            }
        }

        if(!correctAnswer)
        {   count++;
            switch (count)
            {
                case 1 -> map[1][3] = "O";
                case 2 -> map[2][3] = "|";
                case 3 -> map[2][2] = " /";
                case 4 -> map[2][4] = "\\";
                case 5 -> map[3][3] = "|";
                case 6 -> map[4][2] = " /";
                case 7 -> map[4][4] = "\\";
            }

        }
        correctAnswer = false;
    }
    public  void printMap()
    {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < guessTable.length; i++) {
            System.out.print(guessTable[i]);
        }
        System.out.println("");

    }
    public int getCount(){
        return count;
    }

    public void setWord(String word){
        this.word = word;
        setGuessTable(word);
    }
    private void setGuessTable(String word){
        String[] arr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if(String.valueOf(word.charAt(i)).equals(" "))
                 arr[i] = " ";
            else
                arr[i] = "_";
        }
        this.guessTable = arr;
    }
    private void checkGuessTable()
    {

        for (int i = 0; i < guessTable.length; i++)
        {
            if(guessTable[i].equals("_"))
                break;
            if(i== (guessTable.length-1)&& !guessTable[i].equals("_")){
                System.out.println("You won the game!");
                count = 8;
                return;
            }

        }
    }

}
