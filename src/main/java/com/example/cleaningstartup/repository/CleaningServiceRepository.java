package com.example.cleaningstartup.repository;


import com.example.cleaningstartup.entity.CleaningServiceOrder;
import org.springframework.data.repository.CrudRepository;

public interface CleaningServiceRepository extends CrudRepository<CleaningServiceOrder, Long> {
}
