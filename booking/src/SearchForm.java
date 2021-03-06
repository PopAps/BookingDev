import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;


public class SearchForm extends JFrame {

	private JPanel contentPane;
	public  String room, date, timeStart, timeEnd, status,size;
	JDateChooser dateChooser = new JDateChooser();
	 ListSearch listSearch;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchForm frame = new SearchForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(21, 46, 642, 157);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Size = new JLabel("Size");
		Size.setBounds(47, 34, 46, 14);
		panel.add(Size);
		
		JComboBox comboBoxSize = new JComboBox();
		comboBoxSize.setModel(new DefaultComboBoxModel(new String[] {"", "50", "100", "150", "200"}));
		comboBoxSize.setBounds(103, 31, 55, 20);
		panel.add(comboBoxSize);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(47, 123, 46, 14);
		panel.add(lblTime);
		
		JComboBox comboBoxTimeStart = new JComboBox();
		comboBoxTimeStart.setModel(new DefaultComboBoxModel(new String[] { "", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
		comboBoxTimeStart.setBounds(103, 120, 74, 20);
		panel.add(comboBoxTimeStart);
		
		JComboBox comboBoxTimeEnd = new JComboBox();
		comboBoxTimeEnd.setModel(new DefaultComboBoxModel(new String[] { "", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
		comboBoxTimeEnd.setBounds(216, 120, 74, 20);
		panel.add(comboBoxTimeEnd);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(187, 123, 46, 14);
		panel.add(lblTo);

		JPanel panellist = new JPanel();
		panellist.setBackground(Color.WHITE);
		panellist.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panellist.setBounds(21, 214, 620, 200);
		JPanel gui = new JPanel(new BorderLayout(2, 2));
		gui.setBounds(0, 0, 620, 200);
		final JPanel panels = new JPanel(new GridLayout(0, 1));
		panels.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		final JScrollPane scroll = new JScrollPane(panels);
		scroll.setBounds(52, 277, 620, 200);
		scroll.setPreferredSize(new Dimension(620, 200));
		gui.add(scroll, BorderLayout.CENTER);

		
		panellist.setLayout(null);
		panellist.add(gui);
		contentPane.add(panellist);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("UI Process");
				RoomService roomService = new RoomService();
				
				ArrayList<Room> arr = roomService.getRoom(comboBoxSize.getSelectedItem().toString(),
						dateChooser.getDate(), comboBoxTimeStart.getSelectedItem().toString(),
						comboBoxTimeEnd.getSelectedItem().toString(), "", "");
				
				
			
//				 ArrayList<Room> arr = new ArrayList<>();
//		          for(int i =0 ;i< 10;i++) {
//		        	
//		        		arr.add(new Room("50",i+" Nov "+(2009+i)," "+(i+7)+":"+"00"," "+(i+8)+":"+"00","ROOM"+i,"false"));  
//		        	  
//		        	  
//		          }
				
		          System.out.println(arr.size());
		          if (arr.size() == 0) {
						panels.removeAll();
						listSearch = new ListSearch();
					    listSearch.date.setText("------------------------Not found Room------------------------");
						listSearch.room.setText("");
						listSearch.size.setText("");
						listSearch.timeStart.setText("");
						listSearch.timeEnd.setText("");
						listSearch.status.setText("");
						panels.add(listSearch.pannelsearch());
						panels.revalidate();
						int height = (int) panels.getPreferredSize().getHeight();
						scroll.getVerticalScrollBar().setValue(height);
					} else {
						panels.removeAll();
						for (int i = 0; i < arr.size(); i++) {

							room = (String) arr.get(i).room;
							status = (String) arr.get(i).status;
							size = (String) arr.get(i).size;
							date = (String) arr.get(i).date;
							timeStart = (String) arr.get(i).timeStart;
							timeEnd = (String) arr.get(i).timeEnd;
							    listSearch = new ListSearch();
								listSearch.size.setText(size);
								listSearch.date.setText(date);
								listSearch.room.setText(room);
								listSearch.status.setText(status);
								listSearch.timeStart.setText(timeStart);
								listSearch.timeEnd.setText(timeEnd);
								panels.add(listSearch.pannelsearch());
								panels.revalidate();
								int height = (int) panels.getPreferredSize().getHeight();
								scroll.getVerticalScrollBar().setValue(height);
								
							
						}
					}
		          
			}
		});
		btnSearch.setBounds(514, 119, 89, 23);
		panel.add(btnSearch);
		
		
		
		
		JButton btnBooking = new JButton("Booking");
		listSearch = new ListSearch();
	    listSearch.getBooking(btnBooking);
		
	    btnBooking.setBounds(514, 85, 89, 23);
		panel.add(btnBooking);
		
		
		
		
		dateChooser.setDateFormatString("MMM d, YYYY");
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(103, 72, 111, 20);
		panel.add(dateChooser);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(47, 78, 46, 14);
		panel.add(lblDate);
	}
}
