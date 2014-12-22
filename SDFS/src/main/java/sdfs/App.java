package sdfs;


public class App 
{
    public static void main( String[] args )
    {
       

        
        /*
        	Loading Configuration
         */
        System.out.print( "loading configuration..." );
        try{
	        Configuration C = new Configuration();
 		}
 		catch(ConfigurationException e){
 			System.out.println(" ERROR");
 			System.out.println(e);
 			return;
 		}

 		System.out.println( " DONE" );

        /*
        	Start Simple Distributed File System
         */
        System.out.println("starting SDFS...");

        
    }
}
