package eventDetail.controller;

import app.model.Event;

public interface EventDetailControllerDelegate {
	void onEventUpdate(Event event);

	void onEventDelete(Event event);
}
