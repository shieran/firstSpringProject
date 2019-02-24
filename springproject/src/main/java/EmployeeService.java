import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<String> getAll(){
        File file = new File("list.txt");
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                result.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result ;
    }

}
