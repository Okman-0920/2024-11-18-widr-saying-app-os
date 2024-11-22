package org.example;

import java.util.Arrays;
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
//        WiseSaying lastWiseSaying = null;
        WiseSaying[] wiseSayings = new WiseSaying[100];
        int wiseSayingsSize = 0; // 데이터가 0개 있다, 배열에 index라고 알면된다

        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if(cmd.equals("등록")) {
                System.out.print("작가:");
                String author = scanner.nextLine();

                System.out.print("명언:");
                String content = scanner.nextLine();

                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayings[wiseSayingsSize] = wiseSaying;
                wiseSayingsSize++;

                System.out.println(Arrays.toString(wiseSayings));

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                // 내 코드: System.out.println(id + "번 명언이 등록되었습니다.");

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n" + "----------------------");
                                // 이렇게 만들 경우, 가장 마지막에 저장된 1개만 온다. 단 저장안되면 실행오류남

                try { // try-catch 일단 사용
                    System.out.println("%d / %s / %s".formatted(wiseSayings[wiseSayingsSize].id, wiseSayings[wiseSayingsSize].author, wiseSayings[wiseSayingsSize].content));
                } catch (NullPointerException e) {
                    System.out.println("등록된 명언이 없습니다");
                }
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

    @Override
    public String toString() {
        return "WiseSating{" + "id=" + id + ", content=" + content + '/' + ", author=" + author + '/' + '}';
    }

}

