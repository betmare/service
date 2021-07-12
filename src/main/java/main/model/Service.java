package main.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column
  private LocalDateTime requestDate;

  @Column
  private String endDate;

  @Column
  private BigDecimal rating;

  @Column
  private String comments;

  @Column
  private BigDecimal amount;

  @Column
  private int duration;

  @Column
  private String cancellationReason;

  @Column
  @Enumerated(EnumType.STRING)
  private StatusService status;

  @ManyToOne
  @JoinColumn(name = "availability_id")
  private Availability availability;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column
  private LocalTime timeFrom;

  @Column
  private LocalTime timeTo;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public LocalDateTime getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(LocalDateTime requestDate) {
    this.requestDate = requestDate;
  }


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }


  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }


  public String getCancellationReason() {
    return cancellationReason;
  }

  public void setCancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public User getUser() {
    return user;
  }

  public StatusService getStatus() {
    return status;
  }

  public void setStatus(StatusService status) {
    this.status = status;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Availability getAvailability() {
    return availability;
  }

  public void setAvailability(Availability availability) {
    this.availability = availability;
  }

  public LocalTime getTimeFrom() {
    return timeFrom;
  }

  public void setTimeFrom(LocalTime timeFrom) {
    this.timeFrom = timeFrom;
  }

  public LocalTime getTimeTo() {
    return timeTo;
  }

  public void setTimeTo(LocalTime timeTo) {
    this.timeTo = timeTo;
  }
}
