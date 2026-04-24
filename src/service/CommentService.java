package service;

import repository.ArticleRepository;

public class CommentService {
    CruInterface dao = new ArticleRepository();

    public CruInterface getDao() {
    }
}
