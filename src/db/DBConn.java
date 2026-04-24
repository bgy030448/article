package db;

public class DBConn {
    CREATE DATABASE article_db;
    USE article_db;

    CREATE TABLE article (
            id            BIGINT AUTO_INCREMENT PRIMARY KEY,
            name          VARCHAR(50)  NOT NULL,
    title         VARCHAR(200) NOT NULL,
    content       TEXT,
    inserted_date DATETIME,
    updated_date  DATETIME
);

    CREATE TABLE comments (
            comment_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
            article_id  BIGINT      NOT NULL,
            name        VARCHAR(50) NOT NULL,
    content     TEXT,
    FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);
}
