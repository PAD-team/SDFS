package sdfs;

import java.util.Properties;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.lang.UnsupportedOperationException;
import java.lang.SecurityException;

public class Configuration {
	private String homeDir;
	private String projectDir;
	private String configFile; 

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
			preparing the enviroment
		 */
		try{
			setEnviroment();
		}
		catch(Exception e){
			throw new ConfigurationException("preparing the enviroment FAILED:\n"+e.toString());
		}		
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

	private void createStandardConfigFile(){
		
	}

	private void setEnviroment() throws UnsupportedOperationException, IOException, SecurityException{
		
		

		/*
			create project directory (if it not exists)
		 */
		
		
		File f;
		f = new File(configFile);
		Path p = f.toPath();
		Files.createDirectories( p );

		/*
			create and initialize configFile if it not exists
		 */
		if(f.isDirectory()){
			throw new IOException(configFile + " is not a file");
		}

		if(!f.exists()){
			createStandardConfigFile();
		}

		
	}


}
