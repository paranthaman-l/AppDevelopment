package com.paranthaman.vendormanagementsystem.microservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "serviceRequest")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String sid;
    private String serviceName;
    private String description;

    private String vid;

    @OneToMany(mappedBy = "serviceRequest")
    private List<ServiceApply> serviceApplies = new ArrayList<>();
}
