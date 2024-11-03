package com.example.cleaningstartup.repository;


import com.example.cleaningstartup.entity.CleaningServiceItem;
import org.springframework.data.repository.CrudRepository;

public interface CleaningServiceItemRepository
        extends CrudRepository<CleaningServiceItem, String> {
}