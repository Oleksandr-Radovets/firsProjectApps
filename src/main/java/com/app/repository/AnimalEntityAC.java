package com.app.repository;


import com.app.domain.AnimalEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalEntityAC extends PagingAndSortingRepository<AnimalEntity , Long>  {
}
