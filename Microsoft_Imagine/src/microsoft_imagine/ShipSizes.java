package microsoft_imagine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

class ShipSizes extends JFrame {

    private JPanel main;
    private JSpinner[] sizes;
    private JButton ok;
    
    ShipSizes(int n, int m) {
        main = new JPanel();
        this.setContentPane(main);
        this.setTitle("Beállítások");
        int ms = m * 60;
        this.setSize(200, ms);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        /*BEGIN CREATE TOOLS*/
        this.sizes = new JSpinner[m];
        setSizes(m);
        /*END CREATE TOOLS*/
        
        ok = new JButton("OK");
        ok.setSize(100,20);
        ok.setLocation(50, m*40+10);
                    int[] a = new int[m];
                    for (int i = 0; i < sizes.length; i++) {
            a[i] = (int) sizes[i].getValue();
        }
        ok.addActionListener(new ActionListener() {
            
                        
            @Override
            public void actionPerformed(ActionEvent e) {
                Felulet f = new Felulet(n, a);
                dispose();
            }
        });
        main.add(ok);
        this.setVisible(true);  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void setSizes(int n) {
        for (int i = 0; i < n; i++) {
             JLabel name = new JLabel((i + 1) + ". Hajó mérete:");
             name.setSize(100, 25);
             name.setLocation(20, i * 40);
             SpinnerNumberModel modelShips = new SpinnerNumberModel(1, 1, n, 1);
             this.sizes[i] = new JSpinner(modelShips);
             this.sizes[i].setSize(40, 30);
             this.sizes[i].setLocation(120, i * 40);
             this.main.add(name);
             this.main.add(this.sizes[i]);
        }
    }
    
}
