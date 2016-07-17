package com.assignment.conference.factory;

import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeMinMaxBehaviour;
import com.assignment.conference.behaviour.StartTimeMinMaxBehaviour;
import com.assignment.conference.time.Time;

public class StartTimeMinMaxBehaviourFactory {

	/**
	 * 
	 * @param startTimeBehaviour
	 * @return
	 */
	public static IStartTimeMinMaxBehaviour getStartTimeMinMaxBehaviour(IStartTimeBehaviour startTimeBehaviour,
			String minTime, String maxTime) {

		final Time minTimeObj = TimeFactory.getTimeInstance(minTime);

		final Time maxTimeObj = TimeFactory.getTimeInstance(maxTime);

		return new StartTimeMinMaxBehaviour(startTimeBehaviour, minTimeObj, maxTimeObj);
	}

}
