package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class News {
    private int newsId;
    private String newsContents;
    private Date publishData;
    private Author authorByAuthorId;

    @Id
    @Column(name = "news_id")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_contents")
    public String getNewsContents() {
        return newsContents;
    }

    public void setNewsContents(String newsContents) {
        this.newsContents = newsContents;
    }

    @Basic
    @Column(name = "publish_data")
    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (newsId != news.newsId) return false;
        if (newsContents != null ? !newsContents.equals(news.newsContents) : news.newsContents != null) return false;
        if (publishData != null ? !publishData.equals(news.publishData) : news.publishData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId;
        result = 31 * result + (newsContents != null ? newsContents.hashCode() : 0);
        result = 31 * result + (publishData != null ? publishData.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsContents='" + newsContents + '\'' +
                ", publishData=" + publishData +
                ", authorByAuthorId=" + authorByAuthorId +
                '}';
    }
}
