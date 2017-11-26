package com.intralot.slotroulette.models.bet;


import com.intralot.slotroulette.models.symbols.SymbolType;

public class Combination
{
    private SymbolType symbolType;
    private ComboType  comboType;

    public Combination(SymbolType symbolType, ComboType comboType)
    {
       this.symbolType = symbolType;
       this.comboType = comboType;
    }

    public SymbolType getSymbolType()
    {
        return symbolType;
    }

    public ComboType getComboType()
    {
        return comboType;
    }
}
