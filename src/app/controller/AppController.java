package app.controller;

import java.util.ArrayList;
import app.model.Calendar;
import app.model.Event;
import app.view.AppFrame;
import app.view.AppFrameDelegate;
import eventDetail.controller.EventDetailController;
import eventDetail.controller.EventDetailControllerDelegate;

public class AppController implements AppFrameDelegate, EventDetailControllerDelegate{
	AppFrame appFrame;
	
	Calendar calendar=new Calendar();

	public AppController() {
		appFrame = new AppFrame();
		appFrame.delegate = this;
		appFrame.updateTable(calendar.getEvents());
	}

	@Override
	public void onButtonClick(String whichButton, String thingsToDo) {
	ArrayList<Event> events = calendar.insert(whichButton, thingsToDo);
	appFrame.updateTable(events);
	}

	@Override
	public void onEventClick(String eventId) {
		Event event= calendar.getEvent(eventId);
		EventDetailController eventDetailController = new EventDetailController(event);
		eventDetailController.delegate = this;
	}

	@Override
	public void onEventUpdate(Event event) {
		ArrayList<Event> updatedEvents= calendar.updateEvent(event);
		appFrame.updateTable(updatedEvents);
	}

	@Override
	public void onEventDelete(Event event) {
		ArrayList<Event> deleteupdatedEvents=calendar.deleteEvent(event);
		appFrame.updateTable(deleteupdatedEvents);
		
	}
}


