package com.doyenm.interrogation;

import com.doyenm.InfoDto;

public class AnswerVerification {

    public boolean checkAnswer(InfoDto dto){
        return dto.getSelectedAnswer().getValue().equalsIgnoreCase(dto.getAnswer());
    }
}
