package com.intralot.slotroulette.ServerSession;

import com.intralot.slotroulette.models.game.GameConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameSessionManager
{
    @Autowired
    public GameSessionManager(GameConfiguration gameConfiguration)
    {
        createGameSession(gameConfiguration);
    }

    public void createGameSession(GameConfiguration gameConfiguration)
    {
        GameSession gameSession = new GameSession(gameConfiguration);
    }
}
