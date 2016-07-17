/**
 * 
 */
package com.assignment.conference.event;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.duration.IDurationBehaviour;
import com.assignment.conference.behaviour.ICommomBehaviour;
import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeMinMaxBehaviour;

/**
 * @author vipul
 *
 */
public class Event implements IEvent {

	private String title;

	private IDurationBehaviour durationBehaviour;

	private IStartTimeBehaviour startTimeBehaviour;

	private IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour;

	private ICommomBehaviour commomBehaviour;

	private Talk talk;

	/**
	 * 
	 */
	public Event() {

	}

	/**
	 * 
	 */
	public Event(IEvent event) {
		this.title = event.getTitle();
		this.talk = new Talk(event.getTalk());
		this.durationBehaviour = event.getDurationBehaviour();
		this.startTimeBehaviour = event.getStartTimeBehaviour();
		this.startTimeMinMaxBehaviour = event.getStartTimeMinMaxBehaviour();
		this.commomBehaviour = event.getCommomBehaviour();
	}

	/**
	 * @param durationBehaviour
	 *            the durationBehaviour to set
	 */
	public void setDurationBehaviour(IDurationBehaviour durationBehaviour) {
		this.durationBehaviour = durationBehaviour;
	}

	/**
	 * @param startTimeBehaviour
	 *            the startTimeBehaviour to set
	 */
	public void setStartTimeBehaviour(IStartTimeBehaviour startTimeBehaviour) {
		this.startTimeBehaviour = startTimeBehaviour;
	}

	/**
	 * @param startTimeMinMaxBehaviour
	 *            the startTimeMinMaxBehaviour to set
	 */
	public void setStartTimeMinMaxBehaviour(IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour) {
		this.startTimeMinMaxBehaviour = startTimeMinMaxBehaviour;
	}

	/**
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return talk.getTalkTitle();
	}

	/**
	 * 
	 */
	@Override
	public IStartTimeMinMaxBehaviour getStartTimeMinMaxBehaviour() {

		if (startTimeBehaviour.isStartTimeFix()) {
			return null;
		}

		return startTimeMinMaxBehaviour;
	}

	@Override
	public IDurationBehaviour getDurationBehaviour() {

		return durationBehaviour;
	}

	@Override
	public IStartTimeBehaviour getStartTimeBehaviour() {

		return startTimeBehaviour;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the talk
	 */
	public Talk getTalk() {
		return talk;
	}

	/**
	 * @param talk
	 *            the talk to set
	 */
	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	/**
	 * @return the commomBehaviour
	 */
	public ICommomBehaviour getCommomBehaviour() {
		return commomBehaviour;
	}

	/**
	 * @param commomBehaviour
	 *            the commomBehaviour to set
	 */
	public void setCommomBehaviour(ICommomBehaviour commomBehaviour) {
		this.commomBehaviour = commomBehaviour;
	}

	@Override
	public int compareTo(IEvent obj) {
		return this.talk.compareTo(obj.getTalk());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((talk == null) ? 0 : talk.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		if (talk == null) {
			if (other.talk != null) {
				return false;
			}
		} else if (!talk.equals(other.talk)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return talk.getStartTime() + Constants.SPACE + getTitle() + Constants.SPACE + talk;
	}

}
