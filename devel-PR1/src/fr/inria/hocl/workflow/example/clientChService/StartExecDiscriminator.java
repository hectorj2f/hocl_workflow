package fr.inria.hocl.workflow.example.clientChService;
import fr.inria.hocl.core.hocli.*;
import fr.inria.hocl.core.hocli.*;
import fr.inria.hocl.core.hocli.rmi.*;
import java.io.*;

public class StartExecDiscriminator extends ReactionRule implements Serializable {

	
	public StartExecDiscriminator(){
		super("startExecDiscriminator", Shot.ONE_SHOT);
		setTrope(Trope.OPTIMIZER);
			AtomIterator[] _HOCL_atomIteratorArray13;
		_HOCL_atomIteratorArray13 = new AtomIterator[1];
		{
			AtomIterator[] _HOCL_atomIteratorArrayTuple12;
			_HOCL_atomIteratorArrayTuple12 = new AtomIterator[2];
			{
				class AtomIterator__HOCL_literal18 extends IteratorForExternal {
					public AtomIterator__HOCL_literal18(){
						access = Access.REWRITE;
					}
					@Override
					public boolean conditionSatisfied() {
						Atom atom;
						boolean satisfied;
						atom = iterator.getElement();
						satisfied = false;
						if (atom instanceof ExternalObject
						  && ((ExternalObject)atom).getObject() instanceof String) {
							
							IteratorForTuple _HOCL_tupleAtomIterator41 = (IteratorForTuple)permutation.getAtomIterator(0);
							String _HOCL_literal18 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator41.getAtomIterator(0)).getObject();
							satisfied = _HOCL_literal18.equals("DISCRIMINATOR");
						}
						return satisfied;
					}
				
				} // end of class AtomIterator__HOCL_literal18
				_HOCL_atomIteratorArrayTuple12[0] = new AtomIterator__HOCL_literal18();
			}
			{
				class AtomIterator_value extends IteratorForExternal {
					public AtomIterator_value(){
						access = Access.REWRITE;
					}
					@Override
					public boolean conditionSatisfied() {
						Atom atom;
						boolean satisfied;
						atom = iterator.getElement();
						satisfied = false;
						if (atom instanceof ExternalObject
						  && ((ExternalObject)atom).getObject() instanceof String) {
							
							IteratorForTuple _HOCL_tupleAtomIterator42 = (IteratorForTuple)permutation.getAtomIterator(0);
							String value = (String)((IteratorForExternal)_HOCL_tupleAtomIterator42.getAtomIterator(1)).getObject();
							satisfied = (value.equals("Yes"));
						}
						return satisfied;
					}
				
				} // end of class AtomIterator_value
				_HOCL_atomIteratorArrayTuple12[1] = new AtomIterator_value();
			}
			_HOCL_atomIteratorArray13[0] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple12, StartExecDiscriminator.this);
		}
		MoleculeIterator[] _HOCL_moleculeIteratorArray13 = new MoleculeIterator[0];
		permutation = newPermutation(_HOCL_atomIteratorArray13, _HOCL_moleculeIteratorArray13);
	}

	public StartExecDiscriminator clone() {
		 return new StartExecDiscriminator();
	}
	public void addType(String s){}

	// compute result of the rule startExecDiscriminator
	protected Molecule computeResult(){
		ExternalObject object;
		ReactionRule rule;
		String[] string;
		Tuple tuple;
		
		Molecule mol15 = new Molecule();
		Tuple tuple32 = new Tuple(2);
		tuple32.set(0, ExternalObject.getHOCL_TypeTranslation("INVOKE"));
		tuple32.set(1, ExternalObject.getHOCL_TypeTranslation(1));
		tuple = tuple32;
		mol15.add(tuple);
		this.addType("Tuple");
		
		
		return mol15;
	}

} // end of class StartExecDiscriminator
