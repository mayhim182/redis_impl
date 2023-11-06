package com.redisPractice.RedisCachePractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {
  private static final long serialVersionUID = -4439114469417994311L;
  @Id
  @GeneratedValue
  private Integer invId;
  private String invName;
  private Double invAmount;
}
