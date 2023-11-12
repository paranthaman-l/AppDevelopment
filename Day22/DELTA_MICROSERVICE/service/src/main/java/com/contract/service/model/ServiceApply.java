package com.contract.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "serviceApply")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceApply {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String aid;
    private String contractValue;
    private String description;

    private String oid;   
    
    @ManyToOne
    @JoinColumn(name = "fk_sid", referencedColumnName = "sid")
    private ServiceRequest serviceRequest;

}
