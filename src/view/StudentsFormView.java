/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentsController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.StudentsModel;
import view.Vistaa;


public class StudentsFormView extends javax.swing.JFrame {

    private Long init;
    private Long end;
    private List<StudentsModel> listStud;
    private final StudentsController studController;

    public StudentsFormView(String route) {
        this.studController = new StudentsController();
        // Toma de Tiempo Inicio
        this.init = System.currentTimeMillis();
        this.studController.setDataTree(route);
        // Toma de Tiempo Final
        this.end = System.currentTimeMillis();
        initComponents();
        lblTime.setText((this.end - this.init) + " Milisegundos -  Carga de Datos");
        updateTblStudents();
    }
    
    public final void updateTblStudents() {
        
        this.listStud = this.studController.getData();
    
        String matriz[][] = new String[this.listStud.size()][3];
        for(int i = 0; i < this.listStud.size(); i++) {
            matriz[i][0] = Integer.toString(this.listStud.get(i).getIdStudents());
            matriz[i][1] = this.listStud.get(i).getName();
            matriz[i][2] = this.listStud.get(i).getStudy();
        }
        
        tblStudents.setModel(new DefaultTableModel(
                matriz,
                new String[] {
                    "Carnet", "Nombre", "Carrera"
                }
        ));
        
        DefaultTableModel dm = (DefaultTableModel) tblStudents.getModel();
        dm.fireTableDataChanged();
        
    }
    
    public final void findStudents() {
        
        String idStudents = txtIdStudents.getText();
        String name = txtName.getText();
        String Carrera = txtStudy.getText();
        
        StudentsModel stud = new StudentsModel();
        stud.setIdStudents(Integer.parseInt(idStudents));
        stud.setName(name);
        stud.setStudy(Carrera);
        // Toma de Tiempo Inicio
        this.init = System.currentTimeMillis();
        StudentsModel findStud = this.studController.searchStudents(stud);
        // Toma de Tiempo Final
        this.end = System.currentTimeMillis();
        lblTime.setText((this.end - this.init) + " Milisegundos -  Buscar");
        
        JOptionPane.showMessageDialog(this,findStud.toString(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public final void inserNewStudents() {
        
        String idStudents = txtIdStudents.getText();
        String name = txtName.getText();
        String study = txtStudy.getText();
        
        StudentsModel stud = new StudentsModel();
        stud.setIdStudents(Integer.parseInt(idStudents));
        stud.setName(name);
        stud.setStudy(study);
        
        // Toma de Tiempo Inicio
        this.init = System.currentTimeMillis();
        String msg = this.studController.createStudents(stud);
        // Toma de Tiempo Final
        this.end = System.currentTimeMillis();
        lblTime.setText((this.end - this.init) + " Milisegundos -  Insertar");
        
        JOptionPane.showMessageDialog(this,msg, "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        updateTblStudents();
    }
    
    public final void updateExistStudents() {
    
        String idStudents = txtIdStudents.getText();
        String name = txtName.getText();
        String study = txtStudy.getText();
        
        StudentsModel stud = new StudentsModel();
        stud.setIdStudents(Integer.parseInt(idStudents));
        stud.setName(name);
        stud.setStudy(study);
        
        // Toma de Tiempo Inicio
        this.init = System.currentTimeMillis();
        String msg = this.studController.updateStudents(stud);
        // Toma de Tiempo Final
        this.end = System.currentTimeMillis();
        lblTime.setText((this.end - this.init) + " Milisegundos -  Actualizar");
        
        JOptionPane.showMessageDialog(this,msg, "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        updateTblStudents();
        
    }
    
    public final void removeStudents() {
    
        String idStudents = txtIdStudents.getText();
        String name = txtName.getText();
        String study = txtStudy.getText();
        
        StudentsModel stud = new StudentsModel();
        stud.setIdStudents(Integer.parseInt(idStudents));
        stud.setName(name);
        stud.setStudy(study);
        
        // Toma de Tiempo Inicio
        this.init = System.currentTimeMillis();
        String msg = this.studController.deleteStudents(stud);
        // Toma de Tiempo Final
        this.end = System.currentTimeMillis();
        lblTime.setText((this.end - this.init) + " Milisegundos -  Eliminar");
        
        JOptionPane.showMessageDialog(this,msg, "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        updateTblStudents();
        
    }
 
    public final void graphTree() {
        
        Vistaa v = new Vistaa(this.studController.printTree());
        v.show();
        //this.studController.printTree();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdStudents = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtStudy = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGraph = new javax.swing.JButton();
        lblReturn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No. Carnet", "Nombre", "Carrera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.setName("tblEmpleados"); // NOI18N
        jScrollPane1.setViewportView(tblStudents);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Modulo de Alumnos");

        jLabel2.setText("No. Carnet:");

        jLabel3.setText("Nombre completo:");

        jLabel4.setText("Carrera:");

        txtIdStudents.setName("txtNumberEmployee"); // NOI18N
        txtIdStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdStudentsActionPerformed(evt);
            }
        });

        txtName.setName("txtName"); // NOI18N

        txtStudy.setName("txtStudy"); // NOI18N
        txtStudy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudyActionPerformed(evt);
            }
        });

        btnSearch.setText("Buscar");
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblTime.setText("0");

        jLabel6.setText("Tiempo:");

        btnGraph.setText("Graficar");
        btnGraph.setName("btnGraph"); // NOI18N
        btnGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphActionPerformed(evt);
            }
        });

        lblReturn.setForeground(new java.awt.Color(0, 153, 255));
        lblReturn.setText("Regresar");
        lblReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReturn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtStudy)
                            .addComponent(txtIdStudents)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGraph)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblReturn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtIdStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStudy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnGraph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseClicked
       this.hide();
       SelectRouteView selectRouteView =  new SelectRouteView();
       selectRouteView.setVisible(true);
    }//GEN-LAST:event_lblReturnMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        findStudents();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateExistStudents();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        removeStudents();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphActionPerformed
        graphTree();
    }//GEN-LAST:event_btnGraphActionPerformed

    private void txtIdStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdStudentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdStudentsActionPerformed

    private void txtStudyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudyActionPerformed

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
            java.util.logging.Logger.getLogger(StudentsFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsFormView("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGraph;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReturn;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtIdStudents;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStudy;
    // End of variables declaration//GEN-END:variables
}
