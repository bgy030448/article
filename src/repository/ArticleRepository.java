package repository;

import dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    //게시글 자동 증가 ID (철자 주의: ariticlId)
    public static Long ariticlId = 1L;
    //댓글 자동 증가 ID
    public static Long commentId = 1L;
    //메모리 저장소
    public static List<Article> articleList = new ArrayList<>();
    public List<ArticleDto> all(){

    }
    public void newArticle(Article){

    }
    public boolean delete(Long id){
        if(getId().equals(id)){
            return article;
        }
        return null;
    }
    public void update(Article){

    }
    public void insertComment(Comment){

    }
    public void updateComment(Comment){

    }
    public void deleteComment(Long){

    }

}
