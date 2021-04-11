package com.dio.livecoding.crud.SPgastronomy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

  private long id;
  private String name;
  private String local;
  private String type;
  private float rating;

  public Restaurant(){

  }

  public Restaurant(long id, String name, String local, String type, float rating) {
    this.id = id;
    this.name = name;
    this.local = local;
    this.type = type;
    this.rating = rating;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "local", nullable = false)
  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  @Column(name = "type", nullable = false)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "rating", nullable = false)
  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "Restaurant [id=" + id + ", name=" + name + ", local=" + local + ", type=" + type
      + ", rating=" + rating + "]";
  }


}
