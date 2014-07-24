package fr.inria.hocl.core.hocli;


import java.io.Serializable;

/**
 * Represents an external Java object, i.e. not an object from the interpretor
 * 
 */
public class ExternalObject implements Atom, Cloneable, Serializable {

	private static final long serialVersionUID = -3044136841583809892L;

	private final Object object;
	
	private ContainerSolution containerSolution;

	private long multiplicity;

	public ExternalObject( Object object ) {
		this.object = object;
		containerSolution = ContainerSolution.SUB_SOLUTION;
		multiplicity = Constants.MULTIPLICITY_DEF;
	}
	
	


	public long getMultiplicity() {
		return multiplicity;
	}




	public void setMultiplicity(long multiplicity) {
		this.multiplicity = multiplicity;
	}




	public ContainerSolution getContainerSolution() {
		return containerSolution;
	}


	public void setContainerSolution(ContainerSolution containerSolution) {
		this.containerSolution = containerSolution;
	}



	public boolean equals( Atom atom ) {
		boolean eq = false;
		if( atom instanceof ExternalObject ) {
			eq = ( ( ExternalObject ) atom ).object.equals( object );
		}
		return eq;
	}

	/**
	 * This method doesnt clone the object,it returns the same object by optimization reasons (performance and memory consumption).
	 * @return the same object
	 */
	public ExternalObject clone() {
		/*
		ExternalObject x;
		try {
			x = new ExternalObject( super.clone());
			return x;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	*/
		
		if (object instanceof String)
			return new ExternalObject(String.valueOf(object));
		else if (object instanceof Integer)
			return new ExternalObject(new Integer((Integer)object));
		else if (object instanceof Boolean)
			return new ExternalObject(new Boolean((Boolean)object));
		else if (object instanceof Float)
			return new ExternalObject(new Float((Float)object));
		else if (object instanceof Long)
			return new ExternalObject(new Long((Long)object));
		else if (object instanceof Double)
			return new ExternalObject(new Double((Double)object));
		else if (object instanceof Short)
			return new ExternalObject(new Short((Short)object));
		
		return this;
		
	}
	/**
	 * 
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	
	//FIXME: Hector, Tuple Solution types supported in javaExpressions as return type

	public static Atom getHOCL_TypeTranslation(Object javaExpression){
		if (javaExpression instanceof Tuple){
			return (Tuple)javaExpression;
		} else if (javaExpression instanceof Solution){
			return (Solution)javaExpression;
		} else {
		    return new ExternalObject(javaExpression);	
		}
	}

	public String toString() {
		String s = new String();

		if( object instanceof String )
			s = s + "\"" + object + "\"";
		else
			s = object.toString();
		return s;
	}

} // class ExternalObject
