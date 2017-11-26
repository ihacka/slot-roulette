package com.intralot.slotroulette.models.game;

import com.intralot.slotroulette.models.symbols.Symbol;
import com.intralot.slotroulette.models.symbols.SymbolType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GameConfiguration
{
    private int numberOfReels;

    private List<Symbol> symbols;

    private double completeWeight;

    private int numberOfSlots;

    @Autowired
    public GameConfiguration(@Value("${game.numberOfReels}")
                                  int numberOfReels, @Value("#{'${symbols.displayFrequency}'.split(',')}")
                                      List<Integer>    frequencesConf, @Value("#{'${symbols.type}'.split(',')}")
            List<SymbolType> symbolsConf)
    {
        this.numberOfReels = numberOfReels;
        this.symbols = new ArrayList<>(symbolsConf.size());

        for (int i = 0 ; i < frequencesConf.size() ; i++)
        {
            numberOfSlots += frequencesConf.get(i);
        }

        for (int i = 0 ; i < symbolsConf.size() ; i++)
        {
            Symbol symbol = new Symbol(numberOfSlots, symbolsConf.get(i), frequencesConf.get(i));
            symbols.add(symbol);

            completeWeight += symbol.getFrequency();

        }
    }

    public double getCompleteWeight()
    {
        return completeWeight;
    }

    public int getNumberOfReels()
    {
        return numberOfReels;
    }

    public List<Symbol> getSymbols()
    {
        return symbols;
    }

    public int getNumberOfSlots()
    {
        return numberOfSlots;
    }

    public Symbol getSymbol(SymbolType symbolType)
    {
        for (Symbol symbol : symbols)
        {
            if (symbol.getSymbolType() == symbolType)
                return symbol;
        }

        throw new RuntimeException("Should never be shown.");
    }
}
