package com.pool.form;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FeedbackViewModel {
	@NotNull
	private String name;
	@NotNull

	private String email;
	@NotNull
	@Min(10)
	private String feedback;

	public FeedbackViewModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "FeedbackViewModel [name=" + name + ", email=" + email + ", feedback=" + feedback + "]";
	}
}
