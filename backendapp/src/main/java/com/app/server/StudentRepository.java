package com.app.server;

import com.app.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    public List<Student> findByName(String name);

    public List<Student> findByEmail(String email);


    @Modifying
    @Query(value = "delete from student where name=?1",nativeQuery = true)
    public int deleteByName(String name);


    @Modifying
    @Query(value = "update student set name=?2 where id=?1",nativeQuery = true)
    public int modifyByName(int id,String name);


}
