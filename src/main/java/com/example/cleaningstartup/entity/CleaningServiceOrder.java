package com.example.cleaningstartup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class CleaningServiceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    private List<CleaningService> cleaningServices = new ArrayList<>();

    public void addCleaningService(CleaningService cleaningService) {
        this.cleaningServices.add(cleaningService);
    }

}