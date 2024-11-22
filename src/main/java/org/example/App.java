package org.example;

import java.util.Scanner;

class App {
    Scanner scanner;
    int lastId;
    WiseSaying[] wiseSayings;
    int wiseSayingsSize;

    public App() {
        private scanner = new Scanner(System.in);
        private lastId = 0;
        private wiseSayings = new WiseSaying[100];
        private wiseSayingsSize = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        addWiseSaying("나의 죽음을 적에게 알리지 말라.", "이순신 장군");
        addWiseSaying("너 자신을 알라.", "소크라테스");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();

            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
        scanner.close();
    }

    private WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings[wiseSayingsSize] = wiseSaying;
        wiseSayingsSize++;

        return wiseSaying;
    }


    private void actionAdd() {
        System.out.print("작가:");
        String author = scanner.nextLine();

        System.out.print("명언:");
        String content = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언\n" + "----------------------");

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying == null) break;
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
        }
    }
}
