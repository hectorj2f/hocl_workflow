package fr.inria.hocl.core.hocli;


/**
 * Atom iterator specialised for the search of a reaction rule
 * 
 */
public class IteratorForRule extends AtomIterator {

	private static final long serialVersionUID = -216653196418919230L;

	private final String name;

	private final ReactionRule ruleNotToReferTo;


	public IteratorForRule( String name, ReactionRule ruleNotToReferTo ) {
		super();
		this.name = name;
		this.ruleNotToReferTo = ruleNotToReferTo;
	}


	public boolean conditionSatisfied() {
		boolean match;
		Atom atom = getAtom();

		if( atom instanceof ReactionRule
				&& ( ReactionRule ) atom != ruleNotToReferTo ) { // yes !=, not equals()
			ReactionRule rr = ( ReactionRule ) atom;
			match = ( rr.getName().equals( name ) );
		} else {
			match = false;
		}
		return match;
	}

} // class IteratorForRule
