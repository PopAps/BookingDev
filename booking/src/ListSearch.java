import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListSearch extends JPanel {
	JPanel pannel = new JPanel();
	JLabel room;
	JLabel size;
	JLabel date;
	JLabel timeStart;
	JLabel timeEnd;
	JLabel status;
	JCheckBox status2;

	public ListSearch() {
		pannel.setBackground(Color.WHITE);
		
		status2 = new JCheckBox("");
		status2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("45465165" + room.getText());
			}
		});
		boolean isSelected = status2.isSelected();

		
		status2.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		status2.setBounds(798, 11, 100, 40);
		pannel.add(status2);

		room = new JLabel("New label");
		room.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		room.setBounds(52, 11, 100, 40);
		pannel.add(room);

		JLabel a = new JLabel("                         ");
		pannel.add(a);

		size = new JLabel("New label");
		size.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		size.setBounds(202, 11, 100, 40);
		pannel.add(size);

		JLabel a1 = new JLabel("                         ");
		pannel.add(a1);

		date = new JLabel("New label");
		date.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		date.setBounds(351, 11, 100, 40);
		pannel.add(date);

		JLabel a2 = new JLabel("                         ");
		pannel.add(a2);

		timeStart = new JLabel("New label");
		timeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeStart.setBounds(500, 11, 100, 40);
		pannel.add(timeStart);

		JLabel a3 = new JLabel("                         ");
		pannel.add(a3);

		timeEnd = new JLabel("New label");
		timeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeEnd.setBounds(649, 11, 100, 40);
		pannel.add(timeEnd);

		JLabel a4 = new JLabel("                         ");
		pannel.add(a4);

		status = new JLabel("New label");
		status.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		status.setBounds(798, 11, 100, 40);
		pannel.add(status);
		


	}

	JPanel pannelsearch() {
		return pannel;

	}

	public void setlabelRoom(String txt) {
		this.room.setText(txt);
		System.out.println(room.getText() + " 230");
	}

	public void setlabelSize(String txt) {
		this.size.setText(txt);
	}

	public void setlabelDate(String txt) {
		this.date.setText(txt);
	}

	public void setlabelTimeStart(String txt) {
		this.timeStart.setText(txt);
	}

	public void setlabelTimeEnd(String txt) {
		this.timeEnd.setText(txt);
	}

	public void setlabelStatus(String txt) {
		this.status.setText(txt);
	}
	public void setJCheckBoxStatus(String txt) {
		this.status2.setText(txt);
	}

}