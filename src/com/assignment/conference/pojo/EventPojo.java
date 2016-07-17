/**
 * 
 */
package com.assignment.conference.pojo;

import com.assignment.conference.event.IEvent;

/**
 * @author vipul
 *
 */
public class EventPojo {

	private IEvent event;

	private Integer sessionRemainingTime;

	public EventPojo(IEvent event, Integer sessionRemainingTime) {
		super();
		this.event = event;
		this.sessionRemainingTime = sessionRemainingTime;
	}

	/**
	 * @return the event
	 */
	public IEvent getEvent() {
		return event;
	}

	/**
	 * @return the sessionRemainingTime
	 */
	public Integer getSessionRemainingTime() {
		return sessionRemainingTime;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(IEvent event) {
		this.event = event;
	}

	/**
	 * @param sessionRemainingTime
	 *            the sessionRemainingTime to set
	 */
	public void setSessionRemainingTime(Integer sessionRemainingTime) {
		this.sessionRemainingTime = sessionRemainingTime;
	}

}
