package fr.inria.hocl.core.hoclc2j;


import java.util.*;

public class MoleculeWithRuleDef implements Molecule {

	private ReactionRulePat reactionRulePat;

	private Molecule molecule;


	public MoleculeWithRuleDef( Molecule molecule, ReactionRulePat reactionRulePat ) {
		this.molecule = molecule;
		this.reactionRulePat = reactionRulePat;
	}


	public String generateDeclarationInit() {
		String s = "";
		Set<Symbols> freeVars = molecule.getFreeVars();
		if( freeVars.contains( reactionRulePat ) ) {
			s = reactionRulePat.generateDeclaration( reactionRulePat, "" ); // FIXME:
																																			// check
																																			// that ""
		}
		return s + "\n" + molecule.generateDeclarationInit();
	}


	public String generateReference() {
		return molecule.generateReference();
	}


	public Set<Symbols> getFreeVars() {
		Set<Symbols> freeVars = molecule.getFreeVars();
		freeVars.addAll( reactionRulePat.reactionRule.getFreeVars() );
		return freeVars;
	}


	public String generateAllVariablesDeclaration( Set<Symbols> argumentVars ) {
		return molecule.generateAllVariablesDeclaration( argumentVars );
	}


	public int size() {
		return molecule.size();
	}


	public void findReadOnlyReactives() {
		reactionRulePat.reactionRule.findReadOnlyReactives();
		molecule.findReadOnlyReactives();
	}


	public Iterator<Atom> iterator() {
		return molecule.iterator();
	}


	public String generateAddElementCode() {
		// TODO Auto-generated method stub
		String code = "MoleculeWithRuleDef\n";
		return code;
	}


	public LinkedList<String> getElementTypes() {
		return this.molecule.getElementTypes();
	}
}
