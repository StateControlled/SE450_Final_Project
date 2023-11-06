package depaul.edu.Tests.GUIExample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DatumPanel extends JPanel {
    private static final int GBC_I = 3;
    private Datum datum;
    private JLabel nameLabel = new JLabel();
    private JLabel secondLabel = new JLabel();
    private JLabel valueLabel = new JLabel();

    public DatumPanel() {
        setLayout(new GridBagLayout());
        add(new JLabel("Name:"), createGridBagConstraints(0, 0));
        add(nameLabel, createGridBagConstraints(1, 0));

        add(new JLabel("Desc:"), createGridBagConstraints(0, 1));
        add(secondLabel, createGridBagConstraints(1, 1));

        add(new JLabel("Value:"), createGridBagConstraints(0, 2));
        add(valueLabel, createGridBagConstraints(1, 2));
    }

    public DatumPanel(Datum datum) {
        this();
        setDatum(datum);
    }

    public final void setDatum(Datum datum) {
        this.datum = datum;
        nameLabel.setText(datum.getName());
        secondLabel.setText(datum.getSecond());
        valueLabel.setText("" + datum.getValue());
    }

    public Datum getDatum() {
        return datum;
    }

    private GridBagConstraints createGridBagConstraints(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(GBC_I, GBC_I, GBC_I, GBC_I);
        gbc.insets.left = x != 0 ? 3 * GBC_I : GBC_I;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        return gbc;
    }
}