package com.example.planoramarsp.Service;

import com.example.planoramarsp.Model.Game;
import com.example.planoramarsp.Repository.GameRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

        public InitializerBean(GameService gameService, GameRepository gameRepository) {
            Game game1 = new Game("ROCK", "PAPER", "PLAYER WON");
            Game game2 = new Game("ROCK", "ROCK", "DRAW");
            gameService.persistCurrentGame("ROCK", "PAPER", "PLAYER WON");
            gameService.persistCurrentGame("ROCK", "ROCK", "DRAW");

        }

}


