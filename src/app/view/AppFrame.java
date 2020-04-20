package app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import app.model.Event;

public class AppFrame extends JFrame {

	public AppFrameDelegate delegate;

	JPanel leftPanel = new JPanel();
	JPanel labelPanel = new JPanel();
	JPanel gridPanel = new JPanel();
	JButton[] btns = new JButton[38];
	JPanel[] panelsForBtns = new JPanel[49];
	JPanel rightPanel = new JPanel();

	String[] columnsidentifier = { "ID", "Date", "Event" };
	DefaultTableModel dtm = new DefaultTableModel(2, 10);

	JTable table = new JTable(dtm);

	public AppFrame() {
		setTitle("Simply Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("/Users/SerinaHEO/Downloads/paint.jpg")));
		Container c = getContentPane();
		c.setLayout(null);

		leftPanel.setLayout(null);
		leftPanel.setOpaque(false);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBounds(10, 10, 600, 480);

		gridPanel.setLayout(null);
		gridPanel.setOpaque(false);
		gridPanel.setLayout(new GridLayout(7, 7));
		gridPanel.setBounds(10, 90, 600, 400);

		
		for (int i = 0; i < panelsForBtns.length; i++) {
			panelsForBtns[i] = new JPanel();
		}

		for (int i = 0; i < btns.length; i++) {

			btns[0] = new JButton("SUN");
			btns[1] = new JButton("MON");
			btns[2] = new JButton("TUE");
			btns[3] = new JButton("WED");
			btns[4] = new JButton("THU");
			btns[5] = new JButton("FRI");
			btns[6] = new JButton("SAT");
			if (i >= 0 && i < 7) {
				panelsForBtns[i].add(btns[i]);
			}

			else if (i >= 7) {
				createDayButton(i);
			}
		}
		for (int i = 0; i < panelsForBtns.length; i++) {
			panelsForBtns[i].setOpaque(false);
			gridPanel.add(panelsForBtns[i]);
		}

		setupCalendarHeader();
		leftPanel.add(BorderLayout.NORTH, labelPanel);
		leftPanel.add(BorderLayout.CENTER, gridPanel);

		rightPanel.setBounds(610, 10, 380, 480);
		dtm.setColumnIdentifiers(columnsidentifier);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1 && !e.getValueIsAdjusting()) {
					int rowOfTable = table.getSelectedRow();
					String eventId = (String) table.getModel().getValueAt(rowOfTable, 0);
					if (delegate == null)
						throw new AssertionError("DOTO set delegate");
					
					delegate.onEventClick(eventId);
					table.getSelectionModel().clearSelection();
				}

			}
		});
		rightPanel.add(new JScrollPane(table));

		c.setLayout(new FlowLayout());
		c.add(leftPanel);
		c.add(rightPanel);
		setSize(1100, 500);
		setVisible(true);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}

	private void createDayButton(int i) {
		btns[i] = new JButton("" + (i - 6));
		btns[i].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					JButton b = (JButton) e.getSource();
					if (delegate == null ) throw new AssertionError("DOTO set delegate");
					delegate.onDayClick(b.getText());
			}
		});
		panelsForBtns[i + 5].add(btns[i]);
	}

	private void setupCalendarHeader() {
		JLabel titleLabel = new JLabel("MAY 2020");
		titleLabel.setFont(new Font("Segoe", Font.PLAIN, 30));
		labelPanel.setOpaque(false);
		labelPanel.add(titleLabel);
		labelPanel.setBounds(10, 10, 600, 80);
	}

	public void updateTable(ArrayList<Event> events) {

		while (dtm.getRowCount() > 0) {
			dtm.removeRow(0);
		}
		for (Event event : events) {
			try {
				
				dtm.addRow(event.toVector());
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public void showAlertView(String day) {
		String eventDescription = JOptionPane.showInputDialog(null, "May " + day + ", Things to do:");
		if (delegate == null ) throw new AssertionError("DOTO set delegate");
		delegate.onInsertEvent(day, eventDescription);
	}
}
