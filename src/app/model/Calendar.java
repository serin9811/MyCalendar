package app.model;

import java.util.ArrayList;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import services.DataStore;

public class Calendar {
	ArrayList<Event> events = new ArrayList<Event>();

	public Calendar() {
		events = DataStore.events;
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public ArrayList<Event> insert(String whichButton, String thingsToDo) {
		Event event = new Event(whichButton, thingsToDo);
		events.add(event);
		return events;
	}

	public Event getEvent(String eventId) {
		for (Event event : events) {
			if (event.getId().equals(eventId)) {
				return event;
			}
		}
		return null;
	}

	public ArrayList<Event> updateEvent(Event updatedEvent) {
		for (Event event : events) {
			if (event.getId().equals(updatedEvent.getId())) {
				event.setThingsToDo(updatedEvent.getThingsToDo());
			}
		}
		return events;
	}

	public ArrayList<Event> deleteEvent(Event deleteEvent) {
		
		for(Event event: events) {
			if(event.getId().equals(deleteEvent.getId())) {
				int i= events.indexOf(event);
				events.remove(i);
				break;
			}
		}
		return events;
		
	}
}
