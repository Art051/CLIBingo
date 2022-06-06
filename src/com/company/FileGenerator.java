package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileGenerator {

    private File cardsCSV;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;

    public FileGenerator() {
    }


    public void generatePlayersCSV(GamePlay game, String playersFileString) throws IOException {
        cardsCSV = new File(playersFileString);
        fileWriter = new FileWriter(cardsCSV);
        buffWriter = new BufferedWriter(fileWriter);
        for(Card card : game.getPlayerList()) {
            String cardSelections = card.getCardSelections().stream()
                    .collect(Collectors.joining(","));
            buffWriter.append(cardSelections);
            buffWriter.flush();
            buffWriter.newLine();
        }
    }

    public void generateTeacherCSV(GamePlay game, String teacherFileString) throws IOException {
        cardsCSV = new File(teacherFileString);
        fileWriter = new FileWriter(cardsCSV);
        buffWriter = new BufferedWriter(fileWriter);
        String cardSelections = game.getTeacherCard().getCardSelections().stream()
                .collect(Collectors.joining(","));
        buffWriter.append(cardSelections);
        buffWriter.flush();
    }
}
