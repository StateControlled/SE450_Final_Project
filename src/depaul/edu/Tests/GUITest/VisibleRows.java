package depaul.edu.Tests.GUITest;

import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class VisibleRows extends JPanel {
    private DefaultListModel<Datum> dataModel = new DefaultListModel<>();
    private JList<Datum> datumList = new JList<>(dataModel);

    public VisibleRows() {
        DataPanel dataPanel = new DataPanel(8);
        for (int i = 0; i < 200; i++) {
            String name = "John Smith " + (i + 1);
            String second = generatingRandomAlpha(8);
            int value = ((i + 1) * 15299) - 12318;

            Datum datum = new Datum(name, second, value);
            dataPanel.addDatum(datum);
            dataModel.addElement(datum);
        }

        JScrollPane scrollPane1 = new JScrollPane(dataPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane1);

        datumList.setVisibleRowCount(5);
        datumList.setCellRenderer(new DatumRenderer());
        datumList.setPrototypeCellValue(new Datum("XXXXXXXXXXX", "XXXXXXXXXXX", 100));
        JScrollPane scrollPane2 = new JScrollPane(datumList);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane2);

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("VisibleRows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new VisibleRows());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String generatingRandomAlpha(int targetStringLength) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

        return generatedString;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
