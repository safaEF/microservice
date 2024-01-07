package com.pi.kitchen;
 
import java.io.Serializable;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "state")
    private String state;
    @Column(name = "restaurant_Id")
    private Long restaurantId;
    @Column(name = "preparingTime")
    private int preparingTime;
    @Column(name = "pickedUpTime")
    private int pickedUpTime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public int getPreparingTime() {
        return preparingTime;
    }
    public void setPreparingTime(int preparingTime) {
        this.preparingTime = preparingTime;
    }
    public int getPickedUpTime() {
        return pickedUpTime;
    }
    public void setPickedUpTime(int pickedUpTime) {
        this.pickedUpTime = pickedUpTime;
    }
}