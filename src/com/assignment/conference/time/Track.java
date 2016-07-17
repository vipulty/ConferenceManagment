package com.assignment.conference.time;

import java.util.LinkedList;
import java.util.List;

import com.assignment.conference.constants.Constants;

public class Track {

	private Integer trackNumber;

	private List<Session> sessions = new LinkedList<>();

	public Track(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	/**
	 * @return the trackNumber
	 */
	public Integer getTrackNumber() {
		return trackNumber;
	}

	/**
	 * @return the session
	 */
	public List<Session> getSessions() {
		return sessions;
	}

	/**
	 * @param trackNumber
	 *            the trackNumber to set
	 */
	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSessions(List<Session> sessiosn) {
		this.sessions = sessions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();

		output.append(Constants.TRACK + trackNumber + Constants.COLON).append(Constants.NEWLINE);

		for (Session session : sessions) {
			output.append(session).append(Constants.NEWLINE);
		}

		return output.toString();
	}

}
