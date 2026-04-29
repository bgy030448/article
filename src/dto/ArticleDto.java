package articleProject.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleDto {
    private Long id;
    private String name;
    private String title;
    private String content;
    private LocalDateTime insertedDate;
    private LocalDateTime updatedDate;
    private List<CommentDto> commentList = new ArrayList<>();

    public ArticleDto(Long id, String name, String title, String content) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public ArticleDto(Long id, String name, String title, String content, LocalDateTime insertedDate) {
        this(id, name, title, content);
        this.insertedDate = insertedDate;
    }

    public ArticleDto(Long id, String name, String title, String content, LocalDateTime insertedDate, LocalDateTime updatedDate) {
        this(id, name, title, content, insertedDate);
        this.updatedDate = updatedDate;
    }

    public ArticleDto(Long id, String name, String title, String content, LocalDateTime insertedDate, LocalDateTime updatedDate, List<CommentDto> commentList) {
        this(id, name, title, content, insertedDate, updatedDate);

        if (commentList != null) {
            this.commentList = commentList;
        }
    }

    public static ArticleDto makeArticleDto(Long id, String name, String title, String content, LocalDateTime insertedDate) {
        return new ArticleDto(id, name, title, content, insertedDate);
    }

    public void addComment(CommentDto comment) {
        this.commentList.add(comment);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(LocalDateTime insertedDate) {
        this.insertedDate = insertedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<CommentDto> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDto> commentList) {
        this.commentList = commentList;
    }
}