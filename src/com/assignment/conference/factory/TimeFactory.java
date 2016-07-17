/**
 * 
 */
package com.assignment.conference.factory;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.enums.TimeMeasureEnum;
import com.assignment.conference.time.Time;

/**
 * @author vipul
 *
 */
public class TimeFactory {

	/**
	 * 
	 */
	public TimeFactory() {
	}

	public static Time getTimeInstance(String time) {

		if (time == null || time.equals(Constants.EMPTY_STRING)) {
			return null;
		}

		final int indexOfColumn = time.indexOf(Constants.COLON);

		final Integer hour = Integer.valueOf(time.substring(0, indexOfColumn));

		final String remaining = time.substring(indexOfColumn + 1);

		final Integer minute = Integer.valueOf(remaining.substring(0, 2));

		return new Time(hour, minute, TimeMeasureEnum.getTimeMeasureEnum(remaining.substring(2, 4)));
	}

}
