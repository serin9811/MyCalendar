package eventDetail.view;

import app.model.Event;

public interface EventDetailFrameDelegate {
	void onSaveButtonClick(String EventTextField);

	void onDeleteButtonClick(Event event);

	void onCancelButtonClick();
}
