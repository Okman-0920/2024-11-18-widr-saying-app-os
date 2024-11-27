package org.example.domain.domain.wiseSaying.controller;

import org.example.domain.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.wiseSayingService = new WiseSayingService();
        this.scanner = scanner;
    }

    public void makeSampleData() {
        wiseSayingService.add("이순신 장군","나의 죽음을 적에게 알리지 말라.");
        wiseSayingService.add("소크라테스","너 자신을 알라.");
    }

    public void actionAdd() {
        if (wiseSayingService.findAll().size() > 0) {
            wiseSayingService.removeAll();
        }

        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.print("명언:");
        String content = scanner.nextLine();

        WiseSaying wiseSaying = wiseSayingService.add(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언\n" + "----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    public void actionDelete(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayingService.removeById(id);

        if (removed) System.out.println("%d번 명언이 삭제되었습니다".formatted(id));
        else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    public void actionModify(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying foundWiseSaying = opWiseSaying.get();

        System.out.println("(기존)작가: %s".formatted(foundWiseSaying.getAuthor()));
        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.println("(기존)명언: %s".formatted(foundWiseSaying.getContent()));
        System.out.print("명언:");
        String content = scanner.nextLine();

        wiseSayingService.modify(foundWiseSaying, author, content);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }
}
