package sdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {
	private String homeDir;
	private String projectDir;
	private String configFile; 
	private Config config;

	
	
	public String getIp(){
		return config.ip;
	}
	
	public String getPort(){
		return config.port;
	}
	
	public int getReplicaNum() {
		return config.replicasNumber;
	}
	
	public List<Map<String,String>> getPeerList(){
		return config.peerList;
	}
	
	
	
	Configuration() throws ConfigurationException{
		/*
			setting some Configuration attribute
		 */
		try{
			init();
		}
		catch(Exception e){
			throw new ConfigurationException("preparing the enviroment FAILED:\n"+e.toString());
		}		
		

		/*
			preparing the environment
		 */
		try{
			setEnviroment();
		}
		catch(Exception e){
			throw new ConfigurationException("preparing the enviroment FAILED:\n"+e.toString());
		}
		
		/*
		 *  importing configurations from file
		 */
		try{
			setConfigFromFile();
		}
		catch(Exception e){
			throw new ConfigurationException("preparing the enviroment FAILED:\n"+e.toString());
		}
	}

	private void setConfigFromFile() throws IOException {
		/*
		 * read configFile
		 */
		File file = new File(configFile);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();
		String json = new String(data, R.UTF8);
		
		/*
		 * deserialize and create config object
		 */
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		config = gson.fromJson(json, Config.class);
		
	}

	private void init() throws IOException{
	
		/*
			Get user directory
		 */
		Properties P = System.getProperties();
		if(P == null){
			throw new IOException("home directory not found");
		}

		/*
			setting some attributes
		 */
		homeDir = P.getProperty("user.home");
		projectDir = homeDir + "/" + R.projectName + R.projectVersion;
		configFile = projectDir + "/" + R.configFileName;
	}

	private void createStandardConfigFile()throws IOException{	
		/*
		 * create standard configuration
		 */
		config = new Config();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		/*
		 * store it to configFile
		 */
		String prettyJsonString = gson.toJson(config);
		PrintWriter writer = new PrintWriter(configFile, R.UTF8);
		writer.print(prettyJsonString);
		writer.close();
	}

	private void setEnviroment() throws UnsupportedOperationException, IOException, SecurityException{	

		/*
			create project directory (if it not exists)
		 */	
		File f;
		f = new File(projectDir);
		Path p = f.toPath();
		Files.createDirectories( p );

		/*
			create and initialize configFile if it not exists
		 */
		f = new File(configFile);
		if(f.isDirectory()){
			throw new IOException(configFile + " is not a file");
		}
		
		if(!f.exists()){
			createStandardConfigFile();
		}

		
	}


	/*
	 * Configurations values that the user can modify in the configFile.
	 * An object of this class is read/write in json format from/to configFile.
	 */
	public class Config{
		private int replicasNumber = R.basicConfigReplica;
		private String ip = R.basicConfigIP;
		private String port = R.basicConfigPort;
		private List<Map<String,String>> peerList = null;
				
		Config(){
			peerList = new ArrayList<Map<String,String>>();
			Map<String, String> m = new HashMap<String,String>();
			m.put("ip", R.basicConfigIP);
			m.put("port", R.basicConfigPort);
			peerList.add(m);peerList.add(m);peerList.add(m);
					
			
		}
	}
	
}
