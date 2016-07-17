package com.assignment.conference.factory;


import com.assignment.conference.behaviour.FixedStartTimebehaviour;
import com.assignment.conference.behaviour.FlexibleStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.time.Time;

public class StartTimeBehaviourFactory {

	public StartTimeBehaviourFactory() {

	}

	public static IStartTimeBehaviour getStartTimeBehaviour(String time) {

		if (time == null) {
			return new FlexibleStartTimeBehaviour();
		} else {
			final Time timeObj = TimeFactory.getTimeInstance(time);

			return new FixedStartTimebehaviour(timeObj);
		}

	}

}
