package org.example;

import org.example.domain.wiseSaying.controller.WiseSayingController;
import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;
    private final WiseSayingController wiseSayingController;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
        wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        makeSampleData();

        while (true) {
            System.out.print("명령) ");
            final String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();

            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList(wiseSayings);
            
            } else if (cmd.startsWith("삭제")) {
                // 명언을 삭제할 때
                // 삭제?id=5 이 넘어온다는걸 App이 알아야하는가? = 아니다.
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                wiseSayingController.actionDelete(id, wiseSayings);

            } else if (cmd.startsWith("수정")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionModify(id);

            }
        }
        scanner.close();
    }

    private void makeSampleData() {
        addWiseSaying( "이순신 장군","나의 죽음을 적에게 알리지 말라.");
        addWiseSaying( "소크라테스","너 자신을 알라.");
    }

    private WiseSaying addWiseSaying(String author, String content) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

// 액션 함수
    private void actionAdd() {
        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.print("명언:");
        String content = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private void actionModify(int id) {
        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id){
                foundWiseSaying = wiseSaying;
                break;
            }

            if (foundWiseSaying == null) {
                System.out.println("%s번 명언은 존재하지 않습니다.".formatted(id));
                return;
            }
            System.out.print("(기존)작가: %d".formatted(foundWiseSaying.getAuthor()));
            System.out.print("작가:");
            String author = scanner.nextLine();

            System.out.print("(기존)작가: %d".formatted(foundWiseSaying.getContent()));
            System.out.print("명언:");
            String content = scanner.nextLine();

            foundWiseSaying.setAuthor(author);
            foundWiseSaying.setContent(content);

            System.out.println("%s번 명언이 수정되었습니다.".formatted(id));
        }
    }

}
