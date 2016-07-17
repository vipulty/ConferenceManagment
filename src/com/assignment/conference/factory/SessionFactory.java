/**
 * 
 */
package com.assignment.conference.factory;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.time.Session;

/**
 * @author vipul
 *
 */
public class SessionFactory {

	private static boolean moringSessionActive = true;

	private static Integer sessionNumber = 0;

	/**
	 * 
	 * @return
	 */
	public static Session getSessionInstance() {

		sessionNumber++;

		if (moringSessionActive) {
			moringSessionActive = false;

			return new Session(sessionNumber, TimeFactory.getTimeInstance(Constants.FIRST_SESSION_START_TIME),
					TimeFactory.getTimeInstance(Constants.FIRST_SESSION_END_TIME));

		} else {
			moringSessionActive = true;

			return new Session(sessionNumber, TimeFactory.getTimeInstance(Constants.SECOND_SESSION_START_TIME),
					TimeFactory.getTimeInstance(Constants.SECOND_SESSION_END_TIME));
		}

	}

}
