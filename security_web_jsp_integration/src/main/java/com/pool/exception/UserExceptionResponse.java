package com.pool.exception;

import java.util.Date;

public class UserExceptionResponse {
private String message;
private int status;
private Date timeStamp;
public UserExceptionResponse() {
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Date getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}
@Override
public String toString() {
	return "UserExceptionResponse [message=" + message + ", status=" + status + ", timeStamp=" + timeStamp + "]";
}

}
