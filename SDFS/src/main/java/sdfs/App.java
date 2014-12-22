package sdfs;


public class App 
{
    public static void main( String[] args )
    {
       

        
        /*
        	Loading Configuration
         */
        System.out.print( "loading configuration..." );
        Configuration C;
        try{
	        C = new Configuration();
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
      
        
        String ip = C.getIp();
        if(ip != null && !ip.equals( R.basicConfigIP ))
        	System.out.println("ip: "+ ip);
        System.out.println("port: "+ C.getPort());
        System.out.println("replicaNumber: "+ C.getReplicaNum());

        
    }
}
