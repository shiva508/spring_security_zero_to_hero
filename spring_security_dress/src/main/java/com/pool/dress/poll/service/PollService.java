package com.pool.dress.poll.service;

import java.util.List;

import com.security.dress.poll.domine.Poll;
import com.security.dress.poll.form.ResponseForm;

public interface PollService {
	
	public Poll savePoll(Poll poll);
	
	public List<Poll> allPolls();
	
	public Poll updatePoll(Poll poll);
	
	public Poll getPollByPollId(Long pollId);
	
	public ResponseForm deletePollByPollId(Long pollId);
}
