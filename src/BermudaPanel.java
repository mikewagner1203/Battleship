import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BermudaPanel extends JPanel implements MouseListener, ActionListener {
    Playfield game = new Playfield();
    Image empty;
    Image ship;
    Image[] number;
    int distance = 32;
    int clickCounter = 0;
    BermudaFrame frame;


    public BermudaPanel(BermudaFrame frame) {
        this.frame = frame;
        addMouseListener(this);
        empty = new ImageIcon(getClass().getResource("image/leer.png")).getImage();
        ship = new ImageIcon(getClass().getResource("image/schiff.png")).getImage();
        number = new Image[9];
        for(int i = 0; i < 9; i++) {
            number[i] = new ImageIcon(getClass().getResource("image/mark"+i+".png")).getImage();
        }
        distance = new ImageIcon(getClass().getResource("image/schiff.png")).getIconWidth();
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < Playfield.MaxX; i++) {
            for(int j = 0; j < Playfield.MaxY; j++) {
                Position pos = new Position(i, j);
                char c = game.get(pos);
                Image img= null;
                if(c >= '0' && c <= '8') {
                    img = number[c - '0'];
                } else if (c == Fleet.SHIP) {
                    img = ship;
                } else {
                    img = empty;
                }
                g.drawImage(img, i * distance, j * distance, this);
            }
        }
    }

    // Panel space requirement
    @Override
    public Dimension getPreferredSize() {
        return new Dimension((Playfield.MaxX)*distance, (Playfield.MaxY)*distance);
    }

    //-----Mouselistener Methods------
    @Override
    public void mouseClicked(MouseEvent me) {
        Position pos = new Position(me.getX()/distance, me.getY()/distance);
        clickCounter++;
        if(game.isInPlayfield(pos)) {
            char result = game.search(pos);
            game.set(pos, result);
            if(game.allShipsFound()) {
                frame.lblMessage.setText("Spiel mit " + clickCounter + " Klicks beendet");
            }
        }
        repaint();
    }

    public void mouseReleased(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}

    //-----ActionListener Methods (Button)-----
    @Override
    public void actionPerformed(ActionEvent e) {
        game = new Playfield();
        frame.lblMessage.setText("Suche nach den 4 Schiffen");
        repaint();
    }
}
