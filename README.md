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
	
	$ cd SDFS
	$ mvn compile
	$ mvn package

how to execute

	$ java -jar target/SDFS-0.1.jar