import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson; 
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList; 


public class App {

    public static void main(String[] args) throws Exception {
        Database db = new Database(); 
        db.Setup();

        String dataFilePath = System.getProperty("user.dir") + "/bin/data/customerData.csv"; 
        System.out.println("Reading filepath: "+dataFilePath); 
        ArrayList<Customer> customers = new ArrayList<Customer>(); 
        try (CSVReader reader = new CSVReader(new FileReader(dataFilePath))) {
            List<String[]> r = reader.readAll();
            r.remove(0);
            for (String[] strArr : r) {
                if(strArr[0].length() > 0 ){ 
                customers.add(new Customer(strArr[0], strArr[1], strArr[2],
                strArr[3],strArr[4],strArr[5],strArr[6],strArr[7])); 
                }
            } 
        }

        Gson gson = new Gson();
        String postJson = gson.toJson(customers);  
        CustomHttpClient client = new CustomHttpClient("http://localhost:3000/");
        client.postRequest("customers", postJson);

        Scanner sc = new Scanner (System.in); 
        System.out.println("'EXIT' to exit. Enter customer ref to get: ");
        String s1 = null;
        while (sc.hasNext() == true) {
            s1 = sc.next();
            if("EXIT".equals(s1)) {
                break;
            }
            client.getRequest("customers", s1);
        }  
    }
} 