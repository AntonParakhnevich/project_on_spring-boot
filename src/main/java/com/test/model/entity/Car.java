package com.test.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "studio_id")
  private Long studioId;
  @ManyToOne
  @JoinColumn(name = "studio_id", updatable = false, insertable = false)
  @JsonBackReference
  private Studio studio;
  @Column
  private String number;
  @Column(name = "is_active")
  private Boolean isActive;
  @Column
  private LocalDate insuranceDate;
  @Column
  private LocalDate technicalInspectionDate;

  public Car(Long studioId, Studio studio, String number, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {
    this.studioId = studioId;
    this.studio = studio;
    this.number = number;
    this.isActive = isActive;
    this.insuranceDate = insuranceDate;
    this.technicalInspectionDate = technicalInspectionDate;
  }

  public Car() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public LocalDate getInsuranceDate() {
    return insuranceDate;
  }

  public void setInsuranceDate(LocalDate insuranceDate) {
    this.insuranceDate = insuranceDate;
  }

  public LocalDate getTechnicalInspectionDate() {
    return technicalInspectionDate;
  }

  public void setTechnicalInspectionDate(LocalDate technicalInspectionDate) {
    this.technicalInspectionDate = technicalInspectionDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(id, car.id) && Objects.equals(
        studioId, car.studioId) && Objects.equals(studio, car.studio) && Objects.equals(number,
        car.number) && Objects.equals(isActive, car.isActive) && Objects.equals(insuranceDate,
        car.insuranceDate) && Objects.equals(technicalInspectionDate, car.technicalInspectionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, studioId, studio, number, isActive, insuranceDate, technicalInspectionDate);
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", studioId=" + studioId +
        ", studio=" + studio +
        ", number='" + number + '\'' +
        ", isActive=" + isActive +
        ", insuranceDate=" + insuranceDate +
        ", technicalInspectionDate=" + technicalInspectionDate +
        '}';
  }
}
