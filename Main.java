import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JComboBox<String> produkComboBox;
    private Map<String, Double> produkHarga;
    private Map<String, String> produkNama;

    public Main() {
        super("Mesin Kasir");

        inputField = new JTextField(10);
        JButton tambahButton = new JButton("Tambah");
        JButton bayarButton = new JButton("Bayar");

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        produkHarga = new HashMap<>();
        produkNama = new HashMap<>();
        inisialisasiProduk();

        String[] produkItems = getProdukItems();
        produkComboBox = new JComboBox<>(produkItems);

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahProduk();
            }
        });

        bayarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesPembayaran();
            }
        });

        setLayout(new FlowLayout());

        add(inputField);
        add(produkComboBox);
        add(tambahButton);
        add(bayarButton);
        add(new JScrollPane(outputArea));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Tengah layar
        setVisible(true);
    }

    private void inisialisasiProduk() {
        produkHarga.put("ayam goreng", 10000.0);
        produkNama.put("ayam goreng", "Ayam Goreng");
        produkHarga.put("ayam panggang", 20000.0);
        produkNama.put("ayam panggang", "Ayam Panggang");
        produkHarga.put("ayam sambel", 15000.0);
        produkNama.put("ayam sambel", "Ayam Sambel");
        produkHarga.put("es teh", 3000.0);
        produkNama.put("es teh", "Es Teh");
        produkHarga.put("kukubima susu", 6000.0);
        produkNama.put("kukubima susu", "Kukubima Susu");
        produkHarga.put("extra joss", 10000.0);
        produkNama.put("extra joss", "Extra Joss");
    }

    private String[] getProdukItems() {
        return produkHarga.keySet().toArray(new String[0]);
    }

    private void tambahProduk() {
        String selectedProdukID = (String) produkComboBox.getSelectedItem();
        if (produkHarga.containsKey(selectedProdukID)) {
            double harga = produkHarga.get(selectedProdukID);
            String namaProduk = produkNama.get(selectedProdukID);
            outputArea.append("Produk ditambahkan: " + namaProduk + " - Harga: Rp." + harga + "\n");
        } else {
            outputArea.append("Produk tidak ditemukan\n");
        }
        inputField.setText("");
    }

    private void prosesPembayaran() {
        double totalHarga = hitungTotalHarga();
        outputArea.append("Total Harga: Rp." + totalHarga + "\n");
        outputArea.append("Pembayaran diproses\n");
    }

    private double hitungTotalHarga() {
        double total = 0.0;
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
