package fr.inria.hocl.core.hocli.jms;

import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import fr.inria.hocl.core.hocli.Molecule;

public class ChWSPublisher implements MessageListener{

    private final Object mutex = new Object();
    private Connection connection;
    private Session session;
    private MessageProducer publisher;
    private Topic topic;
    private Topic control;

    private String url = "tcp://127.0.0.1:61616";
    private int remaining;
    
    private Molecule mol;
    private String destination;
    private String origen;
    
    private Logger log = null;	
   
    public ChWSPublisher(Connection connection, Molecule mol, String destination, String origen, String url){
    	this.mol=mol;
    	this.destination=destination;
    	this.origen=origen;
    	this.url=url;
    	log = Logger.getLogger(fr.inria.hocl.workflow.utils.IConstants.LOG_NAME);
    }

    public void run() throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
      
        log.info("FACTORY compression "+factory.isUseCompression());
		
        factory.setOptimizeAcknowledge(true);    
        factory.setUseCompression(true);
        
        connection = factory.createConnection();
        
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        topic = session.createTopic("multiset");
        control = session.createTopic("multiset.control");

        publisher = session.createProducer(topic);
        publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        session.createConsumer(control).setMessageListener(this);
        
        publish();
        waitForCompletion();
        
        session.close();
        connection.stop();
        connection.close();
    }

     private void publish() throws Exception {
        
    	log.info("Sending a molecule to "+destination);
    	
        ObjectMessage msg = session.createObjectMessage();
        System.out.println(mol.toString());
                
        DestinationMolecule destMol = new DestinationMolecule(destination,mol,origen);
        msg.setObject(destMol);
        
        publisher.send(msg);
        
        log.info("Sent molecule message: "+mol.toString());
       
       
    }

    private void waitForCompletion() throws Exception {
        System.out.println("Waiting for completion...");
        synchronized (mutex) {
            while (remaining > 0) {
                mutex.wait();
            }
        }
    }

    public void onMessage(Message message) {
        synchronized (mutex) {
        	log.info("Received report " + getReport(message) + " " + --remaining + " remaining");
       //     if (remaining == 0) {
        //        mutex.notify();
         //   }
        }
    }

    Object getReport(Message m) {
        try {
            return ((TextMessage)m).getText();
        } catch (JMSException e) {
        	log.severe(e.getMessage());
            e.printStackTrace(System.out);
            return e.toString();
        }
    }
}
