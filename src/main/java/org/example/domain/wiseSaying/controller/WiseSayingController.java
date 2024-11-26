package org.example.domain.wiseSaying.controller;

import org.example.domain.wiseSaying.entity.WiseSaying;
import java.util.List;

public class WiseSayingController {

    public void actionList(List<WiseSaying> wiseSayings) {
        System.out.println("번호 / 작가 / 명언\n" + "----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }
}
