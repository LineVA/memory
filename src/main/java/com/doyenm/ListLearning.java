package com.doyenm;

import com.doyenm.interrogation.AnswerVerification;
import com.doyenm.interrogation.QuestionSelection;
import com.doyenm.parsing.CommandLineDto;
import com.doyenm.parsing.CommandLineParsing;
import com.doyenm.parsing.ListParsing;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
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
            log.info("Nouvelle boucle");
            dto = questionSelection.selectQuestion(dto);
            log.info(dto.getSelectedQuestion().getValue());
            System.out.println(dto.getSelectedQuestion().getValue() +  " (" + dto.getSelectedAnswer().getLegend() + ") ? ");
            dto.setAnswer(in.nextLine());
            log.info(dto.getAnswer());
            if(answerVerification.checkAnswer(dto)){
                System.out.println("OK");
            } else {
                System.out.println("KO : " + dto.getSelectedAnswer().getValue().toString());
            }
        }
    }
}
