package fr.inria.hocl.core.hocli.workflow;

import java.util.HashMap;

import fr.inria.hocl.core.hocli.Atom;
import fr.inria.hocl.core.hocli.ContainerSolution;
import fr.inria.hocl.core.hocli.ExternalObject;
import fr.inria.hocl.core.hocli.Molecule;
import fr.inria.hocl.core.hocli.ReactionRule;
import fr.inria.hocl.core.hocli.SimpleIterator;
import fr.inria.hocl.core.hocli.Solution;
import fr.inria.hocl.core.hocli.Tuple;

public class MoleculeMatcher {

	
	private HashMap<String,Atom> initial_state ;
	private Atom initialAtom;
	private Molecule initialMolecule;
	
	public void init(){
		initial_state = new HashMap<String,Atom>();
	}
	
	public void clear(){
		initial_state.clear();
	}
	
	public void setInitialMolecule(Molecule mol){
		
		SimpleIterator<Atom> mainIterator = mol.newIterator();
		Atom atom = null;
		
		while ((atom = mainIterator.next()) != null) {
			if (atom instanceof ReactionRule ) {
				initialAtom = atom;
				initialMolecule = new Molecule();
				initialMolecule.add(initialAtom);
				mol.remove(atom);				
			}
		}
		
		
	}
	
	public Molecule getInitialMolecule(){
		return initialMolecule;
	}
	
	public Atom getInitialAtom(){
		return initialAtom;
	}
	
	public void checkInitialState(Molecule mol){
		
		SimpleIterator<Atom> mainIterator = mol.newIterator();
		Atom atom = null;
		
		while ((atom = mainIterator.next()) != null) {
			if (atom instanceof Tuple && ((Tuple)atom).getContainerSolution() == ContainerSolution.MAIN_SOLUTION){
				Tuple tuple = (Tuple)atom;
				initial_state.put(tuple.get(0).toString(),atom);
			}else if (atom instanceof ExternalObject && ((ExternalObject)atom).getContainerSolution() == ContainerSolution.MAIN_SOLUTION){
				ExternalObject obj = (ExternalObject)atom;
				//TODO: How check if one externalObject is the same :-S
				initial_state.put(obj.toString(),atom);
			} else 	if (atom instanceof ReactionRule && ((ReactionRule)atom).getContainerSolution() == ContainerSolution.MAIN_SOLUTION){
				ReactionRule rule = (ReactionRule)atom;
				initial_state.put(rule.getName(),atom);
			}		
					
		}
		
		mainIterator=null;
		atom=null;
	}
	
	public Solution solutionAdapter(Molecule mol){
		Solution finalSol = new Solution(); 
		
		SimpleIterator<Atom> mainIterator = mol.newIterator();
		Atom atom = null;		
		while ((atom = mainIterator.next()) != null) {
			
			Molecule molAux = new Molecule();			
			molAux.add(atom.clone());
			finalSol.addMolecule(molAux);
		}
		
	
		return finalSol;
	}
	
	public Molecule checkInertState(Molecule mol){
		SimpleIterator<Atom> mainIterator = mol.newIterator();
		Atom atom = null;
		
		while ((atom = mainIterator.next()) != null) {
			if (atom instanceof Tuple && initial_state.containsKey( ((Tuple)atom).get(0).toString() ) ){
				Tuple tuple = (Tuple) atom;
				Tuple tuple_ini = (Tuple)initial_state.get(tuple.get(0).toString());
				
				
				if(tuple_ini.size == tuple.size){
					tuple.setContainerSolution(tuple_ini.getContainerSolution());
					tuple.setMultiplicity(tuple_ini.getMultiplicity());
				}
			}else if (atom instanceof ExternalObject && initial_state.containsKey(((ExternalObject)atom).toString() ) ){
				ExternalObject obj = (ExternalObject)atom;
				ExternalObject obj_ini = (ExternalObject)initial_state.get(obj.toString());
				
				obj.setMultiplicity(obj_ini.getMultiplicity());
				obj.setContainerSolution(obj_ini.getContainerSolution());
			} /*else if (atom instanceof ReactionRule && initial_state.containsKey( ((ReactionRule)atom).getName() ) ){
				ReactionRule rule = (ReactionRule)atom;
				ReactionRule rule_ini = (ReactionRule)initial_state.get(rule.getName());
				
				rule.setContainerSolution(rule_ini.getContainerSolution());
			}	*/	
					
		}
		mainIterator=null;
		atom=null;		
		
		return mol;
	}
	
}
