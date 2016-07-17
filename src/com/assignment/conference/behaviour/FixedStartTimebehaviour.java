/**
 * 
 */
package com.assignment.conference.behaviour;

import com.assignment.conference.time.Time;

/**
 * @author vipul
 *
 */
public class FixedStartTimebehaviour implements IStartTimeBehaviour{
	
	private Time startTime;

	
	public FixedStartTimebehaviour(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@Override
	public Boolean isStartTimeFix() {	
		return true;
	}

}
