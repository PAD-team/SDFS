SDFS
====

Simple Distributed File System



operations

	sdfs put "localSource" "remoteDestination"
	sdfs get "remoteSource" "localDestination"
	sdfs rm  "remoteFile"




configurations
	number of replications
	ip:port list of servers
	



how to compile
	
	$ make compile

how to execute

	$ java -jar SDFS/target/SDFS-0.1-jar-with-dependencies.jar




per importare il progetto in eclipse installa il plugin m2e  (maven to 
eclipse) e poi fai  file->import  maven project   ( se non ricordo male 
)
