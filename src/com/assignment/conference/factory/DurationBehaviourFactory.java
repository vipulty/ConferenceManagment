package com.assignment.conference.factory;

import com.assignment.conference.duration.Duration;
import com.assignment.conference.duration.FixedDurationBehaviour;
import com.assignment.conference.duration.FlexibleDurationBehaviour;
import com.assignment.conference.duration.IDurationBehaviour;


public class DurationBehaviourFactory {

	public DurationBehaviourFactory() {

	}

	public static IDurationBehaviour getDurationBehaviour(Duration duration) {

		if (duration != null) {
			return new FixedDurationBehaviour();
		}
		return new FlexibleDurationBehaviour();

	}

}
