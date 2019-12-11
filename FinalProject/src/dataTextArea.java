import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollPane;

public class dataTextArea extends JPanel {

	/**
	 * Create the panel.
	 */
	public dataTextArea() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

	}

}
