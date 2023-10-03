package com.paranthaman.vendormanagementsystem.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceModel {
    
    @Id
    private String sid; // A unique identifier for each service
    private String serviceName; // The name or title of the service
    private String ServiceDescription; // The name or title of the service
    private String ServiceType; // The category or type of service (e.g., IT support, consulting, maintenance).
    private String serviceOwner;// The individual or department responsible for delivering or managing the service
    private String serviceStatus; // The current status of the service (e.g., active, inactive, in progress)
    private String serviceCost; // The cost associated with the service, if applicable
    private String serviceDuration; // The expected duration or time required to complete the service
    private String serviceAvailability; // The days and hours when the service is available
    
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;  
}
