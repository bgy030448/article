package view;

import articleProject.dto.ArticleDto;
import dto.CommentDto;
import repository.ArticleRepository;
import service.ArticleService;
import service.CommentService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    private final Scanner sc = new Scanner(System.in);
    private final ArticleService articleService = new ArticleService();
    private final CommentService commentService = new CommentService();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String formatDate(LocalDateTime date) {
        if (date == null) {
            return "null";
        }

        return date.format(formatter);
    }

    public void showAll() {
        List<ArticleDto> articles = articleService.all();

        if (articles.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("=============================================");
        System.out.println("id\tname\t\ttitle\t\t작성일");
        System.out.println("=============================================");

        for (ArticleDto article : articles) {
            System.out.println(
                    article.getId() + "\t"
                            + article.getName() + "\t\t"
                            + article.getTitle() + "\t\t"
                            + formatDate(article.getInsertedDate())
            );

            article.getCommentList().forEach(System.out::println);
        }

        System.out.println("=============================================");
    }

    public void showNewArticle() {
        System.out.println();
        System.out.println("새글 입력창입니다.");

        System.out.print("작성자: ");
        String name = sc.next();

        System.out.print("제목: ");
        String title = sc.next();

        System.out.print("내용: ");
        String content = sc.next();

        ArticleDto articleDto = ArticleDto.makeArticleDto(
                ArticleRepository.ariticleId,
                name,
                title,
                content,
                LocalDateTime.now()
        );

        ArticleRepository.ariticleId++;

        articleService.newArticle(articleDto);

        System.out.println("등록됐습니다.");
    }

    public void showDetail() {
        System.out.println("확인할 게시글의 아이디를 입력하세요");
        System.out.print("> ");

        Long id = sc.nextLong();

        ArticleDto article = articleService.detail(id);

        if (article == null) {
            System.out.println("해당 게시글이 없습니다.");
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("🚀 ID      : " + article.getId());
            System.out.println("🚀 Name    : " + article.getName());
            System.out.println("🚀 Title   : " + article.getTitle());
            System.out.println("🚀 Content : " + article.getContent());
            System.out.println("🚀 작성일  : " + formatDate(article.getInsertedDate()));
            System.out.println("🚀 수정일  : " + formatDate(article.getUpdatedDate()));
            System.out.println();

            System.out.println("🎶🎶  댓글 리스트  🎶🎶");

            if (article.getCommentList().isEmpty()) {
                System.out.println("해당 게시글에는 댓글이 없습니다.");
            } else {
                article.getCommentList().forEach(System.out::println);
            }

            System.out.println();
            System.out.println("1.댓글입력  2.댓글수정  3.댓글삭제  4.돌아가기");
            System.out.print("> ");

            int menu = sc.nextInt();

            switch (menu) {
                case 1 -> {
                    System.out.print("댓글 등록자 이름: ");
                    String name = sc.next();

                    System.out.print("댓글 내용: ");
                    String content = sc.next();

                    CommentDto comment = new CommentDto(
                            null, article.getId(), name, content
                    );

                    commentService.commentAdd(comment);

                    article = articleService.detail(id);

                    System.out.println("댓글이 등록됐습니다.");
                }

                case 2 -> {
                    System.out.print("수정할 댓글 번호: ");
                    Long updateCommentId = sc.nextLong();

                    System.out.print("수정 내용: ");
                    String updateContent = sc.next();

                    CommentDto comment = new CommentDto(
                            updateCommentId,
                            article.getId(),
                            "",
                            updateContent
                    );

                    commentService.commentUpdate(comment);

                    article = articleService.detail(id);

                    System.out.println("댓글이 수정됐습니다.");
                }

                case 3 -> {
                    System.out.print("삭제할 댓글 번호: ");
                    Long deleteCommentId = sc.nextLong();

                    commentService.commentDelete(deleteCommentId);

                    article = articleService.detail(id);

                    System.out.println("댓글이 삭제됐습니다.");
                }

                case 4 -> {
                    return;
                }

                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    public void showDelete() {
        System.out.print("삭제할 게시글 ID: ");
        Long id = sc.nextLong();

        boolean result = articleService.delete(id);

        if (result) {
            System.out.println("삭제됐습니다.");
        } else {
            System.out.println("실패했습니다.");
        }
    }

    public void showUpdate() {
        System.out.print("수정할 게시글 ID: ");
        Long id = sc.nextLong();

        ArticleDto article = articleService.detail(id);

        if (article == null) {
            System.out.println("해당 게시글이 없습니다.");
            return;
        }

        System.out.println("현재 제목: " + article.getTitle());
        System.out.println("현재 내용: " + article.getContent());

        System.out.print("새 제목: ");
        String title = sc.next();

        System.out.print("새 내용: ");
        String content = sc.next();

        article.setTitle(title);
        article.setContent(content);
        article.setUpdatedDate(LocalDateTime.now());

        articleService.update(article);

        System.out.println("수정됐습니다.");
    }
}

