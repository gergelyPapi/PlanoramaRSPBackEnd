package com.example.planoramarsp.Controller;

import com.example.planoramarsp.Model.Game;
import com.example.planoramarsp.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/get-all-game-results", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> allGames;
        allGames = gameService.getAllGames();
        if (allGames == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allGames, HttpStatus.OK);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/get-game-result", method = RequestMethod.GET)
    public ResponseEntity<String> persistGame(@RequestBody Map<String, String> data){
        String currentPlayerChoice = data.get("playerChoice");
        String currentAiChoice = data.get("aiChoice");
        String gameResult = gameService.makeDecision(currentPlayerChoice, currentAiChoice);
        gameService.persistCurrentGame(currentPlayerChoice, currentAiChoice, gameResult);
        if (gameResult != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(gameResult, HttpStatus.OK);
        }
    }
}
