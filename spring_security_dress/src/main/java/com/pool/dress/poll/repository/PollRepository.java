package com.pool.dress.poll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.security.dress.poll.domine.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
	@Query("SELECT DISTINCT P FROM Poll P JOIN FETCH P.options O")
	public List<Poll> pollList();
}
