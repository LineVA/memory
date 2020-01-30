package com.doyenm;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LineDto {
    private final String descriptor;
    private final List<String> values;
}
