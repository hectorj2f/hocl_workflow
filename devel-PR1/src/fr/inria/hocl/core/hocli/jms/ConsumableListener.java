package fr.inria.hocl.core.hocli.jms;

import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import fr.inria.hocl.workflow.utils.IConstants;

public class ConsumableListener implements MessageListener {

	private Connection connection;
	private Session session;
	private String name;
	private Topic topic;
	
	private Logger log = null;	
	

	public ConsumableListener(Connection connection, String name) {
		this.connection = connection;
		this.name = name;	
		log = Logger.getLogger(IConstants.LOG_NAME);
	}
	


	public void run() throws Exception {

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = session.createTopic("consumable."+name);
		

		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(this);

				
		log.info("Waiting for messages...");
	}

	public void onMessage(Message message) {
		try {
						
			TextMessage text = (TextMessage) message;
			String msg = text.getText();
			log.info("ConsumableListener: "+msg);
			if(msg.equals("CONSUMABLE")){
				ReduceSolutionFlag.waitForMolecules=true;
				log.info("ConsumableListener: "+name+" is consumable.");
			} else if(msg.equals("SHUTDOWN")){
				log.info("ConsumableListener: shutdown operation in process...");
				System.exit(0);
				
			} 

		} catch (JMSException e) {
			log.severe(e.getMessage());
			e.printStackTrace(System.out);

		}

	}

}
