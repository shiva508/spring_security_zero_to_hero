package com.pool.dress.poll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.security.dress.poll.domine.Vote;
import com.security.dress.poll.service.VoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vote")
@Api(description = "Voting API")
public class VoteController {

	@Autowired
	private VoteService voteService;

	@PostMapping("/castvote")
	@ApiOperation(notes = "Lets the user to vote for the option", value = "CAST VOTING")
	public ResponseEntity<?> castVote(@Valid @RequestBody Vote vote, BindingResult result) {
		Vote castedVote = voteService.castVote(vote);
		return new ResponseEntity<>(castedVote, HttpStatus.CREATED);
	}
	
	@GetMapping("/castedvotes")
	public ResponseEntity<?> castedVotes() {
		List<Vote> votes = voteService.castedVotes();
		return new ResponseEntity<>(votes, HttpStatus.OK);
	}
	
	@GetMapping("/getPollResult/{pollId}")
	public ResponseEntity<?> pollRessult(@PathVariable("pollId")Long pollId) {
		List<Vote> votes = voteService.pollRessult(pollId);
		return new ResponseEntity<>(votes, HttpStatus.OK);
	}
}
