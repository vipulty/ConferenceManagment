package com.assignment.conference.duration;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.enums.TimeMeasureEnum;

public class Duration {

	private Integer time;

	private TimeMeasureEnum timeMeasureEnum;

	public Duration(Integer time, TimeMeasureEnum timeMeasureEnum) {
		super();
		this.time = time;
		this.timeMeasureEnum = timeMeasureEnum;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public TimeMeasureEnum getTimeMeasureEnum() {
		return timeMeasureEnum;
	}

	public void setTimeMeasureEnum(TimeMeasureEnum timeMeasureEnum) {
		this.timeMeasureEnum = timeMeasureEnum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		if(time != Integer.MAX_VALUE){
			return time.toString() + timeMeasureEnum;
		} else {
			return Constants.EMPTY_STRING;
		}
		
	}
}
