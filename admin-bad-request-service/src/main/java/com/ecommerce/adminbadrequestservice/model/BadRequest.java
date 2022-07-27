package com.ecommerce.adminbadrequestservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class BadRequest {

    @Id
    private Long id;
    @Column
    private String reportType;
}
