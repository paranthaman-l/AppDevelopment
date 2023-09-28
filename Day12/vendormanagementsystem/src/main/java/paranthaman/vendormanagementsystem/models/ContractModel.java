package paranthaman.vendormanagementsystem.models;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "contract")
public class ContractModel {
    @Id
    private String cid; // A unique identifier for each contract

    private String contractTitle; // A brief title or name for the contract
    private String contractDescription; // A more detailed description of the contract, outlining its purpose, terms,
                                        // and conditions.
    private LocalDate startDate; // The date when the contract becomes effective
    private LocalDate endDate; // The date when the contract expires or is terminated
    private BigDecimal contractValue; // The monetary value of the contract, if applicable
    private String paymentTerms; // Details about how payments will be made, such as the frequency and method of
                                 // payment.
    private String contractStatus; // A field indicating the current status of the contract (e.g., active, expired,
                                   // terminated).

    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
