/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tts.WeatherApp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
/**
 *
 * @author jared
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZipCode {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zipcode_id")
    Long id;
    
    //created at
    @CreationTimestamp
    Date date;
    
    //ZipCode
    String zipcode;
}
