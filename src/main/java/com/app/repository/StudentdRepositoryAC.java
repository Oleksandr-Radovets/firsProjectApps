package com.app.repository;


import com.app.domain.StudentEntity;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface StudentdRepositoryAC extends CrudRepository <StudentEntity , Long > {



    @Query(nativeQuery = true, value = "select *  from student_entity where  student_entity.age between :startAge and  :endAge  ")
    List<StudentEntity> startAndEndAge(@Param("startAge") int startAge, @Param("endAge") int endAge);

    @Query( nativeQuery = true, value = "select * from student_entity where name like :name ")
    Collection<StudentEntity> studentName (@Param("name")String name);


    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value ="DELETE FROM student_entity u WHERE u.id =:id")
    void delStudent (@Param("id")Long id);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM people w WHERE w.id =:id")
    void deleteById (@Param("id")Long id);




}
