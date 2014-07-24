package fr.inria.hocl.core.hocli;

import java.io.Serializable;


/**
 * Represents an atom
 * 
 */
public interface Atom extends Cloneable, Serializable{

	/**
	 * 
	 * @param atom
	 * @return true if this atom is equivalent to atom
	 */
	public boolean equals( Atom atom );
	
	/**
	 * This method creates a new object from existed one 
	 * @return the new object
	 * 
	 */
	public Atom clone() ;

} // class Atom
