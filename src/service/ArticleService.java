package service;

import dto.ArticleDto;
import repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepository();

    public List<ArticleDto> all() {
        return articleRepository.all();
    }

    public void newArticle(ArticleDto articleDto) {
        articleDto.setInsertedDate(LocalDateTime.now());
        articleRepository.newArticle(articleDto);
    }

    public ArticleDto detail(Long id) {
        return articleRepository.detail(id);
    }

    public boolean delete(Long id) {
        return articleRepository.delete(id);
    }

    public void update(ArticleDto articleDto) {
        articleDto.setUpdatedDate(LocalDateTime.now());
        articleRepository.update(articleDto);
    }
}

