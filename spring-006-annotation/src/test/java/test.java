import cn.oumuanode.Spring6Config;
import cn.oumuanode.service.StudentService;
import com.oumuanode.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = annotationConfigApplicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }


    @Test
    public void testBeanComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User userBean = applicationContext.getBean("userBean", User.class);
//        System.out.println(userBean);
    }

    @Test
    public void testResource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
}
