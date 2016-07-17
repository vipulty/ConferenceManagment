package com.assignment.conference.behaviour;

import com.assignment.conference.time.Time;

public class StartTimeMinMaxBehaviour implements IStartTimeMinMaxBehaviour {

	private Time minStartTime;

	private Time maxStartTime;

	private Boolean isMinMaxValid;

	private IStartTimeBehaviour startTimeBehaviour;

	public StartTimeMinMaxBehaviour(IStartTimeBehaviour startTimeBehaviour, Time minStartTime, Time maxStartTime) {
		this.startTimeBehaviour = startTimeBehaviour;
		this.minStartTime = minStartTime;
		this.maxStartTime = maxStartTime;

		setMinMaxValid();
	}

	/**
	 * 
	 */
	public void setMinMaxValid() {

		if (startTimeBehaviour.isStartTimeFix() || minStartTime == null || maxStartTime == null) {
			this.isMinMaxValid = false;
		} else {
			this.isMinMaxValid = true;
		}
	}

	@Override
	public Boolean isStartTimeFix() {
		return startTimeBehaviour.isStartTimeFix();
	}

	@Override
	public Time getMinStartTime() {
		return minStartTime;
	}

	@Override
	public Time getMaxStartTime() {
		return maxStartTime;
	}

	@Override
	public Boolean getMinMaxValid() {
		return isMinMaxValid;
	}

	/**
	 * @param isMinMaxValid
	 *            the isMinMaxValid to set
	 */
	public void setIsMinMaxValid(Boolean isMinMaxValid) {
		this.isMinMaxValid = isMinMaxValid;
	}

	/**
	 * @return the startTimeBehaviour
	 */
	public IStartTimeBehaviour getStartTimeBehaviour() {
		return startTimeBehaviour;
	}

	/**
	 * @param startTimeBehaviour
	 *            the startTimeBehaviour to set
	 */
	public void setStartTimeBehaviour(IStartTimeBehaviour startTimeBehaviour) {
		this.startTimeBehaviour = startTimeBehaviour;
	}

	/**
	 * @param minStartTime
	 *            the minStartTime to set
	 */
	public void setMinStartTime(Time minStartTime) {
		this.minStartTime = minStartTime;
	}

	/**
	 * @param maxStartTime
	 *            the maxStartTime to set
	 */
	public void setMaxStartTime(Time maxStartTime) {
		this.maxStartTime = maxStartTime;
	}

}
