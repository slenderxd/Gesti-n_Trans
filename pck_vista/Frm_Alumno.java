/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_vista;

import javax.swing.JOptionPane;
import pck_modelo.Alumno_BD;

public class Frm_Alumno extends javax.swing.JFrame {

    private final Alumno_BD ABD;

    public Frm_Alumno() {
        initComponents();
        this.setLocationRelativeTo(null);
        ABD = new Alumno_BD();
        this.listarAlumnos();
    }

    public void listarAlumnos() {
        DTM_Alumnos.setModel(ABD.getDatosAlumnos());
    }

    public void limpiar() {
        alumnoNombre.setText("");
        alumnoApellidoP.setText("");
        alumnoApellidoM.setText("");
        alumnoNoCuenta.setText("");
        alumnoNoCuenta.setEnabled(true);
        alumnoGrado.setSelectedIndex(-1);
        alumnoGrupo.setSelectedIndex(-1);
        alumnoTurnoButtonGroup.clearSelection();
        alumnoCorreo.setText("");
        alumnoMaestro.setText("");
        alumnoParametro.setText("");
        alumnoNombre.requestFocus();
    }

    public void agregarActualizarAlumno(boolean agregar) {
        String nombre = null, paterno = null, materno = null, grupo = null, turno = null, correo = null, idMaestro = null;
        int noCuenta = 0, grado = 0, resultado = 0;
        boolean valido = true;

        nombre = alumnoNombre.getText();
        if (nombre.isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El nombre del alumno es un dato requerido.",
                    "CAMPO VACIO!", 2);
            alumnoNombre.grabFocus();
        }
        paterno = alumnoApellidoP.getText();
        if (paterno.isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El apellido paterno del alumno es un dato requerido.",
                    "CAMPO VACIO!", 2);
            alumnoApellidoP.grabFocus();
        }
        materno = alumnoApellidoM.getText();
        if (materno.isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El apellido materno del alumno es un dato requerido.",
                    "CAMPO VACIO!", 2);
            alumnoApellidoM.grabFocus();
        }
        try {
            noCuenta = Integer.parseInt(alumnoNoCuenta.getText());
            if (noCuenta < 1) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta no puede ser menor a 1.",
                        "ERROR DE DATOS", 2);
                valido = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo de No. Cuenta es invalido. Ingrese un dato numérico", "ERROR DE DATOS", 2);
            valido = false;
            alumnoNoCuenta.setText("");
            alumnoNoCuenta.requestFocus();
        }
        if (alumnoGrado.getSelectedIndex() == -1) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El grado del alumno es un dato requerido.", "CAMPO VACIO!", 2);
        } else {
            grado = Integer.parseInt(alumnoGrado.getSelectedItem().toString());
        }
        if (alumnoGrupo.getSelectedIndex() == -1) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El grado del alumno es un dato requerido.", "CAMPO VACIO!", 2);
        } else {
            grupo = alumnoGrupo.getSelectedItem().toString();
        }
        if (!alumnoV.isSelected() && !alumnoM.isSelected()) {
            JOptionPane.showMessageDialog(null, "El turno del alumno es un dato requerido.", "CAMPO VACIO!", 2);
        } else {
            if (alumnoV.isSelected()) {
                turno = "Vespertino";
            } else {
                turno = "Matutino";
            }
        }
        correo = alumnoCorreo.getText();
        if (correo.isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El correo electronico del alumno es un dato requerido.",
                    "CAMPO VACIO!", 2);
            alumnoCorreo.grabFocus();
        }
        idMaestro = alumnoMaestro.getText();
        if (idMaestro.isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El ID del maestro del alumno es un dato requerido.",
                    "CAMPO VACIO!", 2);
            alumnoMaestro.grabFocus();
        }

        if (agregar && valido) {
            resultado = ABD.agregarRegistroAlumnos(noCuenta, nombre, paterno, materno, grado,
                    grupo, turno, correo, idMaestro);
        } else if (!agregar && valido) {
            resultado = ABD.actualizarRegistroAlumnos(noCuenta, nombre, paterno, materno, grado,
                    grupo, turno, correo, idMaestro);
        }
        if(resultado > 0){
            this.listarAlumnos();
            this.limpiar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alumnoTurnoButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alumnoNombre = new javax.swing.JTextField();
        alumnoApellidoP = new javax.swing.JTextField();
        alumnoApellidoM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alumnoNoCuenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alumnoGrado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        alumnoGrupo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        alumnoV = new javax.swing.JRadioButton();
        alumnoM = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        alumnoCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        alumnoMaestro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        alumnoParametro = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        alumnoCriterio = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DTM_Alumnos = new javax.swing.JTable();
        agregarButton = new javax.swing.JButton();
        actulizarButton = new javax.swing.JButton();
        listarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro - Alumno");
        setPreferredSize(new java.awt.Dimension(950, 650));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catálogo Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido Paterno:");

        jLabel3.setText("Apellido Materno: ");

        alumnoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnoNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("No. Cuenta:");

        jLabel5.setText("Grado:");

        alumnoGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        alumnoGrado.setSelectedIndex(-1);

        jLabel6.setText("Grupo:");

        alumnoGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));
        alumnoGrupo.setSelectedIndex(-1);
        alumnoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnoGrupoActionPerformed(evt);
            }
        });

        jLabel7.setText("Turno:");

        alumnoTurnoButtonGroup.add(alumnoV);
        alumnoV.setText("Vespertino");
        alumnoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnoVActionPerformed(evt);
            }
        });

        alumnoTurnoButtonGroup.add(alumnoM);
        alumnoM.setText("Matutino");

        jLabel8.setText("Correo Electronico:");

        jLabel9.setText("ID Maestro:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clean.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alumnoV, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumnoM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alumnoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(alumnoGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnoMaestro)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(alumnoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alumnoApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(alumnoApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(alumnoNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(alumnoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(alumnoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(alumnoMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(alumnoV)
                            .addComponent(alumnoM)
                            .addComponent(jLabel8)
                            .addComponent(alumnoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda de Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        buscarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.JPG"))); // NOI18N
        buscarButton.setText("BUSCAR");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        alumnoCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. Cuenta", "Nombre Completo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(alumnoCriterio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(alumnoParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumnoParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        DTM_Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DTM_Alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DTM_AlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DTM_Alumnos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.JPG"))); // NOI18N
        agregarButton.setText("GUARDAR");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        actulizarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.JPG"))); // NOI18N
        actulizarButton.setText("ACTUALIZAR");
        actulizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actulizarButtonActionPerformed(evt);
            }
        });

        listarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.JPG"))); // NOI18N
        listarButton.setText("LISTAR");
        listarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar1.JPG"))); // NOI18N
        eliminarButton.setText("ELIMINAR");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(actulizarButton)
                        .addGap(18, 18, 18)
                        .addComponent(listarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarButton)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actulizarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alumnoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnoNombreActionPerformed

    private void alumnoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnoGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnoGrupoActionPerformed

    private void alumnoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnoVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnoVActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
        DTM_Alumnos.setModel(ABD.buscarRegistroAlumnos(alumnoCriterio.getSelectedIndex(), alumnoParametro.getText()));
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void actulizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actulizarButtonActionPerformed
        this.agregarActualizarAlumno(false);
    }//GEN-LAST:event_actulizarButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        this.agregarActualizarAlumno(true);
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void DTM_AlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DTM_AlumnosMouseClicked
        // TODO add your handling code here:
        this.limpiar();
        int fila = DTM_Alumnos.getSelectedRow();

        alumnoNoCuenta.setText(DTM_Alumnos.getValueAt(fila, 0).toString());
        alumnoNoCuenta.setEnabled(false);
        alumnoNombre.setText(DTM_Alumnos.getValueAt(fila, 1).toString());
        alumnoApellidoP.setText(DTM_Alumnos.getValueAt(fila, 2).toString());
        alumnoApellidoM.setText(DTM_Alumnos.getValueAt(fila, 3).toString());
        alumnoGrado.setSelectedItem(DTM_Alumnos.getValueAt(fila, 4).toString());
        alumnoGrupo.setSelectedItem(DTM_Alumnos.getValueAt(fila, 5).toString());
        if (DTM_Alumnos.getValueAt(fila, 6).toString().equals("Vespertino")) {
            alumnoV.setSelected(true);
        } else {
            alumnoM.setSelected(true);
        }
        alumnoCorreo.setText(DTM_Alumnos.getValueAt(fila, 7).toString());
        alumnoMaestro.setText(DTM_Alumnos.getValueAt(fila, 8).toString());
    }//GEN-LAST:event_DTM_AlumnosMouseClicked

    private void listarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarButtonActionPerformed
        // TODO add your handling code here:
        this.listarAlumnos();
    }//GEN-LAST:event_listarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        int res = 0;
        int fila = DTM_Alumnos.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla.", "Eliminar un registro.", 2);
        }else{
            res = ABD.eliminarRegistroAlumnos(DTM_Alumnos.getValueAt(fila, 0).toString());
            if(res > 0){
                this.listarAlumnos();
                this.limpiar();
            }
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DTM_Alumnos;
    private javax.swing.JButton actulizarButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JTextField alumnoApellidoM;
    private javax.swing.JTextField alumnoApellidoP;
    private javax.swing.JTextField alumnoCorreo;
    private javax.swing.JComboBox<String> alumnoCriterio;
    private javax.swing.JComboBox<String> alumnoGrado;
    private javax.swing.JComboBox<String> alumnoGrupo;
    private javax.swing.JRadioButton alumnoM;
    private javax.swing.JTextField alumnoMaestro;
    private javax.swing.JTextField alumnoNoCuenta;
    private javax.swing.JTextField alumnoNombre;
    private javax.swing.JTextField alumnoParametro;
    private javax.swing.ButtonGroup alumnoTurnoButtonGroup;
    private javax.swing.JRadioButton alumnoV;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarButton;
    // End of variables declaration//GEN-END:variables
}
