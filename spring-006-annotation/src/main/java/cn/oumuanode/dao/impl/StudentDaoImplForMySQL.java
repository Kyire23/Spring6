package cn.oumuanode.dao.impl;

import cn.oumuanode.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplForMySQL")
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("ÕýÔÚÉ¾³ý");
    }
}
