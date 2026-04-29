package repository;

import articleProject.dto.ArticleDto;
import dto.CommentDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    public static Long ariticleId = 1L;
    public static Long commentId = 1L;
    public static List<ArticleDto> articleList = new ArrayList<>();

    public List<ArticleDto> all() {
        return articleList;
    }

    public void newArticle(ArticleDto article) {
        articleList.add(article);
    }

    public ArticleDto detail(Long id) {
        for (ArticleDto article : articleList) {
            if (article.getId().equals(id)) {
                return article;
            }
        }

        return null;
    }

    public boolean delete(Long id) {
        return articleList.removeIf(article -> article.getId().equals(id));
    }

    public void update(ArticleDto article) {
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getId().equals(article.getId())) {
                articleList.set(i, article);
                return;
            }
        }
    }

    public void insertComment(CommentDto comment) {
        ArticleDto article = detail(comment.getArticleId());

        if (article == null) {
            return;
        }

        comment.setCommentId(commentId);
        commentId++;

        article.addComment(comment);
    }

    public void updateComment(CommentDto comment) {
        for (ArticleDto article : articleList) {
            for (CommentDto savedComment : article.getCommentList()) {
                if (savedComment.getCommentId().equals(comment.getCommentId())) {
                    savedComment.setContent(comment.getContent());
                    return;
                }
            }
        }
    }

    public void deleteComment(Long deleteCommentId) {
        for (ArticleDto article : articleList) {
            article.getCommentList().removeIf(comment -> comment.getCommentId().equals(deleteCommentId));
        }
    }
}