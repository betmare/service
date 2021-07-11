package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column(columnDefinition = "char")
  private String countryCode;

  @Column(name = "countryName")
  private String countryName;

  @Column(columnDefinition = "char")
  private String currencyCode;

  @Column(columnDefinition = "char")
  private String fipsCode;

  @Column(columnDefinition = "char")
  private String isoNumeric;

  @Column
  private String north;

  @Column
  private String south;

  @Column
  private String east;

  @Column
  private String west;

  @Column
  private String capital;

  @Column
  private String continentName;

  @Column(columnDefinition = "char")
  private String continent;

  @Column
  private String languages;

  @Column(columnDefinition = "char")
  private String isoAlpha3;

  @Column
  private int geonameId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }


  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }


  public String getFipsCode() {
    return fipsCode;
  }

  public void setFipsCode(String fipsCode) {
    this.fipsCode = fipsCode;
  }


  public String getIsoNumeric() {
    return isoNumeric;
  }

  public void setIsoNumeric(String isoNumeric) {
    this.isoNumeric = isoNumeric;
  }


  public String getNorth() {
    return north;
  }

  public void setNorth(String north) {
    this.north = north;
  }


  public String getSouth() {
    return south;
  }

  public void setSouth(String south) {
    this.south = south;
  }


  public String getEast() {
    return east;
  }

  public void setEast(String east) {
    this.east = east;
  }


  public String getWest() {
    return west;
  }

  public void setWest(String west) {
    this.west = west;
  }


  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }


  public String getContinentName() {
    return continentName;
  }

  public void setContinentName(String continentName) {
    this.continentName = continentName;
  }


  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }


  public String getLanguages() {
    return languages;
  }

  public void setLanguages(String languages) {
    this.languages = languages;
  }


  public String getIsoAlpha3() {
    return isoAlpha3;
  }

  public void setIsoAlpha3(String isoAlpha3) {
    this.isoAlpha3 = isoAlpha3;
  }


  public int getGeonameId() {
    return geonameId;
  }

  public void setGeonameId(int geonameId) {
    this.geonameId = geonameId;
  }

}
