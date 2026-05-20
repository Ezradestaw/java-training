package first_package;
import javax.swing.JFrame;
public class DrawPanelTest {
	public static void main(String[] args) {
		DrawPanel anel = new DrawPanel();
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(anel);
		application.setSize(250,250);
		application.setVisible(true);
	}
}
