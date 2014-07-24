package fr.inria.hocl.workflow.utils;

import java.util.AbstractMap.SimpleEntry;

import fr.inria.hocl.core.hocli.PermutationNoRepeat;
import fr.inria.hocl.core.hocli.SimpleIterator;
import fr.inria.hocl.core.hocli.SimpleLinkedList;
import fr.inria.hocl.core.hocli.SolutionObserver;
import fr.inria.hocl.core.hocli.StrategyFairRoundRobin;
/*
 * Methods used by startEngine HOCL to control if there is any new molecule in order to call reduceSolution method.
 */
public class FunctionUtils {

	private SimpleLinkedList<String> observersAdd; // list of observers
	
	public FunctionUtils(){
		observersAdd = new SimpleLinkedList<String>();
	}
	
	public void setSolutionObserverList(SimpleLinkedList<SolutionObserver> newObserversAdd){
		
		
		SimpleIterator<SolutionObserver> it_newObs;
		it_newObs = newObserversAdd.newIterator();
		it_newObs.moveToBeginning();
		
		while( !it_newObs.isAtEnd() ) {
			SolutionObserver oSolutionObserver = it_newObs.next();
			if(oSolutionObserver instanceof PermutationNoRepeat) {
				PermutationNoRepeat oPermutationNoRepeat = (PermutationNoRepeat)oSolutionObserver;
				observersAdd.add(oPermutationNoRepeat.toString());
			}
			if(oSolutionObserver instanceof StrategyFairRoundRobin) {
				StrategyFairRoundRobin oStrategyFairRoundRobin = (StrategyFairRoundRobin)oSolutionObserver;
				observersAdd.add(oStrategyFairRoundRobin.toString());
			}
			
		}
	}
	
	public boolean anyChange(SimpleLinkedList<SolutionObserver> newObserversAdd) {
		
		if( observersAdd.size() != newObserversAdd.size()){
			return true;
		}
		SimpleIterator<SolutionObserver> it_newObs;
		SimpleIterator<String> it_obs;
		it_obs = observersAdd.newIterator();
		it_obs.moveToBeginning();
		it_newObs = newObserversAdd.newIterator();
		it_newObs.moveToBeginning();
		
		while( !it_newObs.isAtEnd() ) {
			SolutionObserver oSolutionObserver = it_newObs.next();
			if(!it_obs.next().toString().equals(oSolutionObserver.toString()) ) {
				return true;
			}
		}
				
		return false;
	}
}
