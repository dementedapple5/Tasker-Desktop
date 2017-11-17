package Model;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Conector {


	static CloseableHttpClient httpclient = HttpClients.createDefault();


	//Devuelve un ArrayList con todos los username registrados
	public List<String> obtenerUsuarios() throws ClientProtocolException, IOException{

		List<String> listUserName = new ArrayList<>();

		try {
			HttpGet httpGet = new HttpGet("https://centraldemascotas.com/aplicaciones/tasker/select_users.php");
			CloseableHttpResponse response1 = httpclient.execute(httpGet);

			try {
				HttpEntity entity1 = response1.getEntity();
				String json = IOUtils.toString(entity1.getContent(), "UTF8");        
				Gson gson = new Gson(); // Or use new GsonBuilder().create();
				Type collectionType = new TypeToken<Collection<User>>(){}.getType();
				List<User> usuarios = (List<User>) new Gson()
						.fromJson( json , collectionType);

				for(User user: usuarios) {
					listUserName.add(user.getUsername());
				}

				EntityUtils.consume(entity1);
			} finally {
				response1.close();
			}


		} finally {
			httpclient.close();
		}
		return listUserName;
	}

	public List<Task> obtenerTareas() throws ClientProtocolException, IOException{


		List<Task> obtenerTareas = new ArrayList<>();

		HttpPost httpPost = new HttpPost("https://centraldemascotas.com/aplicaciones/tasker/select_users.php");
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("encargado", "pepin"));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));
	 
	    CloseableHttpResponse response = httpclient.execute(httpPost);
	    httpclient.close();

		return null;

	}


}
