package com.assignment.conference.factory;

import com.assignment.conference.behaviour.CommomBehaviourFalse;
import com.assignment.conference.behaviour.CommomBehaviourTrue;
import com.assignment.conference.behaviour.ICommomBehaviour;
import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeMinMaxBehaviour;

public class CommomBehaviourFactory {

	public CommomBehaviourFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ICommomBehaviour getCommomBehaviour(IStartTimeBehaviour startTimeBehaviour,
			IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour) {

		if (startTimeBehaviour.isStartTimeFix() || startTimeMinMaxBehaviour.getMinMaxValid()) {
			return new CommomBehaviourTrue();
		} else {
			return new CommomBehaviourFalse();
		}

	}

}
