package service;

import repository.ArticleRepository;

public class ArticleService {
    CrudInterface repository = new ArticleDAO();   // DB 버전
    CruInterface repository = new ArticleRepository();   // 메모리 버전
}
