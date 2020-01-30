package com.doyenm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.*;

@RequiredArgsConstructor
@Getter
public class ListDto {

    private final Random random = new Random();

    private final List<String> values;

    public ListDto(String input) {
        String updatedInput = input;
        if (updatedInput.startsWith("(") && updatedInput.endsWith(")")) {
            updatedInput = updatedInput.replace("(", "");
            updatedInput = updatedInput.replace(")", "");
            values = Arrays.asList(updatedInput.split(" ; "));
        } else {
            values = Arrays.asList(updatedInput);
        }
    }

    public String getValue() {
        return values.get(random.nextInt(values.size()));
    }

    public boolean equals(String input) {
        if (values.size() == 1) {
            return values.get(0).equalsIgnoreCase(input);
        } else if (values.size() > 1) {
            List<String> inputs = Arrays.asList(input.split(", "));
            if (inputs.size() != values.size()) {
                return false;
            }
            Set<String> intersect = new HashSet<String>(inputs);
            intersect.retainAll(values);
            return inputs.size() == intersect.size();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String v : values){
            sb.append(v);
            sb.append(", ");
        }
        String output = sb.toString();
        return output.substring(0, output.length() - 2);
    }
}