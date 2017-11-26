package com.intralot.slotroulette.utils;


public class Calculator
{
    public static double calculateProbability(int slots, double frequency)
    {
        return (frequency / (double)slots);
    }

    public static double calculateSpinWinnings(double probability, double frequency)
    {
        return 1 / probability ;
    }

    public static double calculateComboProbability(double spinProbability, int numOfReels)
    {
        return java.lang.Math.pow(spinProbability, numOfReels) ;
    }

    public static double calculateComboWinnings(double spinWinnings, int numOfReels )
    {
        return java.lang.Math.pow(spinWinnings , numOfReels);
    }
}
