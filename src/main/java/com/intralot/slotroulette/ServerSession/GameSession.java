package com.intralot.slotroulette.ServerSession;

import com.intralot.slotroulette.models.game.Game;
import com.intralot.slotroulette.models.game.GameConfiguration;
import com.intralot.slotroulette.models.bet.Bet;
import com.intralot.slotroulette.models.bet.Combination;
import com.intralot.slotroulette.models.bet.ComboType;
import com.intralot.slotroulette.models.symbols.*;

import java.util.Random;


public class GameSession
{
    private Game game;

    public GameSession(GameConfiguration gameConfiguration)
    {
        Game game = new Game(gameConfiguration);
        Random random = new Random();


        for (int i = 0 ; i < 1 ; i++)
        {
            int[]     stake       = new int[]{Math.abs(random.nextInt(100)), Math.abs(random.nextInt(100))};
            SymbolType randomSymbol = SymbolType.values()[random.nextInt(SymbolType.values().length - 1)];
            SymbolType randomSymbol1 = SymbolType.values()[random.nextInt(SymbolType.values().length - 1)];
            SymbolType randomSymbol2 = SymbolType.values()[random.nextInt(SymbolType.values().length - 1)];

            SymbolType[] symbolTypes = new SymbolType[]{randomSymbol, randomSymbol1};
            Combination  combination = new Combination(randomSymbol2, ComboType.X2);
            Bet          bet         = new Bet(stake, symbolTypes, combination);
            game.spin(bet);
        }
    }
}
