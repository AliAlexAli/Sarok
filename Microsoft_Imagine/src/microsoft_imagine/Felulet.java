package microsoft_imagine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Felulet extends JFrame implements ActionListener {

    private JPanel main;
    private int n;
    private ArrayList<JButton> sajat;
    private ArrayList<JButton> ellenfel;
    private EllenfelPalya p;

    public Felulet(int n, int[] hajok) {
        p = new EllenfelPalya(n, hajok);
        this.n = n;
        this.main = (JPanel) (this.getContentPane());

        this.setTitle("Torpedó");
        this.setSize(800, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.main.setLayout(null);

        this.sajat = new ArrayList();

        // Action Listener//
        // Panelhoz adás //
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.ellenfel = new ArrayList();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JButton b = new JButton("");
                b.setBackground(Color.white);
                b.setLocation(15 + i * (25 + 1), 50 + j * (25 + 1));
                b.setSize(25, 25);
                SwingUtilities.updateComponentTreeUI(this);

                this.sajat.add(b);

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JButton b = new JButton("");

                b.setBackground(Color.white);
                b.setLocation(400 + i * (25 + 1), 50 + j * (25 + 1));
                b.setSize(25, 25);
                SwingUtilities.updateComponentTreeUI(this);

                this.ellenfel.add(b);

            }
        }

        for (int i = 0; i < this.sajat.size(); i++) {
            this.main.add(this.sajat.get(i));

            this.sajat.get(i).addActionListener(this);
        }

        for (int i = 0; i < this.ellenfel.size(); i++) {
            this.main.add(this.ellenfel.get(i));

            this.ellenfel.get(i).addActionListener(this);
        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < sajat.size(); i++) {
            if (ae.getSource().equals(sajat.get(i))){
                sajat.get(i).setEnabled(false);
                sajat.get(i).setBackground(Color.darkGray);
            }
        }
        
        for (int i = 0; i < ellenfel.size(); i++) {
            if (ae.getSource().equals(ellenfel.get(i))) {
                if (p.getElem(i / n, i % n) == 0) {
                    ellenfel.get(i).setBackground(Color.black);
                    ellenfel.get(i).setEnabled(false);
                } else {
                    ellenfel.get(i).setBackground(Color.red);
                    ellenfel.get(i).setEnabled(false);

                }
                int a = (int) (Math.random()*sajat.size());
                while(sajat.get(a).getBackground().equals(Color.red) || sajat.get(a).getBackground().equals(Color.black)){
                    sajat.get(a).setBackground(Color.red);
                }
                if(sajat.get(a).getBackground().equals(Color.darkGray))
                sajat.get(a).setBackground(Color.red);
                if(sajat.get(a).getBackground().equals(Color.white))
                sajat.get(a).setBackground(Color.black);
            }
        }
    }
}
