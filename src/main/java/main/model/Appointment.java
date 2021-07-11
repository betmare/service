package main.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Entity
@Table
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column
  private LocalDateTime timeFrom;

  @Column
  private LocalDateTime timeTo;

  @ManyToOne
  @JoinColumn(name = "availability_id")
  private Availability availability;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public LocalDateTime getTimeFrom() {
    return timeFrom;
  }

  public void setTimeFrom(LocalDateTime timeFrom) {
    this.timeFrom = timeFrom;
  }


  public LocalDateTime getTimeTo() {
    return timeTo;
  }

  public void setTimeTo(LocalDateTime timeTo) {
    this.timeTo = timeTo;
  }

  public Availability getAvailability() {
    return availability;
  }

  public void setAvailability(Availability availability) {
    this.availability = availability;
  }
}
