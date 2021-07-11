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

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Server {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column(columnDefinition = "TINYINT default 1")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean active;

  @Column
  private BigDecimal rating;

  @Column
  private BigDecimal price;

  @Column
  private int duration;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "available_service_id")
  private AvailableService availableService;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Boolean getActive() {
    return active == null ? Boolean.TRUE : active;
  }

  public void setActive(Boolean active) {

    this.active = active;
  }


  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }


  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public AvailableService getAvailableService() {
    return availableService;
  }

  public void setAvailableService(AvailableService availableService) {
    this.availableService = availableService;
  }
}
