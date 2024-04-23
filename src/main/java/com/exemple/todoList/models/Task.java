package com.exemple.todoList.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
  public static final String TABLE_NAME = "task";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",unique = true)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @Column(name = "description", length = 255, nullable = false)
  @NotNull
  @NotEmpty
  @Size( min=2,max=255)
  private String description;

  @Column(name = "date", length =11, nullable = false)
  @Temporal(TemporalType.DATE)
  private Date date;

  @Column(name = "Status", length =11, nullable = false)
  @NotNull
  @NotEmpty
  @Size( min=8,max=10)
  private String Status;

  public Task() {
  }

  public String getStatus() {
    return this.Status;
  }

  public Task(Long id, User user, String description, Date date, String Status) {
    this.id = id;
    this.user = user;
    this.description = description;
    this.date = date;
    this.Status = Status;
  }

  public void setStatus(String Status) {
    this.Status = Status;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long Id) {
    this.id = Id;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Task id(long id) {
    setId(id);
    return this;
  }

  public Task user(User user) {
    setUser(user);
    return this;
  }

  public Task description(String description) {
    setDescription(description);
    return this;
  }

  public Task date(Date date) {
    setDate(date);
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (!(obj instanceof Task) || obj == null) {
      return false;
    }
    Task other = (Task) obj;
    if (this.id == null){
      if (other.id != null){
        return false;
      }else if (!this.id.equals(other.id)) {
        return false;
      }
    }
    return Objects.equals(this.id,other.id) && Objects.equals(this.user, other.user) &&
    Objects.equals(this.date, other.date) && Objects.equals(this.description, other.description);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", user='" + getUser() + "'" +
      ", description='" + getDescription() + "'" +
      ", date='" + getDate() + "'" +
      "}";
  }


}
