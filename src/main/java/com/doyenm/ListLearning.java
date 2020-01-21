package com.doyenm;

import com.doyenm.interrogation.AnswerVerification;
import com.doyenm.interrogation.QuestionSelection;
import com.doyenm.parsing.CommandLineDto;
import com.doyenm.parsing.CommandLineParsing;
import com.doyenm.parsing.ListParsing;

import java.util.Scanner;

public class ListLearning {

    private static final ListParsing parsing = new ListParsing();
    private static final CommandLineParsing commandLineParsing = new CommandLineParsing();
    private static final QuestionSelection questionSelection = new QuestionSelection();
    private static final AnswerVerification answerVerification = new AnswerVerification();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        CommandLineDto commandLineDto = commandLineParsing.parse(args);
        InfoDto dto = parsing.parse(commandLineDto);


        while(true){
            dto = questionSelection.selectQuestion(dto);
            System.out.println(dto.getSelectedQuestion().getValue() +  " (" + dto.getSelectedAnswer().getLegend() + ") ? ");
            dto.setAnswer(in.nextLine());
            if(answerVerification.checkAnswer(dto)){
                System.out.println("OK");
            } else {
                System.out.println("KO : " + dto.getSelectedAnswer().getValue());
            }
        }
    }
}
