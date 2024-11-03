package com.example.cleaningstartup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class CleaningServiceItem {

    @Id
    private String id;
    private String name;
    private Type type;

    public enum Type {
        WET_CLEANING, GENERAL_CLEANING, CLEANING_AFTER_REPAIR,
        DRY_CLEANING_OF_UPHOLSTERED_FURNITURE, WINDOW_CLEANING, WASHING_CURTAINS
    }

}
