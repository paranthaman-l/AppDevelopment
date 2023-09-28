package paranthaman.vendormanagementsystem.models;

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
@Table(name = "review")
public class ReviewModel {
    @Id
    private String rid;

    private String review;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
