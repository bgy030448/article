package main;

import view.ArticleView;

import java.util.Scanner;

public class ArticleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArticleView articleView = new ArticleView();

        while (true) {
            System.out.println();
            System.out.println("게시글 리스트");
            System.out.println("0.전체보기  1.새글  2.자세히보기  3.게시글삭제  4.수정  5.종료");
            System.out.print("> ");

            int menu = sc.nextInt();

            switch (menu) {
                case 0 -> articleView.showAll();
                case 1 -> articleView.showNewArticle();
                case 2 -> articleView.showDetail();
                case 3 -> articleView.showDelete();
                case 4 -> articleView.showUpdate();
                case 5 -> {
                    System.out.println("종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}