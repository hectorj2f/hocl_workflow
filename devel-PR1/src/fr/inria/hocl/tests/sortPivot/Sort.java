package fr.inria.hocl.tests.sortPivot;
import fr.inria.hocl.core.hocli.*;
import java.io.*;

public class Sort extends ReactionRule implements Serializable {

	
	public Sort(){
		super("sort", Shot.ONE_SHOT);
		setTrope(Trope.EXPANSER);
			AtomIterator[] _HOCL_atomIteratorArray11;
		_HOCL_atomIteratorArray11 = new AtomIterator[1];
		{
			class IteratorSolution0 extends IteratorForSolution {
				protected Permutation makeSubPermutation(){
					Permutation perm;
					AtomIterator[] _HOCL_atomIteratorArray11;
					_HOCL_atomIteratorArray11 = new AtomIterator[0];
					
					MoleculeIterator[] _HOCL_moleculeIteratorArray11 = new MoleculeIterator[1];
					_HOCL_moleculeIteratorArray11[0] = new MoleculeIterator(1); // w
					
					perm = newPermutation(_HOCL_atomIteratorArray11, _HOCL_moleculeIteratorArray11);
					return perm;
				}
			
			} // class IteratorSolution0
			_HOCL_atomIteratorArray11[0] = new IteratorSolution0();
		}
		MoleculeIterator[] _HOCL_moleculeIteratorArray12 = new MoleculeIterator[0];
		permutation = newPermutation(_HOCL_atomIteratorArray11, _HOCL_moleculeIteratorArray12);
	}

	public Sort clone() {
		 return new Sort();
	}
	public void addType(String s){}

	// compute result of the rule sort
	protected Molecule computeResult(){
		ExternalObject object;
		ReactionRule rule;
		String[] string;
		Tuple tuple;
		
		IteratorForSolution _HOCL_iteratorSolution5 = (IteratorForSolution)permutation.getAtomIterator(0);
		Molecule w = _HOCL_iteratorSolution5.getSubPermutation().getMatchedMolecule(0);
		Molecule mol0 = new Molecule();
		class _HOCL_RR1 extends ReactionRule implements Serializable {
		
			
			public _HOCL_RR1(){
				super("_HOCL_RR1", Shot.ONE_SHOT);
				setTrope(Trope.EXPANSER);
					AtomIterator[] _HOCL_atomIteratorArray13;
				_HOCL_atomIteratorArray13 = new AtomIterator[1];
				{
					class AtomIterator_p extends IteratorForExternal {
						public AtomIterator_p(){
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
								satisfied = true;
							}
							return satisfied;
						}
					
					} // end of class AtomIterator_p
					_HOCL_atomIteratorArray13[0] = new AtomIterator_p();
				}
				MoleculeIterator[] _HOCL_moleculeIteratorArray13 = new MoleculeIterator[0];
				permutation = newPermutation(_HOCL_atomIteratorArray13, _HOCL_moleculeIteratorArray13);
			}
		
			public _HOCL_RR1 clone() {
				 return new _HOCL_RR1();
			}
			public void addType(String s){}
		
			// compute result of the rule _HOCL_RR1
			protected Molecule computeResult(){
				ExternalObject object;
				ReactionRule rule;
				String[] string;
				Tuple tuple;
				
				Integer p = (Integer)((IteratorForExternal)permutation.getAtomIterator(0)).getObject();
				Molecule mol1 = new Molecule();
				class Greater extends ReactionRule implements Serializable {
				
					private final Integer p;
					
					public Greater(final Integer p){
						super("greater", Shot.N_SHOT);
						setTrope(Trope.REDUCER);
						this.p = p;
							AtomIterator[] _HOCL_atomIteratorArray14;
						_HOCL_atomIteratorArray14 = new AtomIterator[2];
						{
							class AtomIterator_x extends IteratorForExternal {
								public AtomIterator_x(){
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
										satisfied = true;
									}
									return satisfied;
								}
							
							} // end of class AtomIterator_x
							_HOCL_atomIteratorArray14[0] = new AtomIterator_x();
						}
						{
							AtomIterator[] _HOCL_atomIteratorArrayTuple2;
							_HOCL_atomIteratorArrayTuple2 = new AtomIterator[2];
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
											
											IteratorForTuple _HOCL_tupleAtomIterator4 = (IteratorForTuple)permutation.getAtomIterator(1);
											String _HOCL_literal0 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator4.getAtomIterator(0)).getObject();
											satisfied = _HOCL_literal0.equals("G");
										}
										return satisfied;
									}
								
								} // end of class AtomIterator__HOCL_literal0
								_HOCL_atomIteratorArrayTuple2[0] = new AtomIterator__HOCL_literal0();
							}
							{
								class IteratorSolution1 extends IteratorForSolution {
									protected Permutation makeSubPermutation(){
										Permutation perm;
										AtomIterator[] _HOCL_atomIteratorArray14;
										_HOCL_atomIteratorArray14 = new AtomIterator[0];
										
										MoleculeIterator[] _HOCL_moleculeIteratorArray14 = new MoleculeIterator[1];
										_HOCL_moleculeIteratorArray14[0] = new MoleculeIterator(1); // w
										
										perm = newPermutation(_HOCL_atomIteratorArray14, _HOCL_moleculeIteratorArray14);
										return perm;
									}
								
								} // class IteratorSolution1
								_HOCL_atomIteratorArrayTuple2[1] = new IteratorSolution1();
							}
							_HOCL_atomIteratorArray14[1] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple2, Greater.this);
						}
						MoleculeIterator[] _HOCL_moleculeIteratorArray15 = new MoleculeIterator[0];
						permutation = newPermutation(_HOCL_atomIteratorArray14, _HOCL_moleculeIteratorArray15);
					}
				
					public Greater clone() {
						 return new Greater(0);
					}
					public void addType(String s){}
				
					// compute result of the rule greater
					protected Molecule computeResult(){
						ExternalObject object;
						ReactionRule rule;
						String[] string;
						Tuple tuple;
						
						IteratorForTuple _HOCL_tupleAtomIterator5 = (IteratorForTuple)permutation.getAtomIterator(1);
						IteratorForSolution _HOCL_iteratorSolution6 = (IteratorForSolution)_HOCL_tupleAtomIterator5.getAtomIterator(1);
						Molecule w = _HOCL_iteratorSolution6.getSubPermutation().getMatchedMolecule(0);
						Integer x = (Integer)((IteratorForExternal)permutation.getAtomIterator(0)).getObject();
						Molecule mol2 = new Molecule();
						Tuple tuple4 = new Tuple(2);
						tuple4.set(0, ExternalObject.getHOCL_TypeTranslation("G"));
						Solution solution0 = new Solution();
						{
							Molecule mol3 = new Molecule();
							if (ExternalObject.getHOCL_TypeTranslation(x) instanceof ExternalObject) {
								ExternalObject auxObject = (ExternalObject) ExternalObject.getHOCL_TypeTranslation(x);
								mol3.add(auxObject);
								string = auxObject.getObject().getClass().toString().split("\\.");
								this.addType(string[string.length-1]);
							} else {
								mol3.add(ExternalObject.getHOCL_TypeTranslation(x));
							if(ExternalObject.getHOCL_TypeTranslation(x) instanceof Tuple) 
								this.addType("Tuple");
							}
							
							mol3.add(w);
							solution0.addMolecule(mol3);
						}
						tuple4.set(1, solution0);
						tuple = tuple4;
						mol2.add(tuple);
						this.addType("Tuple");
						
						
						return mol2;
					}
				
				} // end of class Greater
				
				rule = new Greater(p);
				mol1.add(rule);
				this.addType(rule.getName());
				
				
				class Lower extends ReactionRule implements Serializable {
				
					private final Integer p;
					
					public Lower(final Integer p){
						super("lower", Shot.N_SHOT);
						setTrope(Trope.REDUCER);
						this.p = p;
							AtomIterator[] _HOCL_atomIteratorArray16;
						_HOCL_atomIteratorArray16 = new AtomIterator[2];
						{
							class AtomIterator_x extends IteratorForExternal {
								public AtomIterator_x(){
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
										satisfied = true;
									}
									return satisfied;
								}
							
							} // end of class AtomIterator_x
							_HOCL_atomIteratorArray16[0] = new AtomIterator_x();
						}
						{
							AtomIterator[] _HOCL_atomIteratorArrayTuple3;
							_HOCL_atomIteratorArrayTuple3 = new AtomIterator[2];
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
											
											IteratorForTuple _HOCL_tupleAtomIterator6 = (IteratorForTuple)permutation.getAtomIterator(1);
											String _HOCL_literal1 = (String)((IteratorForExternal)_HOCL_tupleAtomIterator6.getAtomIterator(0)).getObject();
											satisfied = _HOCL_literal1.equals("L");
										}
										return satisfied;
									}
								
								} // end of class AtomIterator__HOCL_literal1
								_HOCL_atomIteratorArrayTuple3[0] = new AtomIterator__HOCL_literal1();
							}
							{
								class IteratorSolution2 extends IteratorForSolution {
									protected Permutation makeSubPermutation(){
										Permutation perm;
										AtomIterator[] _HOCL_atomIteratorArray16;
										_HOCL_atomIteratorArray16 = new AtomIterator[0];
										
										MoleculeIterator[] _HOCL_moleculeIteratorArray16 = new MoleculeIterator[1];
										_HOCL_moleculeIteratorArray16[0] = new MoleculeIterator(1); // w
										
										perm = newPermutation(_HOCL_atomIteratorArray16, _HOCL_moleculeIteratorArray16);
										return perm;
									}
								
								} // class IteratorSolution2
								_HOCL_atomIteratorArrayTuple3[1] = new IteratorSolution2();
							}
							_HOCL_atomIteratorArray16[1] = new IteratorForTuple(_HOCL_atomIteratorArrayTuple3, Lower.this);
						}
						MoleculeIterator[] _HOCL_moleculeIteratorArray17 = new MoleculeIterator[0];
						permutation = newPermutation(_HOCL_atomIteratorArray16, _HOCL_moleculeIteratorArray17);
					}
				
					public Lower clone() {
						 return new Lower(0);
					}
					public void addType(String s){}
				
					// compute result of the rule lower
					protected Molecule computeResult(){
						ExternalObject object;
						ReactionRule rule;
						String[] string;
						Tuple tuple;
						
						IteratorForTuple _HOCL_tupleAtomIterator7 = (IteratorForTuple)permutation.getAtomIterator(1);
						IteratorForSolution _HOCL_iteratorSolution7 = (IteratorForSolution)_HOCL_tupleAtomIterator7.getAtomIterator(1);
						Molecule w = _HOCL_iteratorSolution7.getSubPermutation().getMatchedMolecule(0);
						Integer x = (Integer)((IteratorForExternal)permutation.getAtomIterator(0)).getObject();
						Molecule mol4 = new Molecule();
						Tuple tuple5 = new Tuple(2);
						tuple5.set(0, ExternalObject.getHOCL_TypeTranslation("L"));
						Solution solution1 = new Solution();
						{
							Molecule mol5 = new Molecule();
							if (ExternalObject.getHOCL_TypeTranslation(x) instanceof ExternalObject) {
								ExternalObject auxObject = (ExternalObject) ExternalObject.getHOCL_TypeTranslation(x);
								mol5.add(auxObject);
								string = auxObject.getObject().getClass().toString().split("\\.");
								this.addType(string[string.length-1]);
							} else {
								mol5.add(ExternalObject.getHOCL_TypeTranslation(x));
							if(ExternalObject.getHOCL_TypeTranslation(x) instanceof Tuple) 
								this.addType("Tuple");
							}
							
							mol5.add(w);
							solution1.addMolecule(mol5);
						}
						tuple5.set(1, solution1);
						tuple = tuple5;
						mol4.add(tuple);
						this.addType("Tuple");
						
						
						return mol4;
					}
				
				} // end of class Lower
				
				rule = new Lower(p);
				mol1.add(rule);
				this.addType(rule.getName());
				
				
				Tuple tuple6 = new Tuple(2);
				tuple6.set(0, ExternalObject.getHOCL_TypeTranslation("G"));
				Solution solution2 = new Solution();
				{
					Molecule mol6 = new Molecule();
					solution2.addMolecule(mol6);
				}
				tuple6.set(1, solution2);
				tuple = tuple6;
				mol1.add(tuple);
				this.addType("Tuple");
				
				
				Tuple tuple7 = new Tuple(2);
				tuple7.set(0, ExternalObject.getHOCL_TypeTranslation("L"));
				Solution solution3 = new Solution();
				{
					Molecule mol7 = new Molecule();
					solution3.addMolecule(mol7);
				}
				tuple7.set(1, solution3);
				tuple = tuple7;
				mol1.add(tuple);
				this.addType("Tuple");
				
				
				if (ExternalObject.getHOCL_TypeTranslation(p) instanceof ExternalObject) {
					ExternalObject auxObject = (ExternalObject) ExternalObject.getHOCL_TypeTranslation(p);
					mol1.add(auxObject);
					string = auxObject.getObject().getClass().toString().split("\\.");
					this.addType(string[string.length-1]);
				} else {
					mol1.add(ExternalObject.getHOCL_TypeTranslation(p));
				if(ExternalObject.getHOCL_TypeTranslation(p) instanceof Tuple) 
					this.addType("Tuple");
				}
				
				return mol1;
			}
		
		} // end of class _HOCL_RR1
		
		rule = new _HOCL_RR1();
		mol0.add(rule);
		this.addType(rule.getName());
		
		
		mol0.add(w);
		return mol0;
	}

} // end of class Sort
