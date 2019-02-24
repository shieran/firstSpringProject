import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        ProjectService projectService = ctx.getBean(ProjectService.class);
        System.out.println(employeeService.getAll().toString());
        System.out.println(projectService.getProjectEmployee());
    }
}
