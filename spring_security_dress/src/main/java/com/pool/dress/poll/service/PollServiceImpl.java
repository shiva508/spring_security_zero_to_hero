package com.pool.dress.poll.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dress.poll.domine.Poll;
import com.security.dress.poll.form.ResponseForm;
import com.security.dress.poll.repository.PollRepository;
import com.security.oauth.exception.UserNotFoundException;

@Service
public class PollServiceImpl implements PollService {
	
	@Autowired
	private PollRepository pollRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Poll savePoll(Poll poll) {
		return pollRepository.save(poll);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Poll> allPolls() {
		return pollRepository.pollList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Poll updatePoll(Poll poll) {
		return pollRepository.save(poll);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Poll getPollByPollId(Long pollId) {
		Optional<Poll> optionalPoll=pollRepository.findById(pollId);
		if(optionalPoll.isPresent()) {
			return optionalPoll.get();
		}else {
			throw new UserNotFoundException("Pole is not found with ID:"+pollId);
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public ResponseForm deletePollByPollId(Long pollId) {
		pollRepository.deleteById(pollId);
		ResponseForm modelResponse=new ResponseForm("Poll Is deleted"); 
		return modelResponse;
	}

}
