package com.assignment.conference.behaviour;

import com.assignment.conference.time.Time;

public interface IStartTimeMinMaxBehaviour extends IStartTimeBehaviour  {
	
	public Time getMinStartTime();
	
	public Time getMaxStartTime();
	
	public Boolean getMinMaxValid();

}
