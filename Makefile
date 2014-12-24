
compile:
	$(MAKE) -C SDFS compile
	$(MAKE) -C SDFS_tools compile

clean:
	$(MAKE) -C SDFS clean
	$(MAKE) -C SDFS_tools clean

install:
	echo "TODO"

