import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration; 

public class CustomHttpClient {
    
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private String url = null; 

    public CustomHttpClient(String url){
        this.url = url; 
    }

    private String getUrl(){
        return this.url;
    }

    public String getRequest(String urlExtension, String id){
        HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(getUrl() + urlExtension))
        .header("Content-Type", "application/json")
        .header("accept", "application/json")
        .header("ref", id)
        .build(); 
        
        try {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode()); 
        System.out.println(response.body()); 
        return response.body(); 

        } catch(Exception e){

        }

        return "";
    }



    public String postRequest(String urlExtension, String body){ 
         HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(getUrl() + urlExtension))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .header("accept", "application/json")
        .build(); 

        System.out.println("sending POST to: "+ URI.create(getUrl() + urlExtension)); 
        
        try {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders respHeaders = response.headers();
        respHeaders.map().forEach((k, v) -> System.out.println(k + ":" + v)); 
        System.out.println(response.statusCode()); 
        System.out.println(response.body()); 
        return response.body(); 

        } catch(Exception e){

        }

        return "";
    }


}
