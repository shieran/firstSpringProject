import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public static EmployeeService getEmployeeService(){
        return new EmployeeService();
    }

    @Bean
    public static ProjectService getProjectService(){
        return new ProjectService();
    }

}
