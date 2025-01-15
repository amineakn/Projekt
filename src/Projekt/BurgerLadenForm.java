import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class BurgerLadenForm extends JFrame {
    private JPanel mainPanel;
    JComboBox<String> bunComboBox;
    JCheckBox tomatenCheckBox;
    JCheckBox jalapenoCheckBox;
    JCheckBox cheddarCheckBox;
    JCheckBox salatCheckBox;
    JComboBox<String> sossenComboBox;
    JCheckBox veganCheckBox;
    private JButton calculatePriceButton;
    private JButton clearSelectionButton;
    JLabel preisLabel;
    private JLabel bunLabel;
    private JLabel toppingsLabel;
    private JLabel sossenLabel;
    private JLabel veganLabel;
    JTextArea textArea1;
    private JPanel frame;
    private JButton ausgebenButton;
    private JScrollPane scrollPane;

    int toppingsCount;  // Anzahl der Toppings
    private static final double TOPPING_PRICE = 0.50; // Preis pro Topping
    private static final double VEGAN_MULTIPLIER = 1.50; // 50% Aufpreis für vegan


    // ArrayList zur Speicherung der Benutzer-Auswahl
    private ArrayList<Burger> burgerSelections = new ArrayList<>();

    public BurgerLadenForm() {

        // Fenstereinstellungen
        setContentPane(mainPanel);
        setTitle("Burger Laden");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Farbe des Fensters geändert
        mainPanel.setBackground(new Color(255, 182, 193));

        // Verhindert, dass die Größe des Fensters geändert wird
        setResizable(false);

        // Aufruf der Methode initObjekte am mit Programmstart
        initObjekte();
        preisLabel.setText("Preis: 0.0 €");

        // ActionListener für Preisberechnung
        calculatePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String price = String.valueOf(calculateBasePrice()); // nimmt den Wert von calculate Preis und wandelt diesen als String um
                    preisLabel.setText("Preis: " + price + " € "); //.setText egal was davor steht es wird ersetzt durch was in der klammer steht
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener für Auswahl löschen
        clearSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelections();
            }
        });

        // ActionListener um die ausgewählten Elemente aufzulisten
        ausgebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndDisplaySelections();
            }
        });
    }
