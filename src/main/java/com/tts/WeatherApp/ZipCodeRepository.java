/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tts.WeatherApp;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jared
 */
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long>{
    //https://www.tutorialspoint.com/how-to-select-last-10-rows-from-mysql
    @Query(value = "Select * FROM ZIP_CODE ORDER BY ZIPCODE_ID DESC LIMIT 10", nativeQuery = true)
    List<ZipCode> findTenMostRecentZipCodes();
}
