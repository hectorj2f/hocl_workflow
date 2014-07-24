package fr.inria.hocl.core.hocli.workflow;

import java.util.logging.Logger;

import fr.inria.hocl.workflow.utils.IConstants;

public class WorkflowNode_Siesta {

	private final long MAX_SIESTA_TIME = 1200000;
	private long startTimer;
	private long siestaTime;
	private int wakeUp_counter;
	private int weight_siesta;
	private SiestaType type;
	
	private Logger log = null;	
	
	
	public WorkflowNode_Siesta(SiestaType type) {
		startTimer = 0;
		siestaTime = 2000;
		wakeUp_counter = 0;
		weight_siesta = 4;
		this.type=type;
		log = Logger.getLogger(IConstants.LOG_NAME);
	}
	
	public WorkflowNode_Siesta() {
		startTimer = 0;
		siestaTime = 2000;
		wakeUp_counter = 0;
		weight_siesta = 4;
		this.type=SiestaType.AWAKE;
		log = Logger.getLogger(IConstants.LOG_NAME);
	}

	public void start() {
		startTimer = System.currentTimeMillis();
	}

	public void sleep() throws InterruptedException {
		if(type.equals(SiestaType.LAZY))
			this.sleepLazy();
		else if (type.equals(SiestaType.AWAKE))
			this.sleepAwake();
	}	
	
	public void sleepAwake() throws InterruptedException {
		log.info("WorkflowNode_Siesta: Sleeping awake method.");
		Thread.sleep(2*siestaTime);
	}
	
	public void sleepSleepingBeauty() throws InterruptedException {
		//Thread.sleep(2*siestaTime);
	}
		
	public void sleepLazy() throws InterruptedException {
		log.info("WorkflowNode_Siesta: Sleeping lazy method.");
		if (startTimer == 0) {
			Thread.sleep(siestaTime);
		} else {
			long time = System.currentTimeMillis() - startTimer;
			
			if (wakeUp_counter > 1)
				weight_siesta = 2;
			
			
			if (time < 10000) {	
				time =siestaTime * (int) Math.pow(weight_siesta, 1) ;
				log.info("WorkflowNode_Siesta: SLEEP :" +time);
				Thread.sleep(time);				
			} else if (time > 10000 && time < 50000) {
				time =siestaTime * (int) Math.pow(weight_siesta, 2) ;
				log.info("WorkflowNode_Siesta: SLEEP :" +time);
				Thread.sleep(time);
			} else if (time > 50000 && time < 100000) {
				time =siestaTime * (int) Math.pow(weight_siesta, 3) ;
				log.info("WorkflowNode_Siesta: SLEEP :" +time);
				Thread.sleep(time);
			} else if (time > 150000 && time < 350000) {
				time =siestaTime * (int) Math.pow(weight_siesta, 4) ;
				log.info("WorkflowNode_Siesta: SLEEP :" +time);
				Thread.sleep(time);
			} else if (time > 350000 && time < 500000) {
				time =siestaTime * (int) Math.pow(weight_siesta, 5) ;
				log.info("WorkflowNode_Siesta: SLEEP :" +time);
				Thread.sleep(time);
			} else if (time > 500000) {
				log.info("WorkflowNode_Siesta: SLEEP :" +MAX_SIESTA_TIME);
				Thread.sleep(MAX_SIESTA_TIME);
			}		
			
			
			//Thread.sleep(siestaTime);
			

		}
	}
/*
	public long sleepProof()  {
		if (startTimer == 0) {
			return siestaTime;
		} else {
			long time = System.currentTimeMillis() - startTimer;
			if (wakeUp_counter > 1 && time < 500000)
				weight_siesta = 2;

			if (time < 10000) {
				return siestaTime * (int) Math.pow(weight_siesta, 1);
			} else if (time > 10000 && time < 50000) {
				return siestaTime * (int) Math.pow(weight_siesta, 2);
			} else if (time > 50000 && time < 150000) {
				return siestaTime * (int) Math.pow(weight_siesta, 3);
			} else if (time > 150000 && time < 500000) {
				return siestaTime * (int) Math.pow(weight_siesta, 4);
			} else if (time > 500000) {
				return MAX_SIESTA_TIME;
			}
			
			return MAX_SIESTA_TIME;

		}
	}
*/
	public void wakeUp() {
		Thread.interrupted();
		startTimer = 0;
		wakeUp_counter++;
	}
	/*
	public static void main(String args[]){
		WorkflowNode_Siesta w = new WorkflowNode_Siesta();
		
		System.out.println(w.sleepProof());
		w.start();
		
		while(true){
			long value = w.sleepProof();
			if( value == 128000){
				w.wakeUp();
				w.start();
			}
			System.out.println(w.sleepProof());
		}
	}
*/
}
