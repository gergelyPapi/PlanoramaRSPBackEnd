package com.example.planoramarsp.Service;

import com.example.planoramarsp.Model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private ArrayList gameResultList = new ArrayList();

    public List<Game> getAllGames() {
        ArrayList allGameList;
        allGameList = gameResultList;
        return allGameList;
    }

    public void persistCurrentGame(String currentPlayerChoice, String currentAiChoice, String currentResult) {
        Game gameToPersist = new Game(currentPlayerChoice, currentAiChoice, currentResult);
        gameResultList.add(gameToPersist);
    }

    public String makeDecision(String currentPlayerChoice, String currentAiChoice) {
        if (currentPlayerChoice == "ROCK" && currentAiChoice == "SCISSORS") {
            return "PLAYER";
        } else if (currentPlayerChoice == "SCISSORS" && currentAiChoice == "ROCK") {
            return "AI";
        } else if ((currentPlayerChoice == "SCISSORS" && currentAiChoice == "PAPER")) {
            return "PLAYER";
        } else if ((currentPlayerChoice == "PAPER" && currentAiChoice == "SCISSORS")) {
                return "AI";
        } else if ((currentPlayerChoice == "ROCK" && currentAiChoice == "PAPER")) {
            return "AI";
        } else if (currentPlayerChoice == "PAPER" && currentAiChoice == "ROCK") {
            return "PLAYER";
        } else {
            return "DRAW";
        }
    }
}
