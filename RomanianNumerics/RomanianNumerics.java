package com.company;

import java.util.HashMap;

public class RomanianNumerics
{
    private static final HashMap<Integer,String> romanian = new HashMap<>();

    private static void setRomanian()
    {
        romanian.put(1000, "M");
        romanian.put(900, "CM");
        romanian.put(500, "D");
        romanian.put(400, "CD");
        romanian.put(100, "C");
        romanian.put(90, "XC");
        romanian.put(50, "L");
        romanian.put(40, "XL");
        romanian.put(10, "X");
        romanian.put(9, "IX");
        romanian.put(5, "V");
        romanian.put(4, "IV");
        romanian.put(1, "I");
    }
    public static String transcript(int number)
    {
        setRomanian();
        return arabicToRomanian(number);
    }
    private static String arabicToRomanian(int number)
    {
        if (number <= 0)
            return "";
        int maxOfRomanian = 0;
        var keys = romanian.keySet();
        for (Integer key : keys){if (number >= key && maxOfRomanian < key) maxOfRomanian = key;}

        return romanian.get(maxOfRomanian) + arabicToRomanian(number - maxOfRomanian);
    }
}
