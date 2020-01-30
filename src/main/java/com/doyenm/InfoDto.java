package com.doyenm;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class InfoDto {

    private List<String> legends;
    private List<List<ListDto>> infoLists;
    @Setter
    private QuestionPair selectedQuestion;
    @Setter
    private AnswerPair selectedAnswer;
    @Setter
    private String answer;

    private boolean direct = true;
    private boolean reverse = true;
}
