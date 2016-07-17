/**
 * 
 */
package com.assignment.conference.behaviour;

/**
 * @author vipul
 *
 */
public class FlexibleStartTimeBehaviour implements IStartTimeBehaviour{

	/**
	 * 
	 */
	public FlexibleStartTimeBehaviour() {		
	}

	@Override
	public Boolean isStartTimeFix() {	
		return false;
	}

}
