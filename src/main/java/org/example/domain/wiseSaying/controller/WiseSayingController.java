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

    public void actionDelete(String cmd, List<WiseSaying> wiseSayings) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        if (removed) System.out.println("%s번 명언이 삭제되었습니다".formatted(id));
        else System.out.println("%s번 명언은 존재하지 않습니다.".formatted(id));
    }
}
