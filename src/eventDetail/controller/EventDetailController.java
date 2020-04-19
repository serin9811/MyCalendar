package eventDetail.controller;

import app.model.Event;
import eventDetail.view.EventDetailFrame;
import eventDetail.view.EventDetailFrameDelegate;

public class EventDetailController implements EventDetailFrameDelegate {
	Event event ;
	EventDetailFrame eventDetailFrame;
	public EventDetailControllerDelegate delegate;

	public EventDetailController(Event event) {
		this.event = event;
		eventDetailFrame = new EventDetailFrame(event);
		eventDetailFrame.eventDetailFrameDelegate= this;
	}

	@Override
	public void onSaveButtonClick(String eventTextField) {
		event.setThingsToDo(eventTextField);
		if (delegate == null) throw new AssertionError("DOTO set delegate");
		delegate.onEventUpdate(this.event);
	}

	@Override
	public void onDeleteButtonClick(Event event) {
		eventDetailFrame.dispose();
		eventDetailFrame = null;
		delegate.onEventDelete(event);		
	}

	@Override
	public void onCancelButtonClick() {
		eventDetailFrame.dispose();
		
	}

}
