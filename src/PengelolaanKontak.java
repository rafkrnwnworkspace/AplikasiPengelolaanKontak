import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class PengelolaanKontak extends javax.swing.JPanel {

    public PengelolaanKontak() {
        initComponents();
        loadKontakList();
        loadTableData(); // memuat table data apabila aplikasi di jalankan
        PengelolaanKontakHelper.createTable();
    }

     
    private void clearFields() { // Method Hapus
    nameInput.setText("");
    handphoneInput.setText("");
    alamatInput.setText("");
    genderPilih.setSelectedIndex(0);
    kategoriPilih.setSelectedIndex(0);
    loadTableData(); //Load ulang data setelah method ini dijalankan
    }
    
    private void loadTableData() {
    DefaultTableModel model = (DefaultTableModel) tblKontak.getModel();
    model.setRowCount(0);

    String sql = "SELECT nama, telepon, alamat, gender, kategori FROM kontak";
    try (Connection conn = PengelolaanKontakHelper.connect()) {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Menghentikan eksekusi jika koneksi gagal
        }

        try (java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nama"),
                    rs.getString("telepon"),
                    rs.getString("alamat"),
                    rs.getString("gender"),
                    rs.getString("kategori")
                });
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        handphoneInput = new javax.swing.JTextField();
        alamatInput = new javax.swing.JTextField();
        genderPilih = new javax.swing.JComboBox<>();
        kategoriPilih = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKontak = new javax.swing.JTable();
        cariInput = new javax.swing.JTextField();
        simpanButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        tambahButton = new javax.swing.JButton();
        eksporButton = new javax.swing.JButton();
        imporButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        kontakList = new javax.swing.JList<>();
        cariButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(228, 232, 237));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setText("Name Contact");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel2.setText("Phone Number");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel4.setText("Category");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel5.setText("Gender ");

        nameInput.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N

        handphoneInput.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N

        alamatInput.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        alamatInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatInputActionPerformed(evt);
            }
        });

        genderPilih.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        genderPilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        kategoriPilih.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        kategoriPilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keluarga", "Teman", "Kerja" }));

        tblKontak.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tblKontak.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "No.HP", "Alamat", "Gender", "Kategori"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKontak);

        cariInput.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        simpanButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        simpanButton.setText("Save");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        hapusButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        hapusButton.setText("Delete");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        tambahButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        tambahButton.setText("Add");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        eksporButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        eksporButton.setText("Export");
        eksporButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eksporButtonActionPerformed(evt);
            }
        });

        imporButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        imporButton.setText("Import");
        imporButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imporButtonActionPerformed(evt);
            }
        });

        kontakList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontakListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(kontakList);

        cariButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        cariButton.setText("Search");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel7.setText("Aplikasi Pengelolaan Kontak");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kategoriPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                    .addComponent(genderPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(alamatInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(handphoneInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameInput, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cariInput, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cariButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imporButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eksporButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(handphoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(genderPilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(kategoriPilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariButton)
                            .addComponent(cariInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imporButton)
                            .addComponent(eksporButton)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        String searchQuery = cariInput.getText().trim(); // Ambil input pencarian

        if (searchQuery.isEmpty()) { // Jika input pencarian kosong
            JOptionPane.showMessageDialog(this, "Masukkan nama atau nomor telepon untuk mencari!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Memulai pencarian berdasarkan nama atau nomor telepon
        DefaultTableModel model = (DefaultTableModel) tblKontak.getModel();
        model.setRowCount(0); // Reset tabel sebelum memasukkan hasil pencarian

        String sql = "SELECT nama, telepon, alamat, gender, kategori FROM kontak WHERE nama LIKE ? OR telepon LIKE ?";
        try (Connection conn = PengelolaanKontakHelper.connect();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%"); // Pencarian berdasarkan nama
            pstmt.setString(2, "%" + searchQuery + "%"); // Pencarian berdasarkan nomor telepon
            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nama"),
                    rs.getString("telepon"),
                    rs.getString("kategori")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari kontak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cariButtonActionPerformed

    private void kontakListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontakListMouseClicked
        String selectedName = kontakList.getSelectedValue();  // Mendapatkan nama yang dipilih dari kontakList
        if (selectedName != null) {  // Pastikan ada nama yang dipilih
            try (Connection conn = PengelolaanKontakHelper.connect()) {
                // Query untuk mengambil data berdasarkan nama
                String query = "SELECT * FROM kontak WHERE nama = ?";
                var ps = conn.prepareStatement(query);
                ps.setString(1, selectedName);  // Set nama yang dipilih sebagai parameter
                var rs = ps.executeQuery();

                var model = (DefaultTableModel) tblKontak.getModel();
                model.setRowCount(0);  // Reset tabel sebelum mengisi dengan data baru

                if (rs.next()) {
                    // Menambahkan data yang diambil dari database ke dalam tabel
                    Object[] row = {
                        rs.getString("nama"),
                        rs.getString("telepon"),
                        rs.getString("alamat"),
                        rs.getString("gender"),
                        rs.getString("kategori")
                    };
                    model.addRow(row);
                } else {
                    JOptionPane.showMessageDialog(this, "Kontak tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal memuat data kontak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_kontakListMouseClicked

    private void imporButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imporButtonActionPerformed
        // Membuka JFileChooser untuk memilih file CSV
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File CSV untuk Diimpor");
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToImport = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileToImport))) {
                String line;
                // Lewati baris header
                reader.readLine();

                // Menyiapkan koneksi ke database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo_db", "root", "password"); // Sesuaikan kredensial
                String sql = "INSERT INTO kontak (nama, noHp, alamat, gender, kategori) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Membaca baris-baris dari file CSV dan menyimpannya ke dalam database
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    pstmt.setString(1, data[0]); // nama
                    pstmt.setString(2, data[1]); // noHp
                    pstmt.setString(5, data[4]); // kategori
                    pstmt.executeUpdate(); // Eksekusi query untuk memasukkan data ke database
                }

                JOptionPane.showMessageDialog(this, "Data berhasil diimpor!");
                conn.close();
            } catch (SQLException | IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_imporButtonActionPerformed

    private void eksporButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eksporButtonActionPerformed
        // Membuka JFileChooser untuk memilih lokasi dan nama file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan sebagai CSV");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Jika ekstensi file tidak ditentukan, tambahkan .csv secara otomatis
            if (!fileToSave.getName().endsWith(".csv")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
            }

            // Menyimpan data dari JTable ke dalam file CSV
            try (FileWriter writer = new FileWriter(fileToSave)) {
                // Mendapatkan model dari JTable
                JTable table = tblKontak; // Ganti dengan nama tabel Anda
                int rowCount = table.getRowCount();
                int columnCount = table.getColumnCount();

                // Menulis header kolom
                for (int col = 0; col < columnCount; col++) {
                    writer.append(table.getColumnName(col));
                    if (col < columnCount - 1) writer.append(",");
                }
                writer.append("\n");

                // Menulis data dari JTable
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        Object cellValue = table.getValueAt(row, col);
                        writer.append(cellValue != null ? cellValue.toString() : "");
                        if (col < columnCount - 1) writer.append(",");
                    }
                    writer.append("\n");
                }

                // Berhasil mengekspor
                JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_eksporButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        nameInput.setText("");
        handphoneInput.setText("");
        alamatInput.setText("");
        genderPilih.setSelectedIndex(0); // Default memilih item pertama
        kategoriPilih.setSelectedIndex(0); // Default memilih item pertama
        nameInput.requestFocus(); // Fokus pada input nama
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        int selectedRow = tblKontak.getSelectedRow(); // Mendapatkan baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kontak yang ingin dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Jika tidak ada baris yang dipilih, keluar dari metode
        }

        // Mendapatkan nama kontak yang akan dihapus
        String nama = tblKontak.getValueAt(selectedRow, 0).toString();

        // Konfirmasi sebelum menghapus
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus kontak " + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Jika pengguna tidak mengkonfirmasi, keluar dari metode
        }

        // SQL untuk menghapus kontak dari database
        String sql = "DELETE FROM kontak WHERE nama = ?";
        try (Connection conn = PengelolaanKontakHelper.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama); // Mengatur parameter nama
            pstmt.executeUpdate(); // Eksekusi perintah hapus

            // Beri notifikasi ke pengguna
            JOptionPane.showMessageDialog(this, "Kontak berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadTableData(); // Memuat ulang data setelah penghapusan
            loadKontakList(); // Memuat ulang daftar kontak
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus kontak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = tblKontak.getSelectedRow(); // Mendapatkan baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kontak yang ingin diedit!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Jika tidak ada baris yang dipilih, keluar dari metode
        }

        // Mengambil data dari tabel berdasarkan baris yang dipilih
        String nama = tblKontak.getValueAt(selectedRow, 0).toString();
        String telepon = tblKontak.getValueAt(selectedRow, 1).toString();
        String alamat = tblKontak.getValueAt(selectedRow, 2).toString();
        String gender = tblKontak.getValueAt(selectedRow, 3).toString();
        String kategori = tblKontak.getValueAt(selectedRow, 4).toString();

        // Memasukkan data ke dalam input field
        nameInput.setText(nama);
        handphoneInput.setText(telepon);
        alamatInput.setText(alamat);
        genderPilih.setSelectedItem(gender);
        kategoriPilih.setSelectedItem(kategori);

        // Menyimpan perubahan ke database saat tombol Simpan ditekan
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Memperbarui data di database
                String newNama = nameInput.getText();
                String newTelepon = handphoneInput.getText();
                String newAlamat = alamatInput.getText();
                String newGender = genderPilih.getSelectedItem().toString();
                String newKategori = kategoriPilih.getSelectedItem().toString();

                // Validasi input
                if (newNama.isEmpty() || newTelepon.isEmpty() || newAlamat.isEmpty() || newGender.equals("") || newKategori.equals("")) {
                    JOptionPane.showMessageDialog(PengelolaanKontak.this, "Harap isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // SQL untuk memperbarui data
                String sql = "UPDATE kontak SET nama = ?, telepon = ?, alamat = ?, gender = ?, kategori = ? WHERE nama = ?";
                try (Connection conn = PengelolaanKontakHelper.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, newNama);
                    pstmt.setString(2, newTelepon);
                    pstmt.setString(3, newAlamat);
                    pstmt.setString(4, newGender);
                    pstmt.setString(5, newKategori);
                    pstmt.setString(6, nama); // Menggunakan nama lama sebagai kunci pencarian
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(PengelolaanKontak.this, "Kontak berhasil diperbarui.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    clearFields(); // Mengosongkan field setelah update
                    loadTableData(); // Memuat ulang data tabel
                    loadKontakList(); // Memuat ulang daftar kontak
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(PengelolaanKontak.this, "Gagal memperbarui kontak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_editButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // Ambil data dari field input
        String nama = nameInput.getText();
        String telepon = handphoneInput.getText();
        String alamat = alamatInput.getText();
        String gender = genderPilih.getSelectedItem().toString();
        String kategori = kategoriPilih.getSelectedItem().toString();

        // Periksa apakah field input sudah diisi semua
        if (nama.isEmpty() || telepon.isEmpty() || alamat.isEmpty() || gender.equals("") || kategori.equals("")) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Simpan data ke database
        String sql = "INSERT INTO kontak (nama, telepon, alamat, gender, kategori) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = PengelolaanKontakHelper.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, telepon);
            pstmt.setString(3, alamat);
            pstmt.setString(4, gender);
            pstmt.setString(5, kategori);
            pstmt.executeUpdate();

            // Beri notifikasi ke pengguna
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Mengosongkan field input setelah berhasil disimpan
        nameInput.setText("");
        handphoneInput.setText("");
        alamatInput.setText("");
        genderPilih.setSelectedIndex(0);
        kategoriPilih.setSelectedIndex(0);
        nameInput.requestFocus();
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void alamatInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatInputActionPerformed

    }//GEN-LAST:event_alamatInputActionPerformed
         private void loadKontakList() {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String sql = "SELECT nama FROM kontak";  // Query untuk mengambil nama-nama kontak
    try (Connection conn = PengelolaanKontakHelper.connect();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            listModel.addElement(rs.getString("nama"));  // Menambahkan nama ke dalam model list
        }

        // Menghubungkan DefaultListModel ke kontakList
        kontakList.setModel(listModel);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data nama kontak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void main(String args[]) {
        // Mengatur tampilan antarmuka pengguna
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pengelolaan Kontak");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new PengelolaanKontak());
            frame.setSize(800, 600); // Atur ukuran frame sesuai kebutuhan
            frame.setLocationRelativeTo(null); // Pusatkan frame di layar
            frame.setVisible(true); // Tampilkan frame
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatInput;
    private javax.swing.JButton cariButton;
    private javax.swing.JTextField cariInput;
    private javax.swing.JButton editButton;
    private javax.swing.JButton eksporButton;
    private javax.swing.JComboBox<String> genderPilih;
    private javax.swing.JTextField handphoneInput;
    private javax.swing.JButton hapusButton;
    private javax.swing.JButton imporButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> kategoriPilih;
    private javax.swing.JList<String> kontakList;
    private javax.swing.JTextField nameInput;
    private javax.swing.JButton simpanButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTable tblKontak;
    // End of variables declaration//GEN-END:variables
}
