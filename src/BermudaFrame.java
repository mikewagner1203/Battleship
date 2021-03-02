import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class BermudaFrame extends JFrame {
    public static void main(String[] args) {
        new BermudaFrame();
    }

    private BermudaPanel panel;
    public JLabel lblMessage = new JLabel("Suche nach den " + Fleet.MAXSHIP + " Schiffen");
    JButton btnNewGame = new JButton("Neues Spiel");
    JButton btnCancel = new JButton("abbrechen");

    public BermudaFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        add(lblMessage, BorderLayout.NORTH);
        panel = new BermudaPanel(this);
        add(panel, BorderLayout.CENTER);
        add(btnNewGame, BorderLayout.SOUTH);
        btnNewGame.addActionListener(panel);
        setTitle("Bermuda");
        setVisible(true);
        pack();
    }
}
