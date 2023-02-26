import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;  
  
public class CustomerTest {  

  @Test  
  public void testCustomerHttp() {  

    Database db = new Database(); 
    db.Setup();

    String dataFilePath = "/Users/dylanstables/Documents/JavaProjects/KataCsvHttp/bin/data/customerData.csv"; 
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
    } catch(Exception e) {
        e.printStackTrace();
    }

    Gson gson = new Gson();
    String postJson = gson.toJson(customers);  
    CustomHttpClient client = new CustomHttpClient("http://localhost:3000/");
    client.postRequest("customers", postJson);

    assertNotEquals(  customers.size(), 0);  

    //loop through all customers getting their data over API by ref
    //compare data parsed from CSV to data returned from api
    for(Customer customer : customers){ 
        String response = client.getRequest("customers", customer.ref); 
        Customer temp = gson.fromJson(response, Customer.class); 
        assertEquals(temp.ref, customer.ref);  
        assertEquals(temp.addrLine1 ,customer.addrLine1);   
        assertEquals(temp.addrLine2 ,customer.addrLine2);   
        assertEquals(temp.country ,customer.country);   
        assertEquals(temp.county ,customer.county);   
        assertEquals(temp.name ,customer.name);   
        assertEquals(temp.postCode ,customer.postCode);   
        assertEquals(temp.town ,customer.town);    
    } 

  }  
 

}