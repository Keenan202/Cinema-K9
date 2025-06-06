/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cinemaTicket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color; 
import java.awt.Font;  
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author Lenovo
 */
public class cinematTicket extends javax.swing.JFrame {
    
    private List<JToggleButton> daftarTombolKursi; // Untuk menyimpan semua tombol kursi
    private Map<String, Boolean> statusKursi; // Misal: {"A1": false, "A2": true} (false=available, true=occupied)
    private int jumlahKursiTerpilih = 0; // Untuk melacak berapa kursi yang sudah dipilih
    private static final int INDEX_KOLOM_KURSITERPILIH = 7;
    
    DefaultTableModel tablemodel;
    
    boolean isEditMode = false;
    int selectedRow = -1;
    int orderCounter = 0;
 
    private final double HARGA_REGULER = 35000.00; // Harga tiket reguler
    private final double HARGA_PREMIUM = 50000.00; // Harga tiket premium
    
    public cinematTicket() {
        daftarTombolKursi = new ArrayList<>(); 
        statusKursi = new HashMap<>();
        
        initComponents();
        isiDaftarFilmDariFile();
        tablemodel = (DefaultTableModel) tabel.getModel();
        
        inisialisasiPilihanKursi();
        setupSeatSelectionPanel(
            (String) ComboFilm.getSelectedItem(), 
            (String) ComboTime.getSelectedItem(), 
            (String) ComboSeats.getSelectedItem() 
        );
    }
    
    /**
     * Creates new form cinematTicket
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ComboSeats = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboFilm = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ComboTime = new javax.swing.JComboBox<>();
        btnOrder = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JToggleButton();
        lblTotalPembayaran = new javax.swing.JLabel();
        panelKursi = new javax.swing.JPanel();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 36)); // NOI18N
        jLabel1.setText("Cinema Ticket Booking");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(242, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel3.setText("Seats");

        ComboSeats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler (35.000)", "Premium (50.000)" }));
        ComboSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSeatsActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Movie", "Showing Time", "Studio", "Quantity", "Harga Per Tiket", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLabel2.setText("Quantity");

        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });

        jLabel4.setText("Movie");

        ComboFilm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", " ", " " }));
        ComboFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFilmActionPerformed(evt);
            }
        });

        jLabel5.setText("Showing Time");

        ComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTimeActionPerformed(evt);
            }
        });

        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblTotalPembayaran.setText("Total Pembayaran : Rp 0.00");

        panelKursi.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Quantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ComboTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboFilm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboSeats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addComponent(panelKursi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalPembayaran)
                .addGap(15, 15, 15))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelKursi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOrder)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void formWindowOpened(java.awt.event.WindowEvent evt) {
            tablemodel = (DefaultTableModel) tabel.getModel();
            ComboFilm.setModel(new DefaultComboBoxModel<>(new String[] {
            "Mission: Impossible – The Final Reckoning",
            "Lilo & Stitch",
            "Final Destination Bloodlines",
            "Jumbo"
        }));
        ComboSeats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Premium" }));
        updateTimeOptions((String) ComboFilm.getSelectedItem());
        }
        private void updateTimeOptions(String movie) {
            ComboTime.removeAllItems();
            if (movie == null) return;

            switch (movie) {
                case "Lilo & Stitch":
                    ComboTime.addItem("08:00");
                    ComboTime.addItem("10:00");
                    ComboTime.addItem("12:00");
                    break;
                case "Mission: Impossible – The Final Reckoning":
                    ComboTime.addItem("12:00");
                    ComboTime.addItem("15:00");
                    ComboTime.addItem("18:00");
                    break;
                case "Final Destination Bloodlines":
                    ComboTime.addItem("14:00");
                    ComboTime.addItem("18:00");
                    ComboTime.addItem("22:00");
                    break;
                case "Jumbo":
                    ComboTime.addItem("13.00");
                    ComboTime.addItem("15.00");
                    ComboTime.addItem("19.00");
            }
        }
        
    private void setupSeatSelectionPanel(String movie, String time, String seatType) {
    jumlahKursiTerpilih = 0; 
        
        for (JToggleButton button : daftarTombolKursi) {
            String seatId = button.getText();
            // Cek status kursi dari map global `statusKursi`
            // Ini harusnya mengambil status kursi yang relevan dengan film/waktu/jenis kursi yang dipilih
            // (Namun, tanpa penyimpanan data persisten, status ini akan selalu kosong kecuali setelah order)
            boolean isBooked = statusKursi.containsKey(seatId) && statusKursi.get(seatId); // Cek status dari map

            if (isBooked) {
                button.setBackground(Color.RED); // Warna merah jika sudah dibooking
                button.setEnabled(false);        // Nonaktifkan tombol
            } else {
                button.setBackground(Color.GREEN); // Warna hijau jika tersedia
                button.setEnabled(true);         // Aktifkan tombol
            }
            button.setSelected(false); // Pastikan tombol tidak dalam keadaan terpilih secara default
        }

        // Hanya perlu revalidate dan repaint panel Kursi untuk memperbarui tampilan
        panelKursi.revalidate();
        panelKursi.repaint();
    }

    private void isiDaftarFilmDariFile() {
        ComboFilm.removeAllItems();
        try (BufferedReader reader = new BufferedReader(new FileReader("films.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ComboFilm.addItem(line.trim());
            }
            if (ComboFilm.getItemCount() > 0) {
                String firstFilm = (String) ComboFilm.getItemAt(0);
                updateTimeOptions(firstFilm);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal membaca daftar film: " + e.getMessage());
        }
         ComboFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilm = (String) ComboFilm.getSelectedItem();
                updateTimeOptions(selectedFilm);
            }
        });
    }
    private void ComboSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSeatsActionPerformed

    }//GEN-LAST:event_ComboSeatsActionPerformed

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        String movie = (String) ComboFilm.getSelectedItem();
        String time = (String) ComboTime.getSelectedItem();
        String seatType = (String) ComboSeats.getSelectedItem();

        String studio;
        double hargaPerTiket;

        // --- 1. Validasi Jenis Kursi dan Penentuan Studio/Harga ---
        if (seatType == null || seatType.isEmpty()) { // Tambahkan isEmpty() untuk robust
            JOptionPane.showMessageDialog(this, "Pilih jenis kursi.");
            return;
        }

        if (seatType.equals("Premium (50.000)")) {
            studio = "Studio B (Premium)";
            hargaPerTiket = HARGA_PREMIUM;
        } else if (seatType.equals("Reguler (35.000)")) {
            studio = "Studio A (Reguler)";
            hargaPerTiket = HARGA_REGULER;
        } else {
            JOptionPane.showMessageDialog(this, "Jenis kursi tidak valid.");
            return;
        }

        // --- 2. Ambil dan Validasi Kuantitas Tiket dari Input Teks ---
        String qtyText = Quantity.getText().trim();
        int qty; // Deklarasikan 'qty' di sini, agar scope-nya di seluruh method

        if (movie == null || time == null || qtyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon lengkapi semua input (Film, Waktu, Kuantitas).");
            return;
        }

        try {
            qty = Integer.parseInt(qtyText);
            if (qty < 1 || qty > 60) {
                JOptionPane.showMessageDialog(this, "Jumlah tiket harus antara 1 sampai 60.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah tiket harus berupa angka.");
            return;
        }

        // --- 3. Validasi Jumlah Kursi Terpilih dengan Kuantitas Tiket ---
        // Pastikan 'qty' sudah punya nilai di sini sebelum digunakan.
        if (jumlahKursiTerpilih == 0) {
            JOptionPane.showMessageDialog(this, "Pilih setidaknya satu kursi pada peta kursi.");
            return;
        }

        if (jumlahKursiTerpilih != qty) {
            JOptionPane.showMessageDialog(this, "Jumlah kursi yang dipilih (" + jumlahKursiTerpilih + ") tidak sesuai dengan jumlah tiket yang diminta (" + qty + ").");
            return;
        }

        // --- 4. Proses Kursi Terpilih ---
        List<String> kursiTerpilih = new ArrayList<>();
        for (JToggleButton button : daftarTombolKursi) {
            // Hanya tambahkan kursi yang terpilih dan berwarna biru (aktif dipilih)
            if (button.isSelected() && button.getBackground().equals(Color.BLUE)) {
                kursiTerpilih.add(button.getText());
            }
        }
        String daftarKursi = String.join(", ", kursiTerpilih);

        // --- 5. Hitung Sub Total ---
        double subTotal = hargaPerTiket * qty;

        // --- 6. Tambahkan ke Tabel atau Edit Baris yang Ada ---
        if (isEditMode && selectedRow != -1) {
            // Logic untuk mode EDIT
            tablemodel.setValueAt(movie, selectedRow, 1);
            tablemodel.setValueAt(time, selectedRow, 2);
            tablemodel.setValueAt(studio, selectedRow, 3);
            tablemodel.setValueAt(qty, selectedRow, 4);
            tablemodel.setValueAt(String.format("Rp %,.2f", hargaPerTiket), selectedRow, 5);
            tablemodel.setValueAt(String.format("Rp %,.2f", subTotal), selectedRow, 6);
            tablemodel.setValueAt(daftarKursi, selectedRow, INDEX_KOLOM_KURSITERPILIH); // Gunakan konstanta

            // Reset mode edit
            btnEdit.setText("Edit");
            isEditMode = false;
            selectedRow = -1;
        } else {
            // Logic untuk mode ORDER (menambahkan baris baru)
            String orderId = String.format("%03d", orderCounter++);
            tablemodel.addRow(new Object[]{orderId, movie, time, studio, qty,
                String.format("Rp %,.2f", hargaPerTiket),
                String.format("Rp %,.2f", subTotal),
                daftarKursi});
        }

        // --- 7. Tandai Kursi sebagai Terisi dan Update Tampilan Kursi ---
        for (String kursi : kursiTerpilih) {
            for (JToggleButton button : daftarTombolKursi) {
                if (button.getText().equals(kursi)) {
                    statusKursi.put(kursi, true); // Set status kursi menjadi 'terisi'
                    button.setBackground(Color.RED); // Ubah warna menjadi merah
                    button.setEnabled(false);        // Nonaktifkan tombol
                    button.setSelected(false);       // Pastikan tidak terpilih (visual)
                }
            }
        }

        // --- 8. Update Total Pembayaran Keseluruhan dan Bersihkan Input ---
        jumlahKursiTerpilih = 0; // Reset hitungan kursi terpilih untuk pesanan berikutnya
        updateTotalPembayaran();
        clearInputs(); // Bersihkan input formulir
    }//GEN-LAST:event_btnOrderActionPerformed

    private void clearInputs() {
    ComboFilm.setSelectedIndex(0);
    updateTimeOptions((String) ComboFilm.getSelectedItem());
    ComboTime.setSelectedIndex(0);
    ComboSeats.setSelectedIndex(0);
    Quantity.setText("");

    // Optional: reset hanya kursi yang belum occupied
    for (JToggleButton button : daftarTombolKursi) {
        if (!statusKursi.get(button.getText())) {
            button.setBackground(Color.GREEN);
            button.setSelected(false);
        }
    }
    jumlahKursiTerpilih = 0;
}

    private void updateTotalPembayaran() {
    double totalKeseluruhan = 0.00;
    // Iterasi melalui setiap baris di tabel
    for (int i = 0; i < tablemodel.getRowCount(); i++) {
        // Ambil nilai dari kolom "Sub Total" (asumsi indeks 6)
        // Penting: Pastikan indeks kolom "Sub Total" (yaitu 6) sudah benar.
        // Jika Anda menambahkannya di posisi lain, sesuaikan indeksnya.
        Object subTotalObj = tablemodel.getValueAt(i, 6);
        if (subTotalObj != null) {
            try {
                // Hapus "Rp " dan koma, lalu ubah ke double
                String subTotalStr = subTotalObj.toString().replace("Rp ", "").replace(",", "");
                totalKeseluruhan += Double.parseDouble(subTotalStr);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing sub total at row " + i + ": " + e.getMessage());
                // Anda bisa menambahkan JOptionPane.showMessageDialog jika ingin memberitahu user
            }
        }
    }
    // Update teks di JLabel total pembayaran
    lblTotalPembayaran.setText(String.format("Total Pembayaran: Rp %,.2f", totalKeseluruhan));
}
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tabel.getSelectedRow();
        if (row != -1) {
            String kursiDipesanStr = (String) tablemodel.getValueAt(row, 7); // Asumsi indeks 7 untuk kolom Kursi Terpilih
            if (kursiDipesanStr != null && !kursiDipesanStr.isEmpty()) {
                String[] kursiArray = kursiDipesanStr.split(", ");
                for (String kursi : kursiArray) {
                    // Tandai kursi sebagai tersedia kembali
                    statusKursi.put(kursi, false);
                    for (JToggleButton button : daftarTombolKursi) {
                        if (button.getText().equals(kursi)) {
                            button.setBackground(Color.GREEN);
                            button.setEnabled(true); // Aktifkan kembali tombol
                            button.setSelected(false); // Pastikan tidak terpilih
                            break;
                        }
                    }
                }
            }
            tablemodel.removeRow(row);
            updateTotalPembayaran();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris untuk dihapus.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void ComboTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTimeActionPerformed
        // TODO add your handling code here:
        setupSeatSelectionPanel(
        (String) ComboFilm.getSelectedItem(),
        (String) ComboTime.getSelectedItem(),
        (String) ComboSeats.getSelectedItem()
    );
    }//GEN-LAST:event_ComboTimeActionPerformed

    private void ComboFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilmActionPerformed
        String selectedFilm = (String) ComboFilm.getSelectedItem();
        updateTimeOptions(selectedFilm);
        // Panggil setupSeatSelectionPanel saat film berubah
        setupSeatSelectionPanel(
                selectedFilm,
                (String) ComboTime.getSelectedItem(),
                (String) ComboSeats.getSelectedItem()
        );
    }//GEN-LAST:event_ComboFilmActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        selectedRow = tabel.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit dari tabel.");
        btnEdit.setSelected(false);
        return;
    }

    if (btnEdit.isSelected()) {
        // Mode: EDIT
        String movie = (String) tablemodel.getValueAt(selectedRow, 1);
        String time = (String) tablemodel.getValueAt(selectedRow, 2);
        String studio = (String) tablemodel.getValueAt(selectedRow, 3);
        String quantity = String.valueOf(tablemodel.getValueAt(selectedRow, 4));

        ComboFilm.setSelectedItem(movie);
        updateTimeOptions(movie);
        ComboTime.setSelectedItem(time);
        ComboSeats.setSelectedItem(studio.contains("Premium") ? "Premium" : "Reguler");
        Quantity.setText(quantity);

        btnEdit.setText("Update");
        isEditMode = true;
    } else {
        // Mode: UPDATE → Sudah ditangani oleh btnOrderActionPerformed
        btnEdit.setText("Edit");
        isEditMode = false;
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void inisialisasiPilihanKursi() {
        int jumlahBaris = 3;
        int jumlahKolom = 6;
    
        panelKursi.setLayout(new GridLayout(jumlahBaris, jumlahKolom, 5, 5)); // 5,5 adalah gap antar komponen

        char barisHuruf = 'A';
        for (int i = 0; i < jumlahBaris; i++) {
            for (int j = 1; j <= jumlahKolom; j++) {
                String namaKursi = String.valueOf(barisHuruf) + j;
                JToggleButton seatButton = new JToggleButton(namaKursi);
                seatButton.setBackground(Color.GREEN);
                seatButton.setForeground(Color.BLACK);
                seatButton.setPreferredSize(new Dimension(50, 50));
                seatButton.setFocusable(false);

                // Simpan status awal (semua tersedia)
                statusKursi.put(namaKursi, false); // false = available

                // Tambahkan ActionListener
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toggleKursi(seatButton, namaKursi);
                    }
                });

                daftarTombolKursi.add(seatButton);
                panelKursi.add(seatButton);
            }
            barisHuruf++;
        }
    }
    
    private void toggleKursi(JToggleButton seatButton, String namaKursi) {
        if (statusKursi.get(namaKursi)) { // Jika kursi ini sudah terisi (booked)
            JOptionPane.showMessageDialog(this, "Kursi " + namaKursi + " sudah terisi.");
            seatButton.setSelected(false); // Pastikan tidak terpilih
            return;
        }

        int quantityYangDiinginkan;
        try {
            quantityYangDiinginkan = Integer.parseInt(Quantity.getText());
            if (quantityYangDiinginkan == 0) {
                JOptionPane.showMessageDialog(this, "Masukkan jumlah tiket yang ingin dibeli terlebih dahulu.");
                seatButton.setSelected(false); // Pastikan tidak terpilih
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah tiket harus berupa angka.");
            seatButton.setSelected(false); // Pastikan tidak terpilih
            return;
        }

        if (seatButton.isSelected()) { // Jika tombol baru saja DIPILIH
            if (jumlahKursiTerpilih < quantityYangDiinginkan) {
                seatButton.setBackground(Color.BLUE); // Warna terpilih
                jumlahKursiTerpilih++;
            } else {
                JOptionPane.showMessageDialog(this, "Anda hanya bisa memilih " + quantityYangDiinginkan + " kursi.");
                seatButton.setSelected(false); // Batalkan pemilihan
            }
        } else { // Jika tombol baru saja DIHILANGKAN PEMILIHANNYA
            seatButton.setBackground(Color.GREEN); // Kembali ke tersedia
            jumlahKursiTerpilih--;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cinematTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cinematTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cinematTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cinematTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cinematTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilm;
    private javax.swing.JComboBox<String> ComboSeats;
    private javax.swing.JComboBox<String> ComboTime;
    private javax.swing.JTextField Quantity;
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalPembayaran;
    private javax.swing.JPanel panelKursi;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
