package services;

import java.util.ArrayList;

import app.model.Event;

public class DataStore {

	public static ArrayList<Event> events = new ArrayList<Event>() {{
		add(new Event("3", "Workout 7am"));
		add(new Event("6", "Meeting with supervisor"));
		add(new Event("6", "Lunch with bf"));
		
	}};
}
