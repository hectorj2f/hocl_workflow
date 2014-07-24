package fr.inria.hocl.core.hocli.jms;

import java.io.Serializable;

import fr.inria.hocl.core.hocli.Molecule;

public class DestinationMolecule implements Serializable{

	private Molecule mol;
	private String destination;
	private String origen;
	
	public DestinationMolecule(String dest, Molecule mol, String origen){
		this.destination=dest;
		this.mol=mol;
		this.origen=origen;
	}
	
	
	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public Molecule getMol() {
		return mol;
	}
	public void setMol(Molecule mol) {
		this.mol = mol;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
}
