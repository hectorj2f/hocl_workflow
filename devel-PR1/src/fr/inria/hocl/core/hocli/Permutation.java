package fr.inria.hocl.core.hocli;

import java.io.Serializable;


/**
 * Represents the set of considered atoms for a reaction rule. Allows to
 * enumerate (and test) all permutations.
 * 
 */
public interface Permutation extends SolutionObserver, Serializable {

	/**
	 * 
	 * @return the number of atoms looked for
	 */
	public int size();


	//FIXME: Hector, IOSebder Put a molecule inside of external calling to methods
	public Solution getSolution();
	
	/**
	 * Set the solution for the permutation
	 * 
	 * @param solution
	 */
	public void setSolution( Solution solution );


	/**
	 * Find the next match (may be the current state)
	 * 
	 */
	public boolean nextMatch();


	/**
	 * Find the next match even if the current state matches
	 * 
	 */
	public boolean nextMatchHard();


	/**
	 * 
	 * @return the ith atom
	 */
	public AtomIterator getAtomIterator( int i );


	/**
	 * Restart the enumeration
	 * 
	 */
	public void reset();


	/**
	 * 
	 * @return the molecule of the considered permutation (only pattern of atoms)
	 */
	public Molecule getPermutation();


	/**
	 * 
	 * @return the molecule currently considered (atoms and molecules) without the
	 *         read-only reactives
	 */
	public Molecule getReactives();


	/**
	 * 
	 * @return the ith molecule matched (pattern of molecule)
	 */
	public Molecule getMatchedMolecule( int i );


	/**
	 * 
	 * @param solution
	 * @return true if all the atoms of the solution have been matched
	 */
	public boolean wholeSolutionMatched();


	/**
	 * 
	 * @return true if there is no more permutation to enumerate
	 */
	public boolean isFinal();

}
