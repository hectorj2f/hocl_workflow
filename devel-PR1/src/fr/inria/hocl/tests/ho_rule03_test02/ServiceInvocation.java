package fr.inria.hocl.tests.ho_rule03_test02;
import java.io.Serializable;

import fr.inria.hocl.core.hocli.Access;
import fr.inria.hocl.core.hocli.Atom;
import fr.inria.hocl.core.hocli.AtomIterator;
import fr.inria.hocl.core.hocli.ExternalObject;
import fr.inria.hocl.core.hocli.IteratorForExternal;
import fr.inria.hocl.core.hocli.IteratorForTuple;
import fr.inria.hocl.core.hocli.Molecule;
import fr.inria.hocl.core.hocli.MoleculeIterator;
import fr.inria.hocl.core.hocli.ReactionRule;
import fr.inria.hocl.core.hocli.Tuple;

public class ServiceInvocation extends ReactionRule implements Serializable {

	
	public ServiceInvocation(){
		super("serviceInvocation", Shot.N_SHOT);
		setTrope(Trope.REDUCER);
			AtomIterator[] _HOCL_atomIteratorArray8;
		_HOCL_atomIteratorArray8 = new AtomIterator[4];
		{
			AtomIterator[] _HOCL_atomIteratorArrayTuple12;
			_HOCL_atomIteratorArrayTuple12 = new AtomIterator[3];
			{
				class AtomIterator__HOCL_literal0 extends IteratorForExternal {
					public AtomIterator__HOCL_literal0(){
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
							
							IteratorForTuple _HOCL_tupleAtomIterator24 = (IteratorForTuple)permutation.getAtomIterator(0);
							String _HOCL_literal0 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator24.getAtomIterator(0)).getObject();
							satisfied = _HOCL_literal0.equals("CALL");
						}
						return satisfied;
					}
				
				} // end of class AtomIterator__HOCL_literal0
				_HOCL_atomIteratorArrayTuple12[0] = new AtomIterator__HOCL_literal0();
			}
			{
				class AtomIterator_nameService extends IteratorForExternal {
					public AtomIterator_nameService(){
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
							satisfied = true;
						}
						return satisfied;
					}
				
				} // end of class AtomIterator_nameService
				_HOCL_atomIteratorArrayTuple12[1] = new AtomIterator_nameService();
			}
			{
				class AtomIterator_url extends IteratorForExternal {
					public AtomIterator_url(){
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
							satisfied = true;
						}
						return satisfied;
					}
				
				} // end of class AtomIterator_url
				_HOCL_atomIteratorArrayTuple12[2] = new AtomIterator_url();
			}
			_HOCL_atomIteratorArray8[0] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple12, ServiceInvocation.this);
		}
		{
			class AtomIterator_text extends IteratorForExternal {
				public AtomIterator_text(){
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
						satisfied = true;
					}
					return satisfied;
				}
			
			} // end of class AtomIterator_text
			_HOCL_atomIteratorArray8[1] = new AtomIterator_text();
		}
		{
			AtomIterator[] _HOCL_atomIteratorArrayTuple13;
			_HOCL_atomIteratorArrayTuple13 = new AtomIterator[2];
			{
				class AtomIterator__HOCL_literal1 extends IteratorForExternal {
					public AtomIterator__HOCL_literal1(){
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
							
							IteratorForTuple _HOCL_tupleAtomIterator25 = (IteratorForTuple)permutation.getAtomIterator(2);
							String _HOCL_literal1 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator25.getAtomIterator(0)).getObject();
							satisfied = _HOCL_literal1.equals("TMP_VAR");
						}
						return satisfied;
					}
				
				} // end of class AtomIterator__HOCL_literal1
				_HOCL_atomIteratorArrayTuple13[0] = new AtomIterator__HOCL_literal1();
			}
			{
				class AtomIterator_concat extends IteratorForExternal {
					public AtomIterator_concat(){
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
							satisfied = true;
						}
						return satisfied;
					}
				
				} // end of class AtomIterator_concat
				_HOCL_atomIteratorArrayTuple13[1] = new AtomIterator_concat();
			}
			_HOCL_atomIteratorArray8[2] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple13, ServiceInvocation.this);
		}
		{
			AtomIterator[] _HOCL_atomIteratorArrayTuple14;
			_HOCL_atomIteratorArrayTuple14 = new AtomIterator[2];
			{
				class AtomIterator__HOCL_literal2 extends IteratorForExternal {
					public AtomIterator__HOCL_literal2(){
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
							
							IteratorForTuple _HOCL_tupleAtomIterator26 = (IteratorForTuple)permutation.getAtomIterator(3);
							String _HOCL_literal2 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator26.getAtomIterator(0)).getObject();
							satisfied = _HOCL_literal2.equals("INVOKE");
						}
						return satisfied;
					}
				
				} // end of class AtomIterator__HOCL_literal2
				_HOCL_atomIteratorArrayTuple14[0] = new AtomIterator__HOCL_literal2();
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
						  && ((ExternalObject)atom).getObject() instanceof Integer) {
							
							IteratorForTuple _HOCL_tupleAtomIterator27 = (IteratorForTuple)permutation.getAtomIterator(3);
							Integer value = (Integer)((IteratorForExternal)_HOCL_tupleAtomIterator27.getAtomIterator(1)).getObject();
							satisfied = (value == 1);
						}
						return satisfied;
					}
				
				} // end of class AtomIterator_value
				_HOCL_atomIteratorArrayTuple14[1] = new AtomIterator_value();
			}
			_HOCL_atomIteratorArray8[3] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple14, ServiceInvocation.this);
		}
		MoleculeIterator[] _HOCL_moleculeIteratorArray8 = new MoleculeIterator[0];
		permutation = newPermutation(_HOCL_atomIteratorArray8, _HOCL_moleculeIteratorArray8);
	}

	public ServiceInvocation clone() {
		 return new ServiceInvocation();
	}
	public void addType(String s){}

	// compute result of the rule serviceInvocation
	protected Molecule computeResult(){
		ExternalObject object;
		ReactionRule rule;
		String[] string;
		Tuple tuple;
		
		IteratorForTuple _HOCL_tupleAtomIterator28 = (IteratorForTuple)permutation.getAtomIterator(0);
		String url = (String)((IteratorForExternal)_HOCL_tupleAtomIterator28.getAtomIterator(2)).getObject();
		IteratorForTuple _HOCL_tupleAtomIterator29 = (IteratorForTuple)permutation.getAtomIterator(0);
		String nameService = (String)((IteratorForExternal)_HOCL_tupleAtomIterator29.getAtomIterator(1)).getObject();
		Molecule mol0 = new Molecule();
		Tuple tuple24 = new Tuple(3);
		tuple24.set(0, new ExternalObject("CALL"));
		tuple24.set(1, new ExternalObject(nameService));
		tuple24.set(2, new ExternalObject(url));
		tuple = tuple24;
		mol0.add(tuple.clone());
		this.addType("Tuple");
		
		
		Tuple tuple25 = new Tuple(3);
		tuple25.set(0, new ExternalObject("RESULT"));
		tuple25.set(1, new ExternalObject("ChWS_5"));
		tuple25.set(2, new ExternalObject("RSULTADORRRR"));
		tuple = tuple25;
		mol0.add(tuple.clone());
		this.addType("Tuple");
		
		
		return mol0;
	}

} // end of class ServiceInvocation
