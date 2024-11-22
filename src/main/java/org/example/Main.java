package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
        // new 다음은 class가 나와야한다
    }
}

class App {

    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int lastId = 0; // 마지막으로 등록된 ID
        WiseSaying lastWiseSaying; // 위치를 소환할 수 있는 변수 작성 (기억하도록)

        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 :");
                String content = scanner.nextLine();

                System.out.print("작가 :");
                String author = scanner.nextLine();
                int id = ++lastId; // 이해를 돕기위해 강사님과 동일한 지역변수명으로 변경

                WiseSaying wiseSaying = new WiseSaying(id, content, author);

                lastWiseSaying = wiseSaying;


                // 만약에 여기에 int reg = 1;을 선언하면 계속 반복이라 +2만될꺼
                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                // 내 코드: System.out.println(id + "번 명언이 등록되었습니다.");

            } else if (cmd.equals("목록")) { //문자열은 == 으로 안됨

            } else if (cmd.equals("종료")) { //문자열은 == 으로 안됨
                break;
            }
        }
        scanner.close();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}