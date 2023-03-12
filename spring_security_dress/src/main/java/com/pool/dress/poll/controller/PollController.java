package com.pool.dress.poll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dress.poll.domine.Poll;
import com.security.dress.poll.form.ResponseForm;
import com.security.dress.poll.service.PollService;
import com.security.utils.DressUtil;

@RestController
@RequestMapping("/poll")
public class PollController {
	@Autowired
	private PollService pollService;
	
	@Autowired
	private DressUtil dressUtil;
	
	@PostMapping("/save")
	public ResponseEntity<?> savePoll(@Valid @RequestBody Poll poll,BindingResult result) {
		Poll savedPoll=pollService.savePoll(poll);
		HttpHeaders headers=dressUtil.urlGenerator("/{pollId}", savedPoll);
		return new ResponseEntity<>(savedPoll, headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/polloptions")
	public ResponseEntity<?> allPolls() {
		List<Poll> polls=pollService.allPolls();
		return new ResponseEntity<>(polls, HttpStatus.OK);
	}
	
	@GetMapping("/get/{pollId}")
	public ResponseEntity<?> getPollByPollId(@PathVariable("pollId") Long pollId) {
		Poll poll=pollService.getPollByPollId(pollId);
		return new ResponseEntity<>(poll, HttpStatus.FOUND);
	}
	@DeleteMapping("/delete/{pollId}")
	public ResponseEntity<?> deletePollByPollId(Long pollId) {
		ResponseForm modelResponse=pollService.deletePollByPollId(pollId);
		return new ResponseEntity<>(modelResponse, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updatePoll(@Valid @RequestBody Poll poll,BindingResult result) {
		Poll updatedPoll=pollService.updatePoll(poll);
		return new ResponseEntity<>(updatedPoll, HttpStatus.OK);
	}

}
