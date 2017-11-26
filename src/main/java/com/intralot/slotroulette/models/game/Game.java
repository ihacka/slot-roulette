package com.intralot.slotroulette.models.game;

import com.intralot.slotroulette.models.bet.Bet;
import com.intralot.slotroulette.models.bet.ComboType;
import com.intralot.slotroulette.models.symbols.Symbol;
import com.intralot.slotroulette.models.symbols.SymbolType;
import org.apache.commons.math3.util.Pair;


public class Game
{

    private GameConfiguration gameConfig;

    //@Autowired
    public Game(GameConfiguration gameConfiguration)//GameConfiguration gameConfig)
    {
        this.gameConfig = gameConfiguration;
    }


    public void spin(Bet bet)
    {
        Symbol[] symbols = new Symbol[3];

        System.out.println("--------------------------------------");
        System.out.println("---              BETS              ---");
        System.out.println("--------------------------------------");
        for (int i = 0 ; i < bet.getSymbolType().length; i++)
        {
            System.out.println("Reel at [" + i + "]" + " Selected Symbol [" + bet.getSymbolType()[i].name() + "] Bet [" + bet.getStake()[i] + "]");
        }
        if (bet.getCombination() != null)
        {
            System.out.println("Combo on [ " + bet.getCombination().getSymbolType() + "] Type [ " + bet.getCombination().getComboType() + " ]");
        }
        System.out.println("--------------------------------------\n\n\n");

        System.out.println("--------------------------------------");
        System.out.println("---             SPINS              ---");
        System.out.println("--------------------------------------");
        for (int i = 0 ; i < gameConfig.getNumberOfReels() ; i++)
        {
            symbols[i] = spinReel();
            System.out.println("Spin [" + i +" ] Result [ " + symbols[i].getSymbolType().name() + " ]");
        }
        System.out.println("--------------------------------------\n\n\n");

        System.out.println("--------------------------------------");
        System.out.println("---            RESULTS             ---");
        System.out.println("--------------------------------------");
        Pair<Boolean, Double> spinResults = getResult(bet, symbols);



        System.out.println("Combo won [ " + spinResults.getKey() + " ] Winnings [ "+ spinResults.getValue() + " ]");
        System.out.println("--------------------------------------");
    }


    private Symbol spinReel()
    {
        double r           = Math.random() * gameConfig.getCompleteWeight();
        double countWeight = 0.0;

        for (Symbol symbol : gameConfig.getSymbols())
        {
            countWeight += symbol.getFrequency();
            if (countWeight >= r)
                return symbol;
        }
        throw new RuntimeException("Should never be shown.");
    }


    private Pair<Boolean, Double> getResult(Bet bet, Symbol[] spinResults)
    {
        SymbolType[] bets = bet.getSymbolType();

        Symbol       previousSymbol = null;
        int          comboOrdinal   = -1;
        double       winnings       = 0;

        for (int i = 0 ; i < bets.length ; i++)
        {
            SymbolType symbolType = bets[i];
            Symbol     symbol     = gameConfig.getSymbol(symbolType);

            if (spinResults[i].getSymbolType() == symbolType)
            {
                winnings += symbol.getSpinWinnings() * bet.getStake()[i];

                if (i == 0)
                {
                    previousSymbol = symbol;
                }
                else
                {
                    if (symbol == previousSymbol)
                    {
                        comboOrdinal++;
                    }
                    else
                    {
                        previousSymbol = null;
                        comboOrdinal   = -1;
                    }
                }
            }

            // check for combo
            if (bet.getCombination() != null)
            {
                if (comboOrdinal != -1)
                {
                    ComboType comboType = ComboType.getComboType(comboOrdinal);
                    winnings += previousSymbol != null ? previousSymbol.getComboWinnings(comboType) * bet.getStake()[i] : winnings;
                }
            }
        }

        return new Pair<>(comboOrdinal != -1, winnings);
    }
}
