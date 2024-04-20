package com.exemple.todoList.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity //entidade de persistência.
@Table(name = User.TABLE_NAME)
public class User {
  public static final String TABLE_NAME = "user";

  public interface CreaterUser {}
  public interface UpdateUser {}
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", unique = true)
  private Long id;

  @Column(name="username", length = 100, nullable = false, unique = true)
  @NotNull(groups = CreaterUser.class)
  @NotEmpty(groups = CreaterUser.class)
  @Size(groups = CreaterUser.class, min=2, max=100)
  private String username;

  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(name="password", length = 60,  nullable = false)
  @NotNull(groups = {CreaterUser.class, UpdateUser.class})
  @NotEmpty(groups = CreaterUser.class)
  @Size(groups = CreaterUser.class, min=8, max=60)
  private String password;

  public User() {
  }


  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  

  @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User) || obj == null) {
            return false;
        }
        User other = (User) obj;
        if (this.id == null){
          if (other.id != null){
            return false;
          }else if (!this.id.equals(other.id)) {
            return false;
          }
        }
      return Objects.equals(this.id,other.id) && Objects.equals(this.username, other.username) &&
      Objects.equals(this.password, other.password);

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;
  }

}
