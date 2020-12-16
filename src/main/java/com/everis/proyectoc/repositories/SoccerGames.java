package com.everis.proyectoc.repositories;

import java.io.Serializable;

public class SoccerGames implements Serializable{
	
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	private Teams local;
	private Teams visitor;
	private int localGoals;
	private int visitorGoals;
	
	public SoccerGames() {
		super();
	}
	/**
	 * @return the local
	 */
	public Teams getLocal() {
		return local;
	}
	/**
	 * @param local the local to set
	 */
	public void setLocal(Teams local) {
		this.local = local;
	}
	/**
	 * @return the visitor
	 */
	public Teams getVisitor() {
		return visitor;
	}
	/**
	 * @param visitor the visitor to set
	 */
	public void setVisitor(Teams visitor) {
		this.visitor = visitor;
	}
	/**
	 * @return the localGoals
	 */
	public int getLocalGoals() {
		return localGoals;
	}
	/**
	 * @param localGoals the localGoals to set
	 */
	public void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}
	/**
	 * @return the visitorGoals
	 */
	public int getVisitorGoals() {
		return visitorGoals;
	}
	/**
	 * @param visitorGoals the visitorGoals to set
	 */
	public void setVisitorGoals(int visitorGoals) {
		this.visitorGoals = visitorGoals;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
