package org.example.domain.wiseSaying.controller;

import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WiseSayingController {
    private final Scanner scanner;
    private final List<WiseSaying> wiseSayings;
    private int id;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayings = new ArrayList<>();
        this.id = 0;
    }

    private WiseSaying addWiseSaying(String author, String content) {
        ++id;

        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public void makeSampleData() {
        addWiseSaying("이순신 장군","나의 죽음을 적에게 알리지 말라.");
        addWiseSaying("소크라테스","너 자신을 알라.");
    }

    public void actionAdd() {
        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.print("명언:");
        String content = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언\n" + "----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    public void actionDelete(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        if (removed) System.out.println("%d번 명언이 삭제되었습니다".formatted(id));
        else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    public void actionModify(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id){
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("(기존)작가: %s".formatted(foundWiseSaying.getAuthor()));
        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.println("(기존)명언: %s".formatted(foundWiseSaying.getContent()));
        System.out.print("명언:");
        String content = scanner.nextLine();

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }
}
