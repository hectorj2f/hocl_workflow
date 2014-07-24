package fr.inria.hocl.core.hoclc2j;


import java.util.*;

/**
 * Descriptor of an atom
 */
public interface Atom {

	public String generateDeclarationInit( int position, SymbolsTable symbolsTable );


	public String generateReference();


	public Set<Symbols> getFreeVars();


	public void findReadOnlyReactives();


	public void setReadOnly();


	public boolean isReadOnly();


	public String getType();


	public LinkedList<String> getElementTypes();

}
