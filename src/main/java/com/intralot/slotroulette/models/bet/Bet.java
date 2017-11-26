package com.intralot.slotroulette.models.bet;


import com.intralot.slotroulette.models.symbols.SymbolType;

public class Bet
{
    private int[]        stake;
    private SymbolType[] symbolType;
    private Combination  combination;


    public Bet(int[] stake, SymbolType[] symbolType, Combination combination)
    {
        this.stake       = stake;
        this.symbolType  = symbolType;
        this.combination = combination;
    }


    public SymbolType[] getSymbolType()
    {
        return symbolType;
    }

    public Combination getCombination()
    {
        return combination;
    }

    public int[] getStake()
    {
        return stake;
    }
}
