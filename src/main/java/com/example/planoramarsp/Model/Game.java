package com.example.planoramarsp.Model;

import javax.persistence.*;

@Entity
@Table(name = "`game_table`")
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private java.lang.String playerChoice;

    @Column(unique = true, nullable = false)
    private java.lang.String aiChoice;

    @Column(unique = true, nullable = false)
    private String resultOfGame;

    public Game() {
    }

    public Game(String playerChoice, String  aiChoice, String resultOfGame) {
        this.playerChoice = playerChoice;
        this.aiChoice = aiChoice;
        this.resultOfGame = resultOfGame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(java.lang.String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public java.lang.String getAiChoice() {
        return aiChoice;
    }

    public void setAiChoice(java.lang.String aiChoice) {
        this.aiChoice = aiChoice;
    }

    public String getResultOfGame() {
        return resultOfGame;
    }

    public void setResultOfGame(String resultOfGame) {
        this.resultOfGame = resultOfGame;
    }
}
