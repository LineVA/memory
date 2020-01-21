package com.doyenm.interrogation;

import com.doyenm.InfoDto;
import com.doyenm.Pair;

import java.util.Random;

public class QuestionSelection {

    private final Random random = new Random();

    public InfoDto selectQuestion(InfoDto dto){
        int selectedLine = random.nextInt(dto.getInfoLists().size());
        int selectedQuestion = random.nextInt(dto.getInfoLists().get(selectedLine).size());
        int selectedAnswer = random.nextInt(dto.getInfoLists().get(selectedLine).size());
        while (selectedQuestion == selectedAnswer){
            selectedAnswer = random.nextInt(dto.getInfoLists().get(selectedLine).size());
        }
        dto.setSelectedQuestion(Pair.builder()
                .value(dto.getInfoLists().get(selectedLine).get(selectedQuestion))
                .legend(dto.getLegends().get(selectedQuestion))
                .build()
        );
        dto.setSelectedAnswer(Pair.builder()
                .value(dto.getInfoLists().get(selectedLine).get(selectedAnswer))
                .legend(dto.getLegends().get(selectedAnswer))
                .build()
        );
        return dto;
    }
}
