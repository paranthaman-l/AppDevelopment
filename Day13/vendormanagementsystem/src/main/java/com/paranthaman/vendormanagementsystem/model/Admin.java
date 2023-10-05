package com.paranthaman.vendormanagementsystem.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "admin")
public class Admin {
	 	@Id
	    private String aid;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "uid", referencedColumnName = "uid")
	    private User user;
}
