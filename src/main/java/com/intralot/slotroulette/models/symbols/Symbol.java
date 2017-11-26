package com.intralot.slotroulette.models.symbols;


import com.intralot.slotroulette.models.bet.ComboType;
import com.intralot.slotroulette.utils.Calculator;


public class Symbol
{
    private SymbolType symbolType;
    private int        frequency;
    private double     spinProbability;
    private double     spinWinnings;

    public Symbol(int numberOfSlots, SymbolType symbolType, int frequency)
    {
        this.symbolType    = symbolType;
        this.frequency     = frequency;

        this.spinProbability = Calculator.calculateProbability(numberOfSlots, frequency);
        this.spinWinnings    = Calculator.calculateSpinWinnings(this.spinProbability, this.frequency);
    }

    public SymbolType getSymbolType()
    {
        return symbolType;
    }

    public int getFrequency()
    {
        return frequency;
    }

    public double getSpinProbability()
    {
        return spinProbability;
    }

    public double getSpinWinnings()
    {
        return spinWinnings;
    }

    public double getComboProbability(ComboType comboType)
    {
        if (comboType == null)
            throw new RuntimeException("Should not happen - comboType : " + comboType);

       return Calculator.calculateComboProbability(getSpinProbability(), comboType.getIndex());
    }

    public double getComboWinnings(ComboType comboType)
    {
        if (comboType == null)
            return 0;

        return  Calculator.calculateComboWinnings(getSpinWinnings(), comboType.getIndex());
    }
}
