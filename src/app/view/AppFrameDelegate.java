package app.view;

public interface AppFrameDelegate {
	void onDayClick(String day);
	void onInsertEvent(String day, String eventDescription);
	void onEventClick(String eventId);
}
