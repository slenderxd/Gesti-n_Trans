/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_vista;

import javax.swing.JOptionPane;

public class Frm_Menu extends javax.swing.JFrame {

    public Frm_Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_RMaterial = new javax.swing.JButton();
        btn_RBibliotecario = new javax.swing.JButton();
        btn_RProfesor = new javax.swing.JButton();
        btn_RAlumno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_RPrestamos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmb_Consulta = new javax.swing.JComboBox<>();
        btn_Consulta = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIBLIOTECA - MENÚ");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("BIBLIOTECA ESCOLAR");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 4, true));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 300, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTROS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setOpaque(false);

        btn_RMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N
        btn_RMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RMaterialActionPerformed(evt);
            }
        });

        btn_RBibliotecario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bibliotecario.png"))); // NOI18N
        btn_RBibliotecario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RBibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RBibliotecarioActionPerformed(evt);
            }
        });

        btn_RProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/profesor.png"))); // NOI18N
        btn_RProfesor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RProfesorActionPerformed(evt);
            }
        });

        btn_RAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estudiante.png"))); // NOI18N
        btn_RAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Material");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bibliotecario");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Profesor");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Alumno");

        btn_RPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrow.png"))); // NOI18N
        btn_RPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RPrestamosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Prestamos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_RMaterial)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_RBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_RProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_RAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_RPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_RPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_RBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_RMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_RProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_RAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 680, 150));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setOpaque(false);

        cmb_Consulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Material", "Bibliotecario", "Profesor", "Alumno", "Prestamo" }));
        cmb_Consulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_Consulta.setText("CONSULTAR");
        btn_Consulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btn_Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Consulta)
                    .addComponent(btn_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 390, 80));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar1.JPG"))); // NOI18N
        jButton6.setText("SALIR");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondolibros.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de querer salir de la biblioteca?", "BIBLIOTECA SALIR", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null,"Gracias por utilizar nuestra aplicación \nElaborada por:\n\nHernández Carlos Mayte Eridani\nOrdaz Rangel David\nTorres Pérez Ashley","DESPEDIDA",1);
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_RMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RMaterialActionPerformed
       Frm_Material frmMaterial = new Frm_Material();
        frmMaterial.setVisible(true);
    }//GEN-LAST:event_btn_RMaterialActionPerformed

    private void btn_RBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RBibliotecarioActionPerformed
       Frm_Bibliotecario frmBibliotecario = new Frm_Bibliotecario();
       frmBibliotecario.setVisible(true);
    }//GEN-LAST:event_btn_RBibliotecarioActionPerformed

    private void btn_RProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RProfesorActionPerformed
       Frm_Profesor frmProfesor = new Frm_Profesor();
       frmProfesor.setVisible(true);
    }//GEN-LAST:event_btn_RProfesorActionPerformed

    private void btn_RAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RAlumnoActionPerformed
        Frm_Alumno frmAlumno = new Frm_Alumno();
        frmAlumno.setSize(980, 720);
        frmAlumno.setVisible(true);
    }//GEN-LAST:event_btn_RAlumnoActionPerformed

    private void btn_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultaActionPerformed
        Frm_ConsultaP frmProfesor = new Frm_ConsultaP();
        Frm_ConsultaM frmMaterial = new Frm_ConsultaM();
        Frm_ConsultaB frmBibliotecario = new Frm_ConsultaB();
        Frm_ConsultaA frmAlumno = new Frm_ConsultaA();
        Frm_ConsultaPr frmPrestamo = new Frm_ConsultaPr();
        switch(cmb_Consulta.getSelectedIndex()){
            case 0:
                
                frmMaterial.setVisible(true);
            break;
            
            case 1:
                
                frmBibliotecario.setVisible(true);
            break;
            
            case 2:
                
                frmProfesor.setVisible(true);
            break;
            
            case 3:
                frmAlumno.setVisible(true);
            break;
            
            case 4:
                frmPrestamo.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btn_ConsultaActionPerformed

    private void btn_RPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RPrestamosActionPerformed
        // TODO add your handling code here:
        Frm_Prestamo frmPrestamo = new Frm_Prestamo();
        frmPrestamo.setVisible(true);
    }//GEN-LAST:event_btn_RPrestamosActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Consulta;
    private javax.swing.JButton btn_RAlumno;
    private javax.swing.JButton btn_RBibliotecario;
    private javax.swing.JButton btn_RMaterial;
    private javax.swing.JButton btn_RPrestamos;
    private javax.swing.JButton btn_RProfesor;
    private javax.swing.JComboBox<String> cmb_Consulta;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
