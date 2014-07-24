package fr.inria.hocl.core.hoclc2j;


import java.util.*;

public class MoleculeVarPat implements Symbols { // 

	public final String name;

	int position;


	public MoleculeVarPat( String varName ) {
		name = varName;
	}


	public Symbols lookUp( String ident ) {
		return ( ident.equals( name ) ) ? this : null;
	}


	public String generateDeclarationInit() {
		return "Molecule " + name + "; // FIXME";
	}


	public String generateReference() {
		return name;
	}


	public void setPosition( int position ) {
		this.position = position;
	}


	public String generateDeclaration( Symbols symbols, String permutation ) {
		String s = "";
		if( symbols == this ) {
			s = "Molecule " + name;
			if( permutation.length() == 0 ) { // FIXME: molecule variable not inside a
																				// solution pattern
				s = s + " = new Molecule();"; // matches nothing
			} else {
				
				//FIXME: If i put that HOCL doesnt procces molecules as arrays into a solution but now
				// I have to put IOSender invocation in the by .... side instead of if .... side like before.
				s = s + " = " + permutation + ".getMatchedMolecule(" + position + ");";
				// FIXME: Hector IOSender OLD
				//s = s + " = " + permutation + ".getSolution().getContents();";			    
				
			}
		}
		return s;
	}


	public Set<Symbols> getVariables() {
		Set<Symbols> vars = new HashSet<Symbols>();
		vars.add( this );
		return vars;
	}


	public String toString() {
		return "?" + name;
	}


	public String generateIdent() {
		return ""; // no ident
	}


	public String generateVariableDecl() {
		return ""; // no ident => no declaration
	}

}
