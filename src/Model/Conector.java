package Model;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.SwingUtilities;

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

import View.TaskView;


public class Conector {


	static CloseableHttpClient httpclient = HttpClients.createDefault();


	//Devuelve un ArrayList con todos los username registrados
	public ArrayList<User> obtenerUsuarios() throws ClientProtocolException, IOException{

		ArrayList<User> listUser = new ArrayList<>();

		try {
			HttpGet httpGet = new HttpGet("https://centraldemascotas.com/aplicaciones/tasker/select_users.php");
			CloseableHttpResponse response1 = httpclient.execute(httpGet);

			try {
				HttpEntity entity1 = response1.getEntity();
				String json = IOUtils.toString(entity1.getContent(), "UTF8");        
				Gson gson = new Gson(); // Or use new GsonBuilder().create();
				Type collectionType = new TypeToken<Collection<UserPojo>>(){}.getType();
				List<UserPojo> usuarios = (List<UserPojo>) new Gson()
						.fromJson( json , collectionType);

				for(UserPojo user: usuarios) {
					//System.out.println(user.getUsername());
					listUser.add(new User(user.getUsername(),user.getPassword()));
					//System.out.println(listUser.toString());
				}

				EntityUtils.consume(entity1);
			} finally {
				
			}


		} finally {
			
		}
		return listUser;
	}
	
	public boolean checkUser(String username, String password) {
		HttpPost httpPost = new HttpPost("https://centraldemascotas.com/aplicaciones/tasker/check_user.php");
		boolean finded = false;
		try {
			List<NameValuePair> user = new ArrayList<NameValuePair>();
			user.add(new BasicNameValuePair("username",username));
			user.add(new BasicNameValuePair("pass",password));
		    httpPost.setEntity(new UrlEncodedFormEntity(user));
		    
		    CloseableHttpResponse response1 = httpclient.execute(httpPost);
			HttpEntity entity1 = response1.getEntity();
			String json = IOUtils.toString(entity1.getContent(), "UTF8");
			System.out.println(json);
			if (json.equals("1")) {
				finded=true;
			}else {
				finded = false;
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		return finded;
	}

	public static List<Task> obtenerTareas() throws ClientProtocolException, IOException{


		List<TaskPojo> listTareas = new ArrayList<>();

		HttpPost httpPost = new HttpPost("https://centraldemascotas.com/aplicaciones/tasker/select_tasks.php");
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("encargado", "pepin"));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));
	 
	    CloseableHttpResponse response = httpclient.execute(httpPost);
	    HttpEntity entity1 = response.getEntity();
	    String json2 = IOUtils.toString(entity1.getContent(), "UTF8");
	    
	    Gson gson1 = new Gson(); // Or use new GsonBuilder().create();
		Type collectionType = new TypeToken<Collection<TaskPojo>>(){}.getType();
		List<TaskPojo> tareas = (List<TaskPojo>) new Gson().fromJson( json2 , collectionType);
		
		for(TaskPojo tarea: tareas) {
			listTareas.add(tarea);
		}
	    
	    System.out.println(json2);
	    httpclient.close();

		return null;

	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
       obtenerTareas();
    }


}
