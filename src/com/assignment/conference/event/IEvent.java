/**
 * 
 */
package com.assignment.conference.event;

import com.assignment.conference.duration.IDurationBehaviour;
import com.assignment.conference.behaviour.ICommomBehaviour;
import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeMinMaxBehaviour;

/**
 * @author vipul
 *
 */
public interface IEvent extends Comparable<IEvent> {

  public String getTitle();
  
  public IDurationBehaviour getDurationBehaviour();
  
  public IStartTimeBehaviour getStartTimeBehaviour();
  
  public IStartTimeMinMaxBehaviour getStartTimeMinMaxBehaviour();
  
  public Talk getTalk();
  
  public ICommomBehaviour getCommomBehaviour();

}
