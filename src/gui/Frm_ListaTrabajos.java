
package gui;

import Gestor.GestorTrabajo;
import Datos.Trabajo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Frm_ListaTrabajos extends javax.swing.JFrame {

  GestorTrabajo unTrabajo = new GestorTrabajo();
  Trabajo trabajo = new Trabajo(); 
  Vector vCabecera= new Vector();
  public static DefaultTableModel mdlTabla= new DefaultTableModel();
 
    public Frm_ListaTrabajos() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagen/birrete (2).png")).getImage() );
        this.setLocationRelativeTo(this);
        ImageIcon nuevo = new ImageIcon (getClass().getResource("/imagen/lista-png-6.png"));
        ImageIcon icono = new ImageIcon(nuevo.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(icono);
        label1.setVisible(true);
        ImageIcon nuevo1 = new ImageIcon (getClass().getResource("/imagen/fondonaranja2.jpg"));
        ImageIcon icono1 = new ImageIcon(nuevo1.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono1);
        jLabel2.setVisible(true);
        cerrar();
        
        vCabecera.addElement("Titulo");
        vCabecera.addElement("Duracion");
        vCabecera.addElement("Area");
        vCabecera.addElement("Fecha Presentacion");
        vCabecera.addElement("Fecha Aprobacion");
        vCabecera.addElement("Fecha Exposicion");
        vCabecera.addElement("Profesor");
        vCabecera.addElement("Tutor");
        vCabecera.addElement("Cotutor");
        vCabecera.addElement("Jurado");
        vCabecera.addElement("Alumno");
        mdlTabla = new DefaultTableModel(vCabecera,0);
        jTable1.setModel(mdlTabla);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 149, 837, 248));

        btnListar.setBackground(new java.awt.Color(0, 102, 102));
        btnListar.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        getContentPane().add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 40));
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 52, 108, 79));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 3, 50)); // NOI18N
        jLabel1.setText("Trabajos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 63, 293, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
       
        jTable1.setModel(unTrabajo.listar());
    }//GEN-LAST:event_btnListarActionPerformed

    public void cerrar(){
        try {
          this.setDefaultCloseOperation(Frm_ListaTrabajos.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
                confirmarSalida();
                JFrame frame = new Frm_Opciones();
               
            frame.setLocationRelativeTo(frame);
            frame.setVisible(true);
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
//        int valor= JOptionPane.showConfirmDialog(null, "Esta seguro de salir?","ADVERTENCIA",JOptionPane.YES_NO_OPTION);
        this.setVisible(false);
//        if (valor==JOptionPane.YES_OPTION){ 
//            System.exit(0);
//        }
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
            java.util.logging.Logger.getLogger(Frm_ListaTrabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ListaTrabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ListaTrabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ListaTrabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_ListaTrabajos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel label1;
    // End of variables declaration//GEN-END:variables
}
