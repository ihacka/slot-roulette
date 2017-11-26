package com.intralot.slotroulette.models.bet;


import com.intralot.slotroulette.models.bet.Bet;
import com.intralot.slotroulette.models.symbols.SymbolType;

public class Result
{
    private SymbolType[] symbols;

    private double       winnings;
    private boolean      comboWon;

    private Bet bet;

    public Result(SymbolType[] symbols , double winnings,  boolean comboWon, Bet bet )
    {
        this.symbols  = symbols;
        this.winnings = winnings;
        this.comboWon = comboWon;

        this.bet      = bet;
    }
}
