package com.test.model.request;

import com.test.model.RoleName;

public class CreateAdminRequest {

  private String name;
  private String phone;
  private RoleName role;
  private Long studioId;
  private String password;
  private String email;

  public CreateAdminRequest(String name, String phone, RoleName role, Long studioId, String password, String email) {
    this.name = name;
    this.phone = phone;
    this.role = role;
    this.studioId = studioId;
    this.password = password;
    this.email = email;
  }

  public CreateAdminRequest() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public RoleName getRole() {
    return role;
  }

  public void setRole(RoleName role) {
    this.role = role;
  }

  public Long getStudioId() {
    return studioId;
  }

  public void setStudioId(Long studioId) {
    this.studioId = studioId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
