package com.pool.dress.poll.domine;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "POLL")
public class Poll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POLL_ID")
	private Long pollId;

	@Column(name = "QUESTION", unique = true)
	private String question;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "POLL_ID")
	@OrderBy
	private Set<Option> options;

	public Poll() {

	}

	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Poll [pollId=" + pollId + ", question=" + question + ", options=" + options + "]";
	}

}
