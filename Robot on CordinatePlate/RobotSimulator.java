package com.company;

import java.util.Arrays;
import java.util.Locale;

public class RobotSimulator
{
    private String direction;
    private int directionIndex;
    private int[] coordinate;
    private String instructions;
    private final String[] legalDirs = {"north", "east" ,"south" ,"west"};


    public RobotSimulator(String direction,int[] coordinate)
    {
        setCoordinate(coordinate);
        setDirection(direction);
    }
    public void actAsInstructionSays(String instructions)
    {
        setInscturctions(instructions);
        for (int i = 0; i < this.instructions.length(); i++)
        {
            switch (this.instructions.charAt(i))
            {
                case 'a' -> {
                    if(directionIndex % 2 == 0)
                    {
                       if(directionIndex == 0) coordinate[1]++;
                       else coordinate[1]--;
                    }
                    else
                    {
                        if(directionIndex == 1) coordinate[0]++;
                        else coordinate[0]--;
                    }
                }
                case 'r' -> changeDir('r');
                case 'l' -> changeDir('l');
            }
        }
    }
    private void changeDir(char inst)
    {
        int findDirIndex = 0;
        for (int i = 0; i < legalDirs.length; i++)
        {
            if(direction.equals(legalDirs[i]))
                findDirIndex = i;
        }

        if(inst == 'l')
        {
            if(findDirIndex == 0) findDirIndex = 3;
            else findDirIndex --;
        }
        else if(inst == 'r')
        {
            if(findDirIndex == 3) findDirIndex = 0;
            else findDirIndex++;

        }
        this.directionIndex = findDirIndex;
        this.direction = legalDirs[directionIndex];
    }
    private void setInscturctions(String inscturctions)
    {
        String lowerInstructions = inscturctions.toLowerCase(Locale.ROOT);
        for (int i = 0; i < lowerInstructions.length(); i++)
        {
            if(lowerInstructions.charAt(i) != 'a' && lowerInstructions.charAt(i) != 'r' && lowerInstructions.charAt(i) != 'l')
                throw new IllegalArgumentException("Illegal instructions");
        }
        this.instructions = lowerInstructions;
    }
    private void setDirection(String direction)
    {
        boolean isInputLegal = false;
        for (int i = 0; i < legalDirs.length; i++)
        {
            if(direction == legalDirs[i]) isInputLegal = true;

        }

        if(!isInputLegal) throw new IllegalArgumentException("Direction is given wrong");
        else this.direction = direction;
    }
    private void setCoordinate(int[] coordinate)
    {
        if (coordinate.length == 2) this.coordinate = coordinate;
        else throw new IllegalArgumentException("Coordinate should have only 2 arguments");
    }
    @Override
    public String toString() {
        return "RobotSimulator{" +
                "direction='" + direction + '\'' +
                ", coordinate=" + Arrays.toString(coordinate) +
                '}';
    }
}

