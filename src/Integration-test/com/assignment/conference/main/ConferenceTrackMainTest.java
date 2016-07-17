package com.assignment.conference.main;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignment.conference.time.Track;

import junit.framework.Assert;

public class ConferenceTrackMainTest {

	private BufferedReader bufferedReader1;

	private BufferedReader bufferedReader2;
	
	private BufferedReader bufferedReader3;

	@Before
	public void setUp() {
		try {
			InputStream stream = ConferenceTrackMainTest.class.getResourceAsStream("input1");
			InputStreamReader inputStreamReader = new InputStreamReader(stream, "UTF-8");
			bufferedReader1 = new BufferedReader(inputStreamReader);

			stream = ConferenceTrackMainTest.class.getResourceAsStream("input2");
			inputStreamReader = new InputStreamReader(stream, "UTF-8");
			bufferedReader2 = new BufferedReader(inputStreamReader);
			
			stream = ConferenceTrackMainTest.class.getResourceAsStream("input3");
			inputStreamReader = new InputStreamReader(stream, "UTF-8");
			bufferedReader3 = new BufferedReader(inputStreamReader);

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSample1() {
		try {

			List<Track> tracks = ConferenceTrackMain.scheduleConferenceEvents(bufferedReader1);

			String output1 = "[Track1:\n09:00AM Ruby on Rails: Why We Should Move On 90min\n10:30AM Rails for Python Developers again 5min\n10:35AM Pair Programming vs Noise 75min\n11:50AM Rails for Python Developers 5min\n12:00PM Lunch 60min\n\n01:00PM Accounting-Driven Development 55min\n01:55PM Woah 10min\n02:05PM Lua for the Masses 50min\n02:55PM Communicating Over Distance 15min\n03:10PM Programming in the Boondocks of Seattle 45min\n03:55PM Sit Down and Write 20min\n04:15PM Overdoing it in Python 40min\n04:55PM Networking Event \n\n, Track2:\n09:00AM Writing Fast Tests Against Enterprise Rails 35min\n09:35AM Rails Magic 20min\n09:55AM Clojure Ate Scala (on my project) 35min\n10:30AM Common Ruby Errors 25min\n10:55AM Ruby Errors from Mismatched Gem Versions 30min\n12:00PM Lunch 60min\n\n04:00PM Networking Event \n\n]";
			Assert.assertEquals(tracks.toString(), output1);
		} catch (IOException ex) {

		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSample2() {
		try {

			List<Track> tracks = ConferenceTrackMain.scheduleConferenceEvents(bufferedReader2);

			String output1 = "[Track1:\n09:00AM Rails Magic 60min\n10:00AM Rails for Python Developers 5min\n10:05AM Writing Fast Tests Against Enterprise Rails 60min\n11:05AM A World Without HackerNews 30min\n12:00PM Lunch 60min\n\n01:00PM Communicating Over Distance 60min\n02:00PM Ruby vs. Clojure for Back-End Development 30min\n02:30PM Ruby on Rails: Why We Should Move On 60min\n03:30PM Programming in the Boondocks of Seattle 30min\n04:00PM Ruby on Rails Legacy App Maintenance 60min\n05:00PM Networking Event \n\n, Track2:\n09:00AM Overdoing it in Python 45min\n09:45AM User Interface CSS in Rails Apps 30min\n10:15AM Pair Programming vs Noise 45min\n11:00AM Sit Down and Write 30min\n11:30AM Lua for the Masses 30min\n12:00PM Lunch 60min\n\n01:00PM Clojure Ate Scala (on my project) 45min\n01:45PM Woah 30min\n02:15PM Ruby Errors from Mismatched Gem Versions 45min\n03:00PM Common Ruby Errors 45min\n03:45PM Accounting-Driven Development 45min\n04:30PM Networking Event \n\n]\n";
			Assert.assertEquals(tracks.toString(), output1);		

		} catch (IOException ex) {
			
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSample3() {
		try {

			List<Track> tracks = ConferenceTrackMain.scheduleConferenceEvents(bufferedReader3);

			String output1 = "";
			Assert.assertEquals(tracks.toString(), output1);
			 System.out.println(tracks);

		} catch (IOException ex) {
			
		}
	}

}
