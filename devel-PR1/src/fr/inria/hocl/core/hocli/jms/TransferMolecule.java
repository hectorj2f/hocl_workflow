package fr.inria.hocl.core.hocli.jms;

import java.util.logging.Logger;

import javax.jms.Connection;

import fr.inria.hocl.core.hocli.Molecule;

public class TransferMolecule {

	
	private static Connection connection;
	private static String origen;
	private static String url;
	
	private static Logger log = Logger.getLogger(fr.inria.hocl.workflow.utils.IConstants.LOG_NAME);
	

	public static void setConnection(Connection con){
		connection=con;
	}
	
	public static void setUrl(String urlJms){
		url=urlJms;
	}

	public static void setOrigen(String origen) {
		TransferMolecule.origen = origen;
	}



	public static boolean send(String from, String destination,
			Molecule molecule) {
		try {
			log.info("Sending one molecule");

		
			log.info("Size: " + molecule.size());

			

			return true;

		} catch (Exception e) {
			System.out.println("RemoteIOclient exception: " + e);
			e.printStackTrace();
			return false;
		}

	}

	public static boolean put( String mol_id,Molecule molecule) {
		try {
			log.info("Transfer one molecule with put method");
			
			//FIXME: Cardiac ChWS_2 ... error in central Multiset cannot deserialize Invoke_crop, there must be any observer linked to this rule.
	        Molecule mol2 = molecule.clone();
			
			
			log.info("Size: " + molecule.size()+ " containing: "+mol2.toString());

			ChWSPublisher oChWSPublisher = new ChWSPublisher(connection,mol2, mol_id, origen,url);
			oChWSPublisher.run();
			
			molecule=null;

			log.info("Finished put method");

			return true;

		} catch (Exception e) {
			log.severe("RemoteIOclient exception: " + e);
			e.printStackTrace();
			return false;
		}

	}

	
}
