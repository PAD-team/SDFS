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

	$ java -jar SDFS/target/SDFS-0.1.jar



per sublime io mi sono fatto questo build system:
	{
		"shell_cmd": "cd /home/mz/git/SDFS/ ; make compile"
	}
così che mi compili correttamente in ogni directory in cui mi trovo. c'è un modo piu' furbo? XD