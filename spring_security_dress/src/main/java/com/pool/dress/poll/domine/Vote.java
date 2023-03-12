package com.pool.dress.poll.domine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VOTE")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VOTE_ID")
	private Long voteId;
	@Column(name = "POLL_ID")
	private Long pollId;
	@ManyToOne
	@JoinColumn(name = "OPTION_ID")
	private Option option;

	public Vote() {

	}

	public Long getVoteId() {
		return voteId;
	}

	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	
	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", pollId=" + pollId + ", option=" + option + "]";
	}


}
