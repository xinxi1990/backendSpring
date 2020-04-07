package com.app.server;


import com.app.model.Student;
import com.app.server.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    /**
     * 新增
     * @param name
     * @param email
     * @return
     */
    public int save(String name,String email){

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        studentRepository.save(student);

        //if (true) {
        //    throw new RuntimeException("save 抛异常了");
        //}

        return 0;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Student> getList(){
        return (List<Student>) studentRepository.findAll();
    }


    /**
     * 通过姓名查询
     * @param name
     * @return
     */
    public  List<Student> findByName(String name){
        return studentRepository.findByName(name);
    }


    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    public  List<Student> findByEmail(String email){
        return studentRepository.findByEmail(email);
    }


    /**
     * 删除一行
     * @param name
     * @return
     */
    public int deleteByName(String name){
        return studentRepository.deleteByName(name);
    }


    /**
     * 更改数据库中的一行
     * @param id
     * @param name
     * @return
     */
    public int modifyByName(int id,String name){
        return studentRepository.modifyByName(id,name);
    }



    /**
     * 分页查询所有
     * @return
     */
    public List<Student> getPageList(){
        return (List<Student>) studentRepository.findAll();
    }


    public synchronized void getSynchronizedTime(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "synchronized loop " + i);
        }

    }

    public  void getTime(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "synchronized loop " + i);
        }

    }


}
