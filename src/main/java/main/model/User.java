package main.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;

  @Column
  private String email;

  @Column
  private String firstname;

  @Column
  private String middleName;

  @Column
  private String lastname;

  @Column
  private String mobile;

  @Column
  private String phoneHome;

  @Column
  private String phoneOffice;

  @Column
  private String birthdate;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getPhoneHome() {
    return phoneHome;
  }

  public void setPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
  }


  public String getPhoneOffice() {
    return phoneOffice;
  }

  public void setPhoneOffice(String phoneOffice) {
    this.phoneOffice = phoneOffice;
  }


  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
