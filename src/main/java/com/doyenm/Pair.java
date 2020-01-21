package com.doyenm;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Pair {
    private final String legend;
    private final String value;
}
