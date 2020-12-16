package com.everis.proyectoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepositoryI extends JpaRepository<Teams, Integer>{
	
	public Teams findTeamsByTeamId(final int teamId);
	
	public List<Teams> findTeamsByName(final String teamName);
}
