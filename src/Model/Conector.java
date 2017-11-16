package Model;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Conector {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("https://centraldemascotas.com/aplicaciones/tasker/select_all.php");
            CloseableHttpResponse response1 = httpclient.execute(httpGet);

            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
                String json = IOUtils.toString(entity1.getContent(), "UTF8");
                JsonObject jsonObj = new JsonObject(json);
              
     
                EntityUtils.consume(entity1);
            } finally {
                response1.close();
            }

         
        } finally {
            httpclient.close();
        }
    }

}
