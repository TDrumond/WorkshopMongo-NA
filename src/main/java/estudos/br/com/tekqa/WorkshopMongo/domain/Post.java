package estudos.br.com.tekqa.WorkshopMongo.domain;

import estudos.br.com.tekqa.WorkshopMongo.dto.AuthorDTO;
import estudos.br.com.tekqa.WorkshopMongo.dto.CommentDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements Serializable {
  public static final long serialVersionUID = 1L;
  private String id;
  private Date date;
  private String title;
  private String body;
  private AuthorDTO author;

  private List<CommentDTO> comments = new ArrayList<>();

  public Post() {}

  public Post(String id, Date date, String title, String body, AuthorDTO author) {
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }

  public List<CommentDTO> getComments() {
    return comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Post)) return false;

    Post post = (Post) o;

    return id != null ? id.equals(post.id) : post.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
