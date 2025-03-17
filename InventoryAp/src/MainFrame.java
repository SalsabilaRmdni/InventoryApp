import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Inventory<Item> inventory;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextArea displayArea;

    public MainFrame() {
        inventory = new Inventory<>();
        setTitle("Aplikasi Inventaris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Nama Item:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Jumlah Item:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Tambah Item");
        addButton.addActionListener(new AddItemAction());
        inputPanel.add(addButton);

        JButton displayButton = new JButton("Tampilkan Item");
        displayButton.addActionListener(new DisplayItemsAction());
        inputPanel.add(displayButton);

        JButton searchButton = new JButton("Cari Item");
        searchButton.addActionListener(new SearchItemAction());
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.NORTH);

        // Area Teks untuk Menampilkan Item
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    private class AddItemAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int quantity;
            try {
                quantity = Integer.parseInt(quantityField.getText());
                inventory.addItem(new Item(name, quantity));
                nameField.setText("");
                quantityField.setText("");
                JOptionPane.showMessageDialog(MainFrame.this, "Item berhasil ditambahkan!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(MainFrame.this, "Jumlah harus berupa angka!");
            }
        }
    }

    private class DisplayItemsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("");
            for (Item item : inventory.getItems()) {
                displayArea.append(item.toString() + "\n");
            }
        }
    }

    private class SearchItemAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            Item foundItem = inventory.findItemByName(name);
            if (foundItem != null) {
                displayArea.setText("Item ditemukan: " + foundItem);
            } else {
                displayArea.setText("Item tidak ditemukan.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}