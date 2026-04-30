package service;

import dto.CommentDto;
import repository.ArticleRepository;

public class CommentService {
    private final ArticleRepository articleRepository = new ArticleRepository();

    public void commentAdd(CommentDto commentDto) {
        articleRepository.insertComment(commentDto);
    }

    public void commentUpdate(CommentDto commentDto) {
        articleRepository.updateComment(commentDto);
    }

    public void commentDelete(Long deleteCommentId) {
        articleRepository.deleteComment(deleteCommentId);
    }
}