package com.doyenm;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class AnswerPair {
    private final String legend;
    private final ListDto value;
}
