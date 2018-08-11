package com.dojo.madness.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
public class OverwatchApiResponse<T> {

    private List<T> data;
}
