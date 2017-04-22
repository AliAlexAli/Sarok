package microsoft_imagine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Settings extends JFrame implements ActionListener {

    private JPanel main;
    private JLabel labelSize, labelShips;
    private JSpinner spinnerSize, spinnerShips;
    private JButton buttonOk;

    public Settings() {
        main = new JPanel();
        this.setContentPane(main);
        this.setTitle("Beállítások");
        this.setSize(200, 150);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        /*BEGIN CREATE TOOLS*/
        setSize();
        setShips();
        setOk();
        /*END CREATE TOOLS*/

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setSize() {
        this.labelSize = new JLabel("Pálya mérete: ");
        this.labelSize.setSize(100, 20);
        this.labelSize.setLocation(20, 20);
        this.main.add(this.labelSize);

        SpinnerNumberModel modelSize = new SpinnerNumberModel(8, 8, 12, 1);
        this.spinnerSize = new JSpinner(modelSize);
        this.spinnerSize.setSize(40, 20);
        this.spinnerSize.setLocation(150, 20);
        this.main.add(this.spinnerSize);
    }

    private void setShips() {
        this.labelShips = new JLabel("Hajók száma: ");
        this.labelShips.setSize(100, 20);
        this.labelShips.setLocation(20, 50);
        this.main.add(this.labelShips);

        SpinnerNumberModel modelShips = new SpinnerNumberModel(5, 4, 8, 1);
        this.spinnerShips = new JSpinner(modelShips);
        this.spinnerShips.setSize(40, 20);
        this.spinnerShips.setLocation(150, 50);
        this.main.add(this.spinnerShips);
    }

    private void setOk() {
        this.buttonOk = new JButton("Oké");
        this.buttonOk.setSize(60, 30);
        this.buttonOk.setLocation(70, 80);
        this.buttonOk.addActionListener(this);
        this.main.add(this.buttonOk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.buttonOk)) {
            this.setVisible(false);
            ShipSizes ships = new ShipSizes((int) this.spinnerSize.getValue(), (int) this.spinnerShips.getValue());
        }
    }
}
