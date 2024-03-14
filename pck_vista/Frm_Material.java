/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_vista;

import javax.swing.JOptionPane;
import pck_modelo.Material_BD;

public class Frm_Material extends javax.swing.JFrame {

    private final Material_BD MBD;

    public Frm_Material() {
        initComponents();
        this.setLocationRelativeTo(null);
        MBD = new Material_BD();
        this.listar();
    }

    private void listar() {
        jt_Registros.setModel(MBD.getDatos());
    }

    private void limpiar() {
        ct_CBarras.setText("");
        ct_CBarras.setEnabled(true);
        ct_Titulo.setText("");
        ct_AutorN.setText("");
        ct_AutorM.setText("");
        ct_AutorP.setText("");
        ct_AnioPublicacion.setText("");
        ct_Editorial.setText("");
        ct_Tomo.setText("");
        cmb_Clasificacion.setSelectedIndex(-1);
        ct_Edicion.setText("");
        cmb_Genero.setSelectedIndex(-1);
    }

    public void agregar_actualizar(boolean agregar) {
        int cod_material = 0, ejemplar = 0, anio_publi = 0, edicion = 0, res = 0;
        String clasificacion = null, titulo = null, autorN = null, autorA_M = null, autorA_P = null, editorial = null, genero = null;
        boolean valido = true;

        if (ct_CBarras.getText().isEmpty()) {
            valido = false;
            JOptionPane.showMessageDialog(null, "El codigo del material es un dato requerido.", "CAMPO VACIo!", 2);
            ct_CBarras.requestFocus();
        } else {
            try {
                cod_material = Integer.parseInt(ct_CBarras.getText());
                if (cod_material < 1) {
                    JOptionPane.showMessageDialog(null, "El codigo del material no puede ser menor que 1.",
                            "ERROR DE ENTRADA", 2);
                    ct_CBarras.setText("");
                    ct_CBarras.requestFocus();
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El codigo de del material debe ser numerico", "ERROR DE ENTRADA", 2);
                ct_CBarras.setText("");
                ct_CBarras.requestFocus();
                valido = false;
            }
        }

        titulo = ct_Titulo.getText();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El Titulo de la obra es un dato requerido.", "CAMPO VACIO!", 2);
            ct_Titulo.requestFocus();
            valido = false;
        }

        autorN = ct_AutorN.getText();
        if (autorN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del Autor es un dato requerido.", "CAMPO VACIO!", 2);
            ct_AutorN.requestFocus();
            valido = false;
        }

        autorA_P = ct_AutorP.getText();
        if (autorA_P.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido paterno del Autor es un dato requerido.", "CAMPO VACIO!", 2);
            ct_AutorP.requestFocus();
            valido = false;
        }

        //el apellido materno puede ser vacio
        autorA_M = ct_AutorM.getText();

        if (ct_AnioPublicacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El año de publicacion es un dato requerido.", "CAMPO VACIO!", 2);
            ct_AnioPublicacion.requestFocus();
            valido = false;
        } else {
            try {
                anio_publi = Integer.parseInt(ct_AnioPublicacion.getText());
                if (anio_publi < 1450) {
                    JOptionPane.showMessageDialog(null, "El Anio de Publicacion del material no debe ser menor a 1450", "ERROR DE ENTRADA", 2);
                    ct_AnioPublicacion.setText("");
                    ct_AnioPublicacion.requestFocus();
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El Anio de Publicacion del material debe ser numerico", "ERROR DE ENTRADA", 2);
                ct_AnioPublicacion.setText("");
                ct_AnioPublicacion.requestFocus();
                valido = false;
            }
        }
        
        editorial = ct_Editorial.getText();
        if(editorial.isEmpty()){
            JOptionPane.showMessageDialog(null, "El editorial del material es un dato requerido.", "CAMPO VACIO!", 2);
            valido = false;
            ct_Editorial.requestFocus();
        }
        
        if (ct_Tomo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El no. de tomo del material es un dato requerido.", "CAMPO VACIO!", 2);
            ct_Tomo.requestFocus();
            valido = false;
        } else {
            try {
                ejemplar = Integer.parseInt(ct_Tomo.getText());
                if (ejemplar < 1) {
                    JOptionPane.showMessageDialog(null, "El No. Tomo del material debe ser mayor a 0", "ERROR DE ENTRADA", 2);
                    ct_Tomo.setText("");
                    ct_Tomo.requestFocus();
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El No. Tomo del material debe ser numerico", "ERROR DE ENTRADA", 2);
                ct_Tomo.setText("");
                ct_Tomo.requestFocus();
                valido = false;
            }
        }

        if (cmb_Clasificacion.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "La clasificacion del material es un dato requerido", "CAMPO VACIO!", 2);
            cmb_Clasificacion.requestFocus();
            valido = false;
        } else {
            clasificacion = cmb_Clasificacion.getSelectedItem().toString();
        }

        if (ct_Edicion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El No. Edicion del Material es un dato requerido.", "CAMPO VACIO!", 2);
            ct_Edicion.requestFocus();
            valido = false;
        } else {
            try {
                edicion = Integer.parseInt(ct_Edicion.getText());
                if (edicion < 1) {
                    JOptionPane.showMessageDialog(null, "El No. Edicion del material debe ser mayor a 0", "ERROR DE ENTRADA", 2);
                    ct_Edicion.setText("");
                    ct_Edicion.requestFocus();
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El No. Edicion del material debe ser numerico", "ERROR DE ENTRADA", 2);
                ct_Edicion.setText("");
                ct_Edicion.requestFocus();
                valido = false;
            }
        }

        if (cmb_Genero.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "El genero del material es un dato requerido", "CAMPO VACIO!", 2);
            cmb_Genero.requestFocus();
            valido = false;
        } else {
            genero = cmb_Genero.getSelectedItem().toString();
        }

        if (agregar && valido) {
            res = MBD.agregarRegistro(cod_material, clasificacion, titulo, autorN, autorA_P, autorA_M, editorial, ejemplar, edicion, genero, anio_publi);
        } else if (!agregar && valido) {
            res = MBD.actualizarRegistro(cod_material, clasificacion, titulo, autorN, autorA_P, autorA_M, editorial, ejemplar, edicion, genero, anio_publi);
        }
        if (res > 0) {
            this.listar();
            this.limpiar();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ct_CBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ct_Titulo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ct_AutorN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ct_AutorM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ct_AutorP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ct_AnioPublicacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ct_Editorial = new javax.swing.JTextField();
        ct_Tomo = new javax.swing.JTextField();
        ct_Edicion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmb_Genero = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmb_Clasificacion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cmb_Criterio = new javax.swing.JComboBox<>();
        ct_Buscar = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Registros = new javax.swing.JTable();
        limpiarButton = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        listar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro - Material");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catálogo de Materiales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel1.setText("Código de Barras: ");

        ct_CBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_CBarrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Título:");

        ct_Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_TituloActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel3.setText("Nombre:");

        ct_AutorN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_AutorNActionPerformed(evt);
            }
        });

        jLabel4.setText("A. Materno:");

        jLabel5.setText("A. Paterno:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ct_AutorN)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ct_AutorP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ct_AutorM, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ct_AutorN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ct_AutorM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ct_AutorP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel6.setText("Año de Publicación:");

        jLabel7.setText("Editorial:");

        jLabel8.setText("Tomo:");

        jLabel9.setText("Edición:");

        jLabel10.setText("Genero");

        cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Filosofía", "Psicología", "Ciencias Sociales", "Lenguas", "Didáctica", "Ciencias Naturales", "Ciencias Matemáticas", "Tecnología", "Artes", "Literatura", "Historia", "Realismo mágico", "Divulgación científica", "Poesía lírica", "Historia", "Ficción histórica", "Ciencia ficción", "Desarrollo personal", "Tragedia", "Fantasía épica", "Biografía", "Ficción", "Psicología", "Thriller psicológico", "Fantasía", "Ficción especulativa", "Hiperficción explorativa", "Misterio", "Cómico", "Ficción de aventuras", "Sátira", "Epistolar", "Drama", "Informativo", "Dramático", "Drama Colonialismo", "Infantil", "Cuento", "Realismo fantástico" }));
        cmb_Genero.setSelectedIndex(-1);

        jLabel11.setText("Clasificación: ");

        cmb_Clasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficción", "Ciencia", "Poesía", "Historia", "Novela negra", "Ciencia ficción", "Autoayuda", "Teatro", "Fantasía", "Biografía", "Novela histórica", "Ensayo", "Psicología", "Literatura", "Novela", "Tira cómica", "Cuentos históricos", "Artes y oficios", "Narrativa", "Cuento" }));
        cmb_Clasificacion.setSelectedIndex(-1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda de Materiales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        cmb_Criterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo de Barras", "Titulo" }));

        ct_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_BuscarActionPerformed(evt);
            }
        });

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.JPG"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_Criterio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ct_Buscar)
                .addGap(18, 18, 18)
                .addComponent(btn_Buscar)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_Criterio)
                        .addComponent(ct_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Buscar))
                .addContainerGap())
        );

        jt_Registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_Registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_RegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_Registros);

        limpiarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clean.png"))); // NOI18N
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ct_AnioPublicacion)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmb_Clasificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(39, 39, 39)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(ct_Edicion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmb_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ct_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ct_Tomo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ct_CBarras)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(ct_Titulo))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiarButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ct_CBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ct_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ct_AnioPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(ct_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_Tomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmb_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cmb_Clasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(ct_Edicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.JPG"))); // NOI18N
        btn_Agregar.setText("GUARDAR");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.JPG"))); // NOI18N
        btn_Actualizar.setText("ACTUALIZAR");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar1.JPG"))); // NOI18N
        btn_Eliminar.setText("ELIMINAR");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.JPG"))); // NOI18N
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btn_Agregar)
                .addGap(33, 33, 33)
                .addComponent(btn_Actualizar)
                .addGap(32, 32, 32)
                .addComponent(btn_Eliminar)
                .addGap(32, 32, 32)
                .addComponent(listar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Agregar)
                        .addComponent(btn_Actualizar)
                        .addComponent(btn_Eliminar))
                    .addComponent(listar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ct_TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_TituloActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        this.listar();
    }//GEN-LAST:event_listarActionPerformed

    private void ct_AutorNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_AutorNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_AutorNActionPerformed

    private void ct_CBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_CBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_CBarrasActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        this.agregar_actualizar(true);
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        jt_Registros.setModel(MBD.buscarRegistro(cmb_Criterio.getSelectedIndex(), ct_Buscar.getText()));
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        this.agregar_actualizar(false);
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        int res;
        int fila = jt_Registros.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla", "ELIMINAR REGISTRO", 2);
        } else {
            res = MBD.eliminarRegistro(jt_Registros.getValueAt(fila, 0).toString());
            if (res > 0) {
                this.limpiar();
                this.listar();
            }
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void jt_RegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_RegistrosMouseClicked
        this.limpiar();
        int fila = jt_Registros.getSelectedRow();
        ct_CBarras.setText(jt_Registros.getValueAt(fila, 0).toString());
        ct_CBarras.setEnabled(false);
        cmb_Clasificacion.setSelectedItem(jt_Registros.getValueAt(fila, 1).toString());
        ct_Titulo.setText(jt_Registros.getValueAt(fila, 2).toString());
        ct_AutorN.setText(jt_Registros.getValueAt(fila, 3).toString());
        ct_AutorP.setText(jt_Registros.getValueAt(fila, 4).toString());
        if (jt_Registros.getValueAt(fila, 5) == null) {
            ct_AutorM.setText(null);
        } else {
            ct_AutorM.setText(jt_Registros.getValueAt(fila, 5).toString());
        }
        ct_Editorial.setText(jt_Registros.getValueAt(fila, 6).toString());
        ct_Tomo.setText(jt_Registros.getValueAt(fila, 7).toString());
        ct_Edicion.setText(jt_Registros.getValueAt(fila, 8).toString());
        cmb_Genero.setSelectedItem(jt_Registros.getValueAt(fila, 9).toString());
        ct_AnioPublicacion.setText(jt_Registros.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_jt_RegistrosMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.limpiar();
    }//GEN-LAST:event_formWindowOpened

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void ct_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Material().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox<String> cmb_Clasificacion;
    private javax.swing.JComboBox<String> cmb_Criterio;
    private javax.swing.JComboBox<String> cmb_Genero;
    private javax.swing.JTextField ct_AnioPublicacion;
    private javax.swing.JTextField ct_AutorM;
    private javax.swing.JTextField ct_AutorN;
    private javax.swing.JTextField ct_AutorP;
    private javax.swing.JTextField ct_Buscar;
    private javax.swing.JTextField ct_CBarras;
    private javax.swing.JTextField ct_Edicion;
    private javax.swing.JTextField ct_Editorial;
    private javax.swing.JTextField ct_Titulo;
    private javax.swing.JTextField ct_Tomo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable jt_Registros;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JButton listar;
    // End of variables declaration//GEN-END:variables
}
