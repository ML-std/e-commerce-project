package com.ecommerce.adminbadrequestservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BadRequest {

    @Id
    private Long id;
    @Column
    private String reportType;
}
