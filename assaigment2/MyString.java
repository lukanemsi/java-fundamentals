package com.company;

import java.util.Arrays;

public class MyString {

    private char[] data;
    private MyString next;

    public MyString(char[] data) {
        this.data = data;

    }

    public String toString() {
        String text = "";
        for (char item :
                data) {
            text += item;
        }
        return text;
    }

    public boolean equals(MyString o)
    {
        if (o.data.length == this.data.length)
            for (int i = 0; i < o.data.length; i++)
                if (o.data[i] == this.data[i])
                    continue;
                else
                    return false;
        else
            return false;
        return true;
    }

    public void concat (char [] data)
    {
        char[] characters = new char[data.length + this.data.length];

        for (int i = 0; i < characters.length;i++)
        {
            characters[i] = this.data[i];
            if (this.data.length - 1 == i)
                break;
        }

        for (int i = 0; i < characters.length;i++) {
            characters[this.data.length  + i] = data[i];
            if(data.length - 1 == i)
                break;
        }
        this.data = characters;
    }

    public int length ()
    {
        int length = 0;
        for (var item: this.data)
            length++;

        return length;
    }

    public int indexOf (char c)
    {
        for (int i = 0; i < this.data.length; i++)
            if (this.data[i] == c)
              return i;

        return -1;
    }

    public int lastIndexOf (char c)
    {
        int index = -1;
        for (int i = 0; i < this.data.length; i++)
            if (this.data[i] == c)
                index = i;

        return index;
    }

}

