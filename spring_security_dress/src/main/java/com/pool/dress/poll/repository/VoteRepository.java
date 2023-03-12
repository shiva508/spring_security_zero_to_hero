package com.pool.dress.poll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.dress.poll.domine.Vote;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

	@Query("SELECT V FROM Vote V INNER JOIN FETCH V.option O where V.pollId=?1")
	public List<Vote> pollRessult(Long pollId);
	@Query("SELECT DISTINCT V FROM Vote V INNER JOIN FETCH V.option O")
	public List<Vote> castedVotes();
}
