package com.example.cleaningstartup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class CleaningService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=3, message="Ошибка ввода, имя слишком короткое")
    private String name;

    @Pattern(regexp="^\\+?[0-9]{3,15}$", message="Ошибка ввода, некорректный номер телефона")
    private String phoneNumber;

    private Date createdAt = new Date();

    @ManyToMany
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<CleaningServiceItem> cleaningServiceItems = new ArrayList<>();

    public void addIngredient(CleaningServiceItem cleaningServiceItems) {
        this.cleaningServiceItems.add(cleaningServiceItems);
    }

}
