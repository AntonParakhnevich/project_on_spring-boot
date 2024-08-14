package com.test.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_account_id", insertable = false, updatable = false)
  private Long userAccountId;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "user_account_id")
  private UserAccount userAccount;

  @Column(name = "studio_id")
  private Long studioId;
  @ManyToOne
  @JoinColumn(name = "studio_id", updatable = false, insertable = false)
  @JsonBackReference
  private Studio studio;

  public Admin() {
  }

  public Admin(Long id, Long userAccountId, UserAccount userAccount, Long studioId) {
    this.id = id;
    this.userAccountId = userAccountId;
    this.userAccount = userAccount;
    this.studioId = studioId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }

  public Long getStudioId() {
    return studioId;
  }

  public void setStudioId(Long studioId) {
    this.studioId = studioId;
  }

  public Studio getStudio() {
    return studio;
  }

  public void setStudio(Studio studio) {
    this.studio = studio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Admin admin = (Admin) o;
    return Objects.equals(id, admin.id) && Objects.equals(userAccountId, admin.userAccountId)
        && Objects.equals(userAccount, admin.userAccount) && Objects.equals(studioId, admin.studioId)
        && Objects.equals(studio, admin.studio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userAccountId, userAccount, studioId, studio);
  }

  @Override
  public String toString() {
    return "Admin{" +
        "id=" + id +
        ", userAccountId=" + userAccountId +
        ", userAccount=" + userAccount +
        ", studioId=" + studioId +
        ", studio=" + studio +
        '}';
  }
}
