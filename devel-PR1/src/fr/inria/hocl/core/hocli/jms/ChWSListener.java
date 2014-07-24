package fr.inria.hocl.core.hocli.jms;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import fr.inria.hocl.core.hocli.Molecule;
import fr.inria.hocl.core.hocli.Solution;
import fr.inria.hocl.core.hocli.workflow.MoleculeMatcher;
import fr.inria.hocl.workflow.loader.CustomClassLoader;
import fr.inria.hocl.workflow.utils.IConstants;

public class ChWSListener implements MessageListener {

	private Connection connection;
	private MessageProducer producer;
	private Session session;
	private Topic topic;
	private Topic control;
	private Solution sol;
	private String name;
	private MoleculeMatcher matcher;
	
	private Logger log = null;	
	

	public ChWSListener(Solution sol, Connection connection, String name,
			MoleculeMatcher matcher) {
		this.sol = sol;
		this.connection = connection;
		this.name = name;
		this.matcher = matcher;
		log = Logger.getLogger(IConstants.LOG_NAME);
	}
	
	public void setSolution(Solution sol){
		this.sol=sol;
	}

	public void run() throws Exception {

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = session.createTopic(name);
		control = session.createTopic(name + ".control");

		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(this);

		// connection.start();

		producer = session.createProducer(control);
		log.info("Waiting for messages...");
	}

	public void onMessage(Message message) {
		try {
			// System.out.println("CONFIGURING CLASS LOADER "+MoleculeChWSListener.class.getClassLoader());
			Thread.currentThread().setContextClassLoader(
					new CustomClassLoader(Thread.currentThread()
							.getContextClassLoader()));
			URL url;
			try {
				url = new URL(System.getProperty("java.rmi.server.codebase"));
				//url = new URL(CustomClassLoader.getCodebaseServer());
			//"file:/home/hfernand/workspaceHOCL/Hocl_MultisetBlastR/src/fr/inria/hocl/workflow/blastReport/multisetBlastR/./bin/");

				sun.misc.Launcher.addURLToAppClassLoader(url);
				// System.out.println("ADDED  AN URL THE APP LOADER URL ");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (message instanceof TextMessage) {
				TextMessage text = (TextMessage) message;
				log.info("ChWSListener "+text.getText());
			} else {
				
				if(ReduceSolutionFlag.waitForMolecules)
					ReduceSolutionFlag.waitForMolecules=false;
					
				ObjectMessage obj = (ObjectMessage) message;

				Molecule mol = (Molecule) obj.getObject();
				
				
				while(ReduceSolutionFlag.blockChWSListener){
					try {
						log.severe("ChWSListener: ChWSListener temporally blocked by output operation...");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						log.severe("ChWSListener: Error blocking ChWSListener by output operation: "+e.getMessage());
						e.printStackTrace();
					}
				}
				matcher.init();
				matcher.checkInitialState(mol);
				//ADDED for proving last version.
				synchronized (this) {
					sol.addMolecule(mol);
				}
				
				log.info("ChWSListener state of solution: "+sol.toString());
				
				ReduceSolutionFlag.reduce = true;
				log.info("ChWSListener received molecule."+mol.toString());
				/*
				 * sol.addMolecule(mol); sol.setNonInert(); sol.reduce();
				 * sol.printsol();
				 */

			}
		} catch (JMSException e) {
			log.severe(e.getMessage());
			e.printStackTrace(System.out);

		}

	}

}
