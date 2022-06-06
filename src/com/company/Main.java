package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int learningNum = 2;
        int minMultiplication = 1;
        int maxMultiplication = 25;
        int cardSize = 5;
        int playerCount = 5;
        boolean teacherHasFormulas = true;
        FileGenerator fileGenerator = new FileGenerator();

        GamePlay game = new GamePlay(learningNum,
                minMultiplication,
                maxMultiplication,
                cardSize,
                playerCount,
                teacherHasFormulas);

        game.instantiateGame();
        game.printFullTimesTable();
        game.printPlayersChoices();
        game.printTeacherChoices();

        fileGenerator.generatePlayersCSV(game, "Player_Cards.csv");
        fileGenerator.generateTeacherCSV(game,"Teacher_Card.csv");

        System.out.println();
        System.out.println("DONE");

    }
}