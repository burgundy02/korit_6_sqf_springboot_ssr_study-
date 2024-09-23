package com.study.ssr.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Dvd {
    private String title;
    private String producer;
    private String publisher;
}
