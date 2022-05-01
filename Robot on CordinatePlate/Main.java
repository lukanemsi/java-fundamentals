package com.company;


import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("");
        RobotSimulator robot = new RobotSimulator("east",new int[]{7,3});
        robot.actAsInstructionSays("raalal");
        System.out.println(robot);
    }

}
