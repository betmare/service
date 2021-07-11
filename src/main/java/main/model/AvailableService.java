package main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class AvailableService {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;
  
  @Column
  private String name;

  @Column
  private String code;

  @Column
  private String description;

  @Column
  private int suggestedDuration;

  @Column
  private BigDecimal suggestedPrice;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public int getSuggestedDuration() {
    return suggestedDuration;
  }

  public void setSuggestedDuration(int suggestedDuration) {
    this.suggestedDuration = suggestedDuration;
  }


  public BigDecimal getSuggestedPrice() {
    return suggestedPrice;
  }

  public void setSuggestedPrice(BigDecimal suggestedPrice) {
    this.suggestedPrice = suggestedPrice;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
