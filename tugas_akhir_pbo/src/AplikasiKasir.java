import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiKasir {
    private JPanel AplikasiKasirBude;
    private JTextField aplikasiPesananBudeTextField;
    private JTextField tfNamaMakanan;
    private JTextField tfNamaMinuman;
    private JList list1;
    private JList list2;
    private JButton pesanButton;

    public AplikasiKasir() {
        pesanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String namaMakanan = tfNamaMakanan.getText();
                String namaMinuman = tfNamaMinuman.getText();

                Color warnaLatarBelakang = JColorChooser.showDialog(AplikasiKasir.this.AplikasiKasirBude,
                        "Pilih Warna Latar Belakang", Color.WHITE);

                String pesan = "<html><font color=" + getColorHexString(warnaLatarBelakang) +
                        ">Pesanan Anda:</font><br>Makanan: " + namaMakanan + "<br>Minuman: " + namaMinuman + "</html>";

                JOptionPane.showMessageDialog(null, pesan, "Pesanan", JOptionPane.INFORMATION_MESSAGE);

                aplikasiPesananBudeTextField.setText("");
                aplikasiPesananBudeTextField.setBackground(warnaLatarBelakang);
                aplikasiPesananBudeTextField.setText(pesan);
            }
        });
    }
    private String getColorHexString(Color color) {
        return String.format("#%06X", (0xFFFFFF & color.getRGB()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aplikasi Kasir");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPane = new JPanel(new GridBagLayout());
            contentPane.setBackground(Color.LIGHT_GRAY);

            contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));

            AplikasiKasir aplikasiKasir = new AplikasiKasir();
            contentPane.add(aplikasiKasir.AplikasiKasirBude);

            frame.setContentPane(contentPane);
            frame.pack();

            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        });
    }
}
