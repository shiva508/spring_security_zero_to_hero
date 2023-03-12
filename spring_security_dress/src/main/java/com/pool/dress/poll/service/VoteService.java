package com.pool.dress.poll.service;

import java.util.List;

import com.security.dress.poll.domine.Vote;

public interface VoteService {
	public Vote castVote(Vote vote);
	public List<Vote> castedVotes();
	public List<Vote> pollRessult(Long pollId);
}
