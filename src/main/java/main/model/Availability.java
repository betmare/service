package main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean monday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean tuesday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean wednesday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean thursday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean friday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean saturday;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean sunday;

  @Column( columnDefinition = "TIME")
  private LocalTime timeFrom;

  @Column( columnDefinition = "TIME")
  private LocalTime timeTo;

  @Column
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "server_id")
  private Server server;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Boolean getMonday() {
    return monday;
  }

  public void setMonday(Boolean monday) {
    this.monday = monday;
  }


  public Boolean getTuesday() {
    return tuesday;
  }

  public void setTuesday(Boolean tuesday) {
    this.tuesday = tuesday;
  }


  public Boolean getWednesday() {
    return wednesday;
  }

  public void setWednesday(Boolean wednesday) {
    this.wednesday = wednesday;
  }


  public Boolean getThursday() {
    return thursday;
  }

  public void setThursday(Boolean thursday) {
    this.thursday = thursday;
  }


  public Boolean getFriday() {
    return friday;
  }

  public void setFriday(Boolean friday) {
    this.friday = friday;
  }


  public Boolean getSaturday() {
    return saturday;
  }

  public void setSaturday(Boolean saturday) {
    this.saturday = saturday;
  }


  public Boolean getSunday() {
    return sunday;
  }

  public void setSunday(Boolean sunday) {
    this.sunday = sunday;
  }


  public LocalTime getTimeFrom() {
    return timeFrom;
  }

  public void setTimeFrom(LocalTime timeFrom) {
    this.timeFrom = timeFrom;
  }


  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public LocalTime getTimeTo() {
    return timeTo;
  }

  public void setTimeTo(LocalTime timeTo) {
    this.timeTo = timeTo;
  }

  public Server getServer() {
    return server;
  }

  public void setServer(Server server) {
    this.server = server;
  }
}
