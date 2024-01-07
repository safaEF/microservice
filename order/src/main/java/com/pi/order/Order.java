package com.pi.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "ordre")
@Builder
public class Order {
   @Id
    @GeneratedValue
    private Integer id;
    private String state;
    private Integer consumerId;
    private Integer restaurantId;

}
