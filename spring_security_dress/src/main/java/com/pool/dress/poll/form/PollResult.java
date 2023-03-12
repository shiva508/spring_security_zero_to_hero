package com.pool.dress.poll.form;

import java.util.Map;

public class PollResult {
	private String pole;
	private Map<String, Integer> castedVotes;
	private String winner;
	
	public PollResult() {
	}

	public String getPole() {
		return pole;
	}

	public void setPole(String pole) {
		this.pole = pole;
	}

	public Map<String, Integer> getCastedVotes() {
		return castedVotes;
	}

	public void setCastedVotes(Map<String, Integer> castedVotes) {
		this.castedVotes = castedVotes;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}
