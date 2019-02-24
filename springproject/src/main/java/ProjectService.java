import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ProjectService {

    public List<String> getProjectEmployee(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        return employeeService.getAll();
    }
}
