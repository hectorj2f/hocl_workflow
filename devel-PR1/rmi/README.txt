--- RMI CONFIG ---

To execute HOCL with rmi in localhost, you have to follow the next steps:

1. To create a rmi directory into HOCL_PATH folder (/usr/lib/hocl).
2. Copy the rmi policy file, "no.policy".
3. Compile the hocl files with the argument --rmi

/usr/lib/hocl/rmi/no.policy

> hoclcompile --rmi

		
	
Note:
   You cant send the same rule which have been reacted. For instance, passInfo.