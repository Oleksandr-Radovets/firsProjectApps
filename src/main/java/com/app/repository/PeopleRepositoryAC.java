package com.app.repository;


import com.app.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PeopleRepositoryAC extends JpaRepository <People , Integer> {

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM people w WHERE w.id_people =:id")
    void deletePeople (@Param("id")Integer id);


}
