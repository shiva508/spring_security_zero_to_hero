package com.pool.dress.poll.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.security.dress.poll.domine.Vote;
import com.security.dress.poll.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	
	@Transactional
	@Override
	public Vote castVote(Vote vote) {
		return voteRepository.save(vote);
	}

	@Transactional
	@Override
	public List<Vote> castedVotes() {
		return voteRepository.findAll();
	}

	@Transactional
	@Override
	public List<Vote> pollRessult(Long pollId) {
		return voteRepository.pollRessult(pollId);
	}

}
