package com.doyenm.parsing;

import com.doyenm.InfoDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListParsing {

    public InfoDto parse(CommandLineDto dto){
        try (Stream<String> stream = Files.lines(Paths.get(dto.getPath()))) {
            List<String> lines = stream.collect(Collectors.toList());

            List<String> legends =  Arrays.asList(lines.get(0).split(" : "));

            lines.remove(0);
            List<String> values;
            List<List<String>> allValues = new ArrayList<>();
            for(String line : lines){
                values = Arrays.asList(line.split(" : "));
                allValues.add(values);
            }
            return InfoDto.builder()
                    .infoLists(allValues)
                    .legends(legends)
                    .build();
        } catch(IOException ex){
            System.out.println(ex);
            return null;
        }

    }


}
