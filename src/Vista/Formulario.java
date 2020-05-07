/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelos.Categorias;
import Modelos.Libro;
import Modelos.Usuario;
import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author aldo__nr420yj
 */
public class Formulario extends javax.swing.JFrame {

    
   private final Controlador ctrl;
   private DefaultTableModel model;
   private DefaultComboBoxModel cbModel;
   private String reportPath;
   /* Creates new form Formulario
     * @param a
     */
    public Formulario(Controlador a) {
        this.ctrl = a;
        initComponents();
        ValoresIniciales();
        
        
        
    }
    
    private void ValoresIniciales(){
        this.jTable1.setDefaultRenderer(Object.class, new ButtonTableModel());
        String[] cabeceras = {"ISBN", "Titulo", "Categoria","Dueño", ""};
        this.model = new DefaultTableModel(null, cabeceras);
        this.jTable1.setModel(model);
        
        this.cbModel = new DefaultComboBoxModel(new String[]{"aldo", "hernandez"});
        this.jComboBox1.setModel(cbModel);
        this.jComboBox2.setModel(cbModel);       
        Eventos();
        ActualizarTabla();
        InfoLogeado();
        ComboCategorias();
    }
    
    private void InfoLogeado(){
        Usuario temp = ctrl.ObtenerLogeado();
        jLabelUserInfo.setText("Informacion de Usuario: "+temp.getCarnet()); 
        jTextNameEdit.setText(temp.getNombre());
        jTextLastNameEdit.setText(temp.getApellido());
        jTextCareerEdit.setText(temp.getCarrera());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelUserInfo = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextNameEdit = new javax.swing.JTextField();
        jTextLastNameEdit = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextCareerEdit = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabelUserInfo1 = new javax.swing.JLabel();
        jTextAddCat = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextHost = new javax.swing.JTextField();
        jTextPuerto = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabelEstado = new javax.swing.JLabel();
        jLabelNet = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextISBN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextEdicion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextIdioma = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextEditorial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextAno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jTextISBN1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextTitulo1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextAutor1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextEdicion1 = new javax.swing.JTextField();
        jTextAno1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextCategoria1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextIdioma1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextEditorial1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextDueno = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextCarnet = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextBuscador = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Report = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setText("Terminar Sesion");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelUserInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelUserInfo.setText("Informacion de Usuario:");

        jLabel21.setText("Nombre:");

        jLabel23.setText("Apellido:");

        jLabel24.setText("Carrera:");

        jButton6.setText("Actualizar Datos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar Usuario");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabelUserInfo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelUserInfo1.setText("Categorias:");

        jLabel22.setText("Nombre:");

        jButton8.setText("Crear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Eliminar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Configuracion de Red:");

        jLabel32.setText("IP (localhost por defecto):");

        jLabel33.setText("Puerto:");

        jButton10.setText("Guardar Configuracion");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabelEstado.setText("No has configurado tus parametros de red:");

        jLabelNet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNet.setText("¡No estas conectado en la Red!");

        jLabel34.setText("Puerto:");

        jLabel35.setText("IP:");

        jButton17.setText("Conectar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("jButton18");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Update");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUserInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21)
                                        .addComponent(jTextNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23)
                                        .addComponent(jTextLastNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24)
                                        .addComponent(jTextCareerEdit)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextAddCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton17))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel34)
                                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(26, 26, 26)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel35)
                                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel32)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel33))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jTextHost, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabelEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelNet, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(2, 2, 2)))
                                .addGap(22, 22, 22)))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextLastNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCareerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelUserInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextAddCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton19))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton18))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Perfil", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, -1, 449));

        jTextISBN.setNextFocusableComponent(jTextTitulo);
        jPanel1.add(jTextISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 258, -1));

        jLabel1.setText("ISBN:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jTextTitulo.setNextFocusableComponent(jTextAutor);
        jPanel1.add(jTextTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 258, -1));

        jLabel2.setText("Titulo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, -1, -1));

        jTextAutor.setNextFocusableComponent(jTextEdicion);
        jPanel1.add(jTextAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 258, -1));

        jLabel3.setText("Autor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, -1, -1));

        jTextEdicion.setNextFocusableComponent(jTextAno);
        jPanel1.add(jTextEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, 112, -1));

        jLabel4.setText("Edicion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, -1, -1));

        jTextCategoria.setNextFocusableComponent(jTextIdioma);
        jPanel1.add(jTextCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, 258, -1));

        jLabel5.setText("Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, -1, -1));

        jTextIdioma.setNextFocusableComponent(jTextEditorial);
        jPanel1.add(jTextIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 258, -1));

        jLabel6.setText("Idioma:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, -1, -1));

        jButton1.setText("Cargar Libro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 151, -1));

        jButton2.setText("Cargar Archivo (JSON)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 415, 223, -1));
        jPanel1.add(jTextEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 326, 258, -1));

        jLabel7.setText("Editorial:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 306, -1, -1));

        jTextAno.setNextFocusableComponent(jTextCategoria);
        jPanel1.add(jTextAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 173, 112, -1));

        jLabel8.setText("Año:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 153, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 11, 378, -1));

        jLabel9.setText("ISBN:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 68, -1, -1));

        jTextISBN1.setEditable(false);
        jTextISBN1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextISBN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 88, 110, -1));

        jLabel10.setText("Titulo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 119, -1, -1));

        jTextTitulo1.setEditable(false);
        jTextTitulo1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 139, 258, -1));

        jLabel11.setText("Autor:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 170, -1, -1));

        jTextAutor1.setEditable(false);
        jTextAutor1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextAutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 190, 258, -1));

        jLabel12.setText("Edicion");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 221, -1, -1));

        jTextEdicion1.setEditable(false);
        jTextEdicion1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextEdicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 241, 112, -1));

        jTextAno1.setEditable(false);
        jTextAno1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextAno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 241, 112, -1));

        jLabel13.setText("Año:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 221, -1, -1));

        jTextCategoria1.setEditable(false);
        jTextCategoria1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 88, 107, -1));

        jLabel14.setText("Categoria:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 68, -1, -1));

        jTextIdioma1.setEditable(false);
        jTextIdioma1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextIdioma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 287, 258, -1));

        jLabel15.setText("Idioma:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 267, -1, -1));

        jTextEditorial1.setEditable(false);
        jTextEditorial1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextEditorial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 338, 258, -1));

        jLabel16.setText("Editorial:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 318, -1, -1));

        jLabel17.setText("ISBN - TITULO - CATEGORIA");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

        jTextDueno.setEditable(false);
        jTextDueno.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextDueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 384, 174, -1));

        jLabel18.setText("Nombre:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 364, -1, -1));

        jButton3.setText("Eliminar Libro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 415, 151, -1));

        jTextCarnet.setEditable(false);
        jTextCarnet.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 384, 78, -1));

        jLabel19.setText("Carnet:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 364, -1, -1));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 85, -1));

        jTextBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 165, -1));

        jLabel20.setText("INFORMACION DEL LIBRO:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 48, -1, -1));

        jTabbedPane1.addTab("Biblioteca", jPanel1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton11.setText("Generar Reporte");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(Report);

        jLabel25.setText("Libros");

        jLabel26.setText("Categorias");

        jButton12.setText("Generar Reporte");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Generar Reporte");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel27.setText("Categorias (PREORDEN)");

        jButton14.setText("Generar Reporte");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel28.setText("Categorias (INORDEN)");

        jButton15.setText("Generar Reporte");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel29.setText("Categorias (POSTORDEN)");

        jButton16.setText("Generar Reporte");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel30.setText("Usuarios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel26)
                        .addGap(1, 1, 1)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27)
                        .addGap(1, 1, 1)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addGap(1, 1, 1)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addGap(1, 1, 1)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addGap(1, 1, 1)
                        .addComponent(jButton16)
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reportes", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este libro?", "Interfaz de eliminacion", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            String m = JOptionPane.showInputDialog(null, "Dinos el motivo:", "Eliminacion de Libro", JOptionPane.QUESTION_MESSAGE);
            if (ctrl.EliminarLibro(Integer.parseInt(jTextCarnet.getText()), Integer.parseInt(jTextISBN1.getText()), jTextCategoria1.getText())) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el libro con el siguiente ISBN: "+jTextISBN1.getText(), "Libro Eliminado", JOptionPane.INFORMATION_MESSAGE);
                jTextISBN1.setText("");
                jTextTitulo1.setText("");
                jTextAutor1.setText("");
                jTextEditorial1.setText("");
                jTextAno1.setText("");
                jTextEdicion1.setText("");
                jTextCategoria1.setText("");
                jTextIdioma1.setText("");
                jTextDueno.setText("");
                jTextCarnet.setText("");
                if (jTextBuscador.getText().isEmpty()) {
                    ActualizarTabla();
                }else{
                    if (isNumeric(jTextBuscador.getText())) {
                        ActualizarTabla();
                        jTextBuscador.setText("");
                    }else{
                        BuscadorLibros();
                    }
                }
                ComboCategorias();
            }
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos Json (.json)", "json"));
        chooser.setDialogTitle("Selecciona un archivo de carga de Libros");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            if (ctrl.CargaLibro(archivo.getAbsolutePath())) {
                JOptionPane.showMessageDialog(null, "Se han cargado los libros", "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        ActualizarTabla();
        ComboCategorias();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ctrl.CargaLibro(Integer.parseInt(jTextISBN.getText()), jTextTitulo.getText(), jTextAutor.getText(), jTextEditorial.getText(), Integer.parseInt(jTextAno.getText()), Integer.parseInt(jTextEdicion.getText()), jTextCategoria.getText(), jTextIdioma.getText())) {
            JOptionPane.showMessageDialog(null, "Se ha registrado el libro", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            jTextISBN.setText("");
            jTextTitulo.setText("");
            jTextAutor.setText("");
            jTextEditorial.setText("");
            jTextAno.setText("");
            jTextEdicion.setText("");
            jTextCategoria.setText("");
            jTextIdioma.setText("");
        }
        ActualizarTabla();
        ComboCategorias();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BuscadorLibros();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscadorActionPerformed
        System.out.println("teclado");
    }//GEN-LAST:event_jTextBuscadorActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Categorias temp = ctrl.ObtenerCategoria(jComboBox2.getSelectedItem().toString());
        String repo = temp.getLibreria().Graficar(temp.getNombre());
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Icon icono = new ImageIcon(repo);
        Report.setIcon(icono);

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       try {
           ctrl.ImprimirAVL();
           sleep(1000);
       } catch (IOException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InterruptedException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
       }
       Icon icono = new ImageIcon("Categorias.png");
       Report.setIcon(icono);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String graph = "digraph g{ rankdir = LR; node [shape = box];\n";
        Categorias[] array = ctrl.AVLPreorden();
        for(int i = 1; i < array.length; i++){
            graph += array[i-1].getNombre()+" -> "+array[i].getNombre()+";\n";
        }
        graph+="}";
        System.out.println(graph);
        try{
            BufferedWriter write = new BufferedWriter(new FileWriter("AVLPreorden.dot"));
            write.write(graph);
            write.close();
            File a = new File("AVLPreorden.dot");
            String comando = "dot -Tpng "+a.getAbsolutePath()+" -o"+a.getAbsolutePath().replace(".dot", ".png");
            Runtime.getRuntime().exec(comando);
            sleep(1000);
        }catch(IOException ex){
            
        } catch (InterruptedException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Icon icono = new ImageIcon("AVLPreorden.png");
        Report.setIcon(icono);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String graph = "digraph g{ rankdir = LR; node [shape = box];\n";
        Categorias[] array = ctrl.AVLInorden();
        for(int i = 1; i < array.length; i++){
            graph += array[i-1].getNombre()+" -> "+array[i].getNombre()+";\n";
        }
        graph+="}";
        System.out.println(graph);
        try{
            BufferedWriter write = new BufferedWriter(new FileWriter("AVLInorden.dot"));
            write.write(graph);
            write.close();
            File a = new File("AVLInorden.dot");
            String comando = "dot -Tpng "+a.getAbsolutePath()+" -o"+a.getAbsolutePath().replace(".dot", ".png");
            Runtime.getRuntime().exec(comando);
            sleep(1000);
        }catch(IOException ex){
            
        } catch (InterruptedException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Icon icono = new ImageIcon("AVLInorden.png");
        Report.setIcon(icono);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String graph = "digraph g{ rankdir = LR; node [shape = box];\n";
        Categorias[] array = ctrl.AVLPostorden();
        for(int i = 1; i < array.length; i++){
            graph += array[i-1].getNombre()+" -> "+array[i].getNombre()+";\n";
        }
        graph+="}";
        System.out.println(graph);
        try{
            BufferedWriter write = new BufferedWriter(new FileWriter("AVLPostorden.dot"));
            write.write(graph);
            write.close();
            File a = new File("AVLPostorden.dot");
            String comando = "dot -Tpng "+a.getAbsolutePath()+" -o"+a.getAbsolutePath().replace(".dot", ".png");
            Runtime.getRuntime().exec(comando);
            sleep(1000);
        }catch(IOException ex){
            
        } catch (InterruptedException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Icon icono = new ImageIcon("AVLPostorden.png");
        Report.setIcon(icono);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
           ctrl.ImprimirHash();
           sleep(1000);
       } catch (InterruptedException ex) {
           Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
       }
       Icon icono = new ImageIcon("Usuarios.png");
       Report.setIcon(icono);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ctrl.IniciarServidor(jTextHost.getText(), Integer.parseInt(jTextPuerto.getText()));
        ctrl.IngresarRed();
        ActualizarParametros();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar la categoria \""+jComboBox1.getSelectedItem().toString()+"\" de la biblioteca?", "Eliminacion de Categorias", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            ctrl.EliminarCategoria(jComboBox1.getSelectedItem().toString());
            ComboCategorias();
            ActualizarTabla();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea añadir la categoria \""+jTextAddCat.getText()+"\" a la biblioteca?", "Creacion de Categorias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            ctrl.CrearCategoria(jTextAddCat.getText());
            ComboCategorias();
            jTextAddCat.setText("");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (ctrl.EliminarUsuario()) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (ctrl.ModificarUsuario(jTextNameEdit.getText(), jTextLastNameEdit.getText(), jTextCareerEdit.getText())) {
            InfoLogeado();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (ctrl.Deslogin()) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        ctrl.ImprimirNodos();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        ctrl.RegistroNodoRedClienteSide(Integer.parseInt(jTextField1.getText()), jTextField2.getText());
        ActualizarParametros();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        ActualizarParametros();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void BuscadorLibros(){
        if (isNumeric(jTextBuscador.getText())) {
            Libro temp = ctrl.ObtenerLibro(Integer.parseInt(jTextBuscador.getText()));
            if (temp != null) {
                jTextISBN1.setText(String.valueOf(temp.getISBN()));
                jTextTitulo1.setText(temp.getTitulo());
                jTextAutor1.setText(temp.getAutor());
                jTextEditorial1.setText(temp.getEditorial());
                jTextAno1.setText(String.valueOf(temp.getAno()));
                jTextEdicion1.setText(Integer.toString(temp.getEdicion()));
                jTextCategoria1.setText(temp.getCategoria());
                jTextIdioma1.setText(temp.getIdioma());
                jTextDueno.setText(ctrl.ObtenerUser(temp.getCarnet()).getNombre()+" "+ctrl.ObtenerUser(temp.getCarnet()).getApellido());
                jTextCarnet.setText(Integer.toString(temp.getCarnet())); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe el libro en la biblioteca", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextISBN1.setText("");
                jTextTitulo1.setText("");
                jTextAutor1.setText("");
                jTextEditorial1.setText("");
                jTextAno1.setText("");
                jTextEdicion1.setText("");
                jTextCategoria1.setText("");
                jTextIdioma1.setText("");
                jTextDueno.setText("");
                jTextCarnet.setText("");
            }
        }else{
            this.model = null;
            String[] cabeceras = {"ISBN", "Titulo", "Categoria","Dueño", ""};
            this.model = new DefaultTableModel(null, cabeceras);
            Categorias[] array = ctrl.ObtenerCategorias();
            for(Categorias cat : array){
                if (cat != null) {
                    Libro[] libros = cat.getLibreria().RecorridoOrdenado();
                    if (libros != null) {
                        for (Libro lib : libros) {
                            if (lib.getTitulo().contains(jTextBuscador.getText())) {
                                this.model.addRow(new Object[]{lib.getISBN(),lib.getTitulo(),lib.getCategoria(),ctrl.ObtenerUser(lib.getCarnet()).getNombre(), new JButton("ver")});
                            }else{
                                if (lib.getCategoria().contains(jTextBuscador.getText())) {
                                    this.model.addRow(new Object[]{lib.getISBN(),lib.getTitulo(),lib.getCategoria(),ctrl.ObtenerUser(lib.getCarnet()).getNombre(), new JButton("ver")});    
                                }
                            }
                        }
                    }
                }
            }
            jTable1.setModel(model);
        }
    }
    
    
    private boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private void ActualizarTabla(){
        this.model = null;
        String[] cabeceras = {"ISBN", "Titulo", "Categoria","Dueño", ""};
        this.model = new DefaultTableModel(null, cabeceras);
        Categorias[] array = ctrl.ObtenerCategorias();
        for (Categorias cat : array) {
            if (cat != null) {
                Libro[] libros = cat.getLibreria().RecorridoOrdenado();
                for (Libro lib : libros) {
                    if (lib != null) {
                        Usuario temp = ctrl.ObtenerUser(lib.getCarnet());
                        model.addRow(new Object[]{lib.getISBN(), lib.getTitulo(), lib.getCategoria(), temp.getNombre(), new JButton("ver")});
                    }    
                }
            }
        }
        
        this.jTable1.setModel(model);
    }
    
    private void InfoLibro(Libro lib){
        jTextISBN1.setText(String.valueOf(lib.getISBN()));
        jTextTitulo1.setText(lib.getTitulo());
        jTextAutor1.setText(lib.getAutor());
        jTextEditorial1.setText(lib.getEditorial());
        jTextAno1.setText(String.valueOf(lib.getAno()));
        jTextEdicion1.setText(Integer.toString(lib.getEdicion()));
        jTextCategoria1.setText(lib.getCategoria());
        jTextIdioma1.setText(lib.getIdioma());
        jTextDueno.setText(ctrl.ObtenerUser(lib.getCarnet()).getNombre()+" "+ctrl.ObtenerUser(lib.getCarnet()).getApellido());
        jTextCarnet.setText(Integer.toString(lib.getCarnet())); 
        
    }
     
    private void ComboCategorias(){
        Categorias[] categorias = ctrl.ObtenerCategorias();
        this.cbModel.removeAllElements();
        for(Categorias cat : categorias){
            if (cat != null) {
                this.cbModel.addElement(cat.getNombre());
            }
        }
        this.jComboBox1.setModel(cbModel);
        this.jComboBox2.setModel(cbModel);
    } 
    //Metodo global que maneja eventos de cada uno de los componentes
    private void Eventos(){
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
            int fila = jTable1.rowAtPoint(e.getPoint());
            int columna = jTable1.columnAtPoint(e.getPoint());
            if (columna == 4) {
                Libro temp = ctrl.ObtenerLibro(Integer.parseInt(jTable1.getValueAt(fila, 0).toString()));
                InfoLibro(temp);
            }                
        }
        });
        
        this.jTextBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                if (!isNumeric(jTextBuscador.getText())) {
                    BuscadorLibros();
                    jTextISBN1.setText("");
                    jTextTitulo1.setText("");
                    jTextAutor1.setText("");
                    jTextEditorial1.setText("");
                    jTextAno1.setText("");
                    jTextEdicion1.setText("");
                    jTextCategoria1.setText("");
                    jTextIdioma1.setText("");
                    jTextDueno.setText("");
                    jTextCarnet.setText("");
                }
            }
        });
        
       this.Report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
               
                File a = new File("Reporte.png");
                try{
                    
                    Desktop.getDesktop().open(a);
                }catch (IOException ex){
                    System.out.println(ex.toString());
                }
            }
        });
        
    }
    
    private void ActualizarParametros(){
        if (ctrl.PruebaRed()) {
            jLabelNet.setText("¡Estas conectado en la Red!"); 
        }
        jLabelEstado.setText(ctrl.Parametraje());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Report;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNet;
    private javax.swing.JLabel jLabelUserInfo;
    private javax.swing.JLabel jLabelUserInfo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAddCat;
    private javax.swing.JTextField jTextAno;
    private javax.swing.JTextField jTextAno1;
    private javax.swing.JTextField jTextAutor;
    private javax.swing.JTextField jTextAutor1;
    private javax.swing.JTextField jTextBuscador;
    private javax.swing.JTextField jTextCareerEdit;
    private javax.swing.JTextField jTextCarnet;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextCategoria1;
    private javax.swing.JTextField jTextDueno;
    private javax.swing.JTextField jTextEdicion;
    private javax.swing.JTextField jTextEdicion1;
    private javax.swing.JTextField jTextEditorial;
    private javax.swing.JTextField jTextEditorial1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextHost;
    private javax.swing.JTextField jTextISBN;
    private javax.swing.JTextField jTextISBN1;
    private javax.swing.JTextField jTextIdioma;
    private javax.swing.JTextField jTextIdioma1;
    private javax.swing.JTextField jTextLastNameEdit;
    private javax.swing.JTextField jTextNameEdit;
    private javax.swing.JTextField jTextPuerto;
    private javax.swing.JTextField jTextTitulo;
    private javax.swing.JTextField jTextTitulo1;
    // End of variables declaration//GEN-END:variables
}
