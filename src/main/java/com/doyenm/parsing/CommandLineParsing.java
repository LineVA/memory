package com.doyenm.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CommandLineParsing {

    public CommandLineDto parse(String[] commandLine){
        File file = new File(commandLine[0]);
        String absolutePath = file.getAbsolutePath();

        List<String> orders = new ArrayList<>();

//         IntStream.range(0, commandLine.length - 1)
//                .filter(i -> "--orders".equals(commandLine[i]))
//                .findFirst()
//                 .ifPresentOrElse(i -> orders.add(commandLine[i+1]), null);



        return CommandLineDto.builder()
                .path(absolutePath)
                .build();
    }
}
