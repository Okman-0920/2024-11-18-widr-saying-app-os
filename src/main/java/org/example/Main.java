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
        int reg = 0;

        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 :");
                String wiseSaying = scanner.nextLine();

                System.out.print("작가 :");
                String author = scanner.nextLine();

                ++reg;
                System.out.println(reg + "번 명언이 등록되었습니다");

            } else if (cmd.equals("목록")) { //문자열은 == 으로 안됨


            } else if (cmd.equals("종료")) { //문자열은 == 으로 안됨
                break;
            }
        }
        scanner.close();
    }
}