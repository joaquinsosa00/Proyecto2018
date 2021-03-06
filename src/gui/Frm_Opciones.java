/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class Frm_Opciones extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Opciones
     */
    public Frm_Opciones() {
        initComponents();
        ImageIcon nuevo = new ImageIcon (getClass().getResource("/imagen/unt.png"));
        ImageIcon icono = new ImageIcon(nuevo.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icono);
        ImageIcon nuevo1 = new ImageIcon (getClass().getResource("/imagen/fondonaranja2.jpg"));
        ImageIcon icono1 = new ImageIcon(nuevo1.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono1);
        this.setLocationRelativeTo(this);
        cerrar();
//        Jurado(Frm_GuardarDatos.comboJurado);
//        Profesores(comboProfesor);
////        Tutor(comboTutor);
////        Cotutor(comboCotutor);
////        Alumno(comboAlumno);
//        
        
        
        setIconImage(new ImageIcon(getClass().getResource("/imagen/birrete (2).png")).getImage() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardado = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabajo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardado.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuardado.setForeground(new java.awt.Color(240, 240, 240));
        btnGuardado.setText("Trabajo nuevo");
        btnGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 170, -1));

        btnLista.setBackground(new java.awt.Color(0, 102, 102));
        btnLista.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLista.setForeground(new java.awt.Color(240, 240, 240));
        btnLista.setText("Lista de trabajos");
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 200, -1));

        btnSalir.setBackground(new java.awt.Color(153, 0, 0));
        btnSalir.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(240, 240, 240));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 87, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 540, 150));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 540, 150));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 560, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardadoActionPerformed
        JFrame frame  = new Frm_GuardarDatos();
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
        this.setVisible(false);
        Gestor.GestorTrabajo.bandera=1;
        
    }//GEN-LAST:event_btnGuardadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         
       int exit = JOptionPane.showConfirmDialog(null, "Desea salir?", "Exit", JOptionPane.YES_NO_OPTION);
       if (exit == JOptionPane.YES_OPTION){
           System.exit(0);
       }
    }//GEN-LAST:event_btnSalirActionPerformed

    
    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new Frm_ListaTrabajos();
            frame.setLocationRelativeTo(frame);
            frame.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btnListaActionPerformed

    public void cerrar(){
        try {
          this.setDefaultCloseOperation(Frm_Opciones.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
                confirmarSalida();
                
//            frame1.setVisible(false);
            
            }
        });
        this.setVisible(true);
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }
    public void confirmarSalida(){
        int valor= JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?","ADVERTENCIA",JOptionPane.YES_NO_OPTION);
        
        if (valor==JOptionPane.YES_OPTION){ 
//            this.setVisible(false);
//            JFrame frame = new Frm_Opciones();
//               
//            frame.setLocationRelativeTo(frame);
//            frame.setVisible(true);
            System.exit(0);
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
            java.util.logging.Logger.getLogger(Frm_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Opciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardado;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
