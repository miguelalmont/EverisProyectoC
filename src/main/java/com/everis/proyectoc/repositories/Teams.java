package com.everis.proyectoc.repositories;

import java.io.Serializable;

public class Teams implements Serializable{
	
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int wins;
	private int loose;
	private int draw;
	private int goalsFor;
	private int goalsAgainst;
	
	public Teams() {
		super();
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * @return the loose
	 */
	public int getLoose() {
		return loose;
	}
	/**
	 * @param loose the loose to set
	 */
	public void setLoose(int loose) {
		this.loose = loose;
	}
	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}
	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}
	/**
	 * @return the goalsFor
	 */
	public int getGoalsFor() {
		return goalsFor;
	}
	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}
	/**
	 * @return the goalsAgainst
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	/**
	 * @param goalsAgainst the goalsAgainst to set
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	
}
