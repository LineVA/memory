package com.doyenm;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class QuestionPair {
    private final String legend;
    private final String value;
}
