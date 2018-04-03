/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.catedra.encargados;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.catedra.Conexion;
/**
 *
 * @author luigi
 */
public final class MaeProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form TipoProducto
     */
    
    ResultSet resultado;
    private ResultSet rs;
    DefaultTableModel modelo = null;
    public static int bandera = 0;
    static int id;
    Conexion con;
    ArrayList autores = new ArrayList();
    
    public MaeProducto() {
        initComponents();
        Object [][] data = null;
        String [] columns = {"ID","Código","Título","Tipo","Categoría"};
        modelo = new DefaultTableModel(data,columns);
        this.dgvDatos.setModel(modelo);
        iniciarValores();
    }
    
    public void iniciarValores(){
        try {
            con = new Conexion();
            //ComboBox Tipo
            con.setRs("SELECT tproId,tproNombre FROM TipoProducto ORDER BY tproId ASC");
            con.llenarCombo(cboTipo);
            //ComboBox Categoria
            con.setRs("SELECT cproId,cproNombre FROM CategoriaProducto ORDER BY cproCodigo ASC");
            con.llenarCombo(cboCategoria);
            //ComboBox Editorial
            con.setRs("SELECT edtId,edtNombre FROM Editorial ORDER BY edtNombre ASC");
            con.llenarCombo(cboEditorial);
            //ComboBox Categoria
            con.setRs("SELECT langId,langNombre FROM Idioma ORDER BY langId ASC");
            con.llenarCombo(cboIdioma);
            for (int i = 2018; i > 1950; i--) {
                cboAnio.addItem("" + i);
            }
           //ListView Autores
            con.setRs("SELECT autId,CONCAT(autNombre,' ',autApellido) AS Nombre FROM Autor ORDER BY Nombre ASC");
            con.llenarList(lstAutorO);
            generarListado();
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnLimpiar.setEnabled(false);
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MaeProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Ocurrió un problema en la BD "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    public void generarListado(){
        while (modelo.getRowCount()!=0) {
            modelo.removeRow(0);
        }
        try {
            Conexion con2 = new Conexion();
            con2.setRs("SELECT p.proId,p.proIsbn,p.proNombre,t.tproNombre,c.cproNombre FROM Producto p INNER JOIN CategoriaProducto c ON p.cproId = c.cproId INNER JOIN TipoProducto t ON p.tproId = t.tproId");
            resultado = (ResultSet) con.getRs();
            while (resultado.next()) {
                Object [] newRow={resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)};
                modelo.addRow(newRow);
            }
            resultado.close();
            con2.cerrarConexion();
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(Editorial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR: Ocurrió un problema en la BD "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    public void limpiar(){
        cboTipo.setSelectedIndex(0);cboCategoria.setSelectedIndex(0);cboEditorial.setSelectedIndex(0);cboIdioma.setSelectedIndex(0);
        cboAnio.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        dgvDatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtCodigo = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox<>();
        cboEditorial = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox<>();
        spnPaginas = new javax.swing.JSpinner();
        spnEdicion = new javax.swing.JSpinner();
        txtLugar = new javax.swing.JTextField();
        cboAnio = new javax.swing.JComboBox<>();
        spnVolumen = new javax.swing.JSpinner();
        spnPeso = new javax.swing.JSpinner();
        txtColeccion = new javax.swing.JTextField();
        cboIdioma = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAutorD = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAutorO = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Maestro de Productos");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        dgvDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(dgvDatos);

        jTabbedPane1.addTab("Listado", jScrollPane4);

        jLabel1.setText("Tipo de producto:");

        jLabel2.setText("Categoría:");

        jLabel3.setText("Código");

        jLabel4.setText("Título");

        jLabel5.setText("Editorial:");

        jLabel6.setText("Número de páginas:");

        jLabel7.setText("Edición:");

        jLabel8.setText("Lugar de publicación");

        jLabel9.setText("Año de publicación:");

        jLabel10.setText("Volumen:");

        jLabel11.setText("Peso (Kg):");

        jLabel12.setText("Colección:");

        jLabel13.setText("Idioma:");

        jLabel14.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Autores:");

        jScrollPane2.setViewportView(lstAutorD);

        btnAdd.setText(">>");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("<<");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lstAutorO);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboEditorial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spnEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spnVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(30, 30, 30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(spnPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnRemove))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(181, 181, 181))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel13))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(spnVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(13, 13, 13)
                                .addComponent(cboIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Detalle", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnModificar.setText("Modificar");

        btnLimpiar.setText("Limpiar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        autores.add(con.getKey(lstAutorO));
        con.moverList(lstAutorO, lstAutorD);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        con.returnList(lstAutorD, lstAutorO);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnNuevo.setText("Agregar");
                limpiar();
            } else {
                String sql =  "INSERT INTO Producto VALUES(null,"+con.getValue(cboTipo)+","+con.getValue(cboCategoria)+",'"+txtCodigo.getText().trim() +"','"+txtNombre.getText().trim()+
                            "',"+con.getValue(cboEditorial)+","+spnPaginas.getValue()+","+spnEdicion.getValue().toString()+",'"+txtLugar.getText().trim()+"',"+cboAnio.getSelectedItem()+","+spnVolumen.getValue().toString()+
                            ","+spnPeso.getValue().toString()+",'"+txtColeccion.getText().trim()+"',"+con.getValue(cboIdioma)+",'"+txtDescripcion.getText().trim() +"',null)";
                    Conexion con2 = new Conexion();
                    con2.setQuery(sql);
                    Conexion con3 = new Conexion();
                    con3.setRs("SELECT proId FROM Producto WHERE proIsbn = '" + txtCodigo.getText().trim() + "'");
                    rs = (ResultSet)con3.getRs();
                    rs.next();
                    for(int i = 0; i < autores.size(); i++){
                        con.setQuery("INSER INTO ProductoAutor VALUES(null,"+ autores.get(i) +","+rs.getInt(1)+")");
                    }
                    rs.close();
                    JOptionPane.showMessageDialog(null, "Producto ingresado exitosamente", "Transacción", JOptionPane.INFORMATION_MESSAGE, null);
                    con2.cerrarConexion();
                    con3.cerrarConexion();
                    iniciarValores();
                    limpiar();
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Ocurrió un problema en la BD "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cboAnio;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboEditorial;
    private javax.swing.JComboBox<String> cboIdioma;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JTable dgvDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lstAutorD;
    private javax.swing.JList<String> lstAutorO;
    private javax.swing.JSpinner spnEdicion;
    private javax.swing.JSpinner spnPaginas;
    private javax.swing.JSpinner spnPeso;
    private javax.swing.JSpinner spnVolumen;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColeccion;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
