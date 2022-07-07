package com.app.repository;


import com.app.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepositoryAC extends JpaRepository <People , Integer> {

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM people w WHERE w.id_people =:id")
    void deletePeople (@Param("id")Integer id);

    @Query(nativeQuery = true, value = "SELECT * from people q where q.id_people=:id")
    Optional<People> findById(@Param("id")Integer id);

    @Query(nativeQuery = true,value = "SELECT * FROM people x where x.id_people ")
    List<People> findAllById(Iterable<Integer> ids);
}
