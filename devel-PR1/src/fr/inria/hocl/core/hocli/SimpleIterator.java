package fr.inria.hocl.core.hocli;

import java.io.Serializable;


abstract public class SimpleIterator<E> implements Cloneable , Serializable {

	SimpleEntry<E> currentEntry;


	abstract public void moveToBeginning();


	abstract public void moveToEnd();


	abstract public boolean hasNext();


	abstract public boolean isAtEnd();


	abstract public boolean isAtStart();


	abstract public E next();


	abstract public E previous();


	abstract public E getElement() throws IllegalStateException;


	abstract public void remove() throws IllegalStateException;


	abstract public void insertBefore( E obj );


	abstract public void moveToIterator( SimpleIterator<E> it );


	abstract public boolean equals( SimpleIterator<E> it );


	abstract public SimpleIterator<E> clone();


	abstract public String toString();

} // abstract class SimpleIterator<E>
