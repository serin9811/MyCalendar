package eventDetail.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import app.model.Event;

public class EventDetailFrame extends JFrame {

	public EventDetailFrameDelegate eventDetailFrameDelegate;

	public EventDetailFrame(Event event) {
		Container container = getContentPane();
		container.setLayout(null);
		setTitle("May " + event.getDayInNum() + " Schedule");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel textFieldPane = new JPanel();
		JPanel labelPane= new JPanel();
		JPanel btnsPane = new JPanel();

		labelPane.setBounds(0,20,700,50);
		JLabel label = new JLabel("Things to do in May " + event.getDayInNum() + ":");
		labelPane.add(label);
		
		textFieldPane.setBounds(0, 50, 700, 100);
		JTextField eventTextField = new JTextField(event.getThingsToDo(), 40);
		textFieldPane.add(eventTextField);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (eventDetailFrameDelegate != null) {
					eventDetailFrameDelegate.onSaveButtonClick(eventTextField.getText());
					;
				} else {
					throw new AssertionError("DOTO set delegate");
				}

			}
		});
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (eventDetailFrameDelegate == null)
					throw new AssertionError("DOTO set delegate");
				eventDetailFrameDelegate.onDeleteButtonClick(event);
			}
		});

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (eventDetailFrameDelegate == null)
					throw new AssertionError("DOTO set delegate");
				eventDetailFrameDelegate.onCancelButtonClick();
			}
		});

		btnsPane.setBounds(0, 100, 700, 50);
		btnsPane.add(saveBtn);
		btnsPane.add(deleteBtn);
		btnsPane.add(cancelBtn);

		container.add(labelPane);
		container.add(textFieldPane);
		container.add(btnsPane);
		setLocation(50, 50);
		setSize(700, 200);
		setVisible(true);
	}
}
