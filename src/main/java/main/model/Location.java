package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column
  private String placeCode;

  @Column
  private String provider;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getPlaceCode() {
    return placeCode;
  }

  public void setPlaceCode(String placeCode) {
    this.placeCode = placeCode;
  }


  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

}
