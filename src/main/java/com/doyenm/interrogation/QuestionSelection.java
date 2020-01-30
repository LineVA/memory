package com.doyenm.interrogation;

import com.doyenm.AnswerPair;
import com.doyenm.InfoDto;
import com.doyenm.QuestionPair;

import java.util.Random;

public class QuestionSelection {

    private final Random random = new Random();

    public InfoDto selectQuestion(InfoDto dto) {
        int selectedLineIndex = random.nextInt(dto.getInfoLists().size());
        int selectedQuestionIndex = random.nextInt(dto.getInfoLists().get(selectedLineIndex).size());
        int selectedAnswerIndex = random.nextInt(dto.getInfoLists().get(selectedLineIndex).size());
        // If we have selected the same column of the given line for the question and the answer
        while (selectedQuestionIndex == selectedAnswerIndex) {
            selectedAnswerIndex = random.nextInt(dto.getInfoLists().get(selectedLineIndex).size());
        }
        String selectedQuestion = dto.getInfoLists().get(selectedLineIndex).get(selectedQuestionIndex).getValue();
        dto.setSelectedQuestion(
                QuestionPair.builder()
                        .value(selectedQuestion)
                        .legend(dto.getLegends().get(selectedQuestionIndex))
                        .build()
        );
        dto.setSelectedAnswer(
                AnswerPair.builder()
                        .value(dto.getInfoLists().get(selectedLineIndex).get(selectedAnswerIndex))
                        .legend(dto.getLegends().get(selectedAnswerIndex))
                        .build()
        );
        return dto;
    }
}
