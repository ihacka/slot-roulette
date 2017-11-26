package com.intralot.slotroulette.models.bet;


public enum ComboType
{
    X2(2) ,
    X3(3);

    private int index;

    ComboType(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public static  ComboType getComboType(int comboOrdinal)
    {
        if (comboOrdinal < 0 || comboOrdinal >= values().length)
            return null;

        return values()[comboOrdinal];
    }
}
