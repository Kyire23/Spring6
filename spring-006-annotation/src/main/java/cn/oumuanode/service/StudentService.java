package cn.oumuanode.service;

import cn.oumuanode.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {
//    @Resource(name = "studentDaoImplForMySQL")
    private StudentDao studentDao;

    //δָ������ ������������� studentDao
    @Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
