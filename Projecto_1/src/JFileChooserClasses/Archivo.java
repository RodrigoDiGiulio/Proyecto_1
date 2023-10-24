/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFileChooserClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projecto_1.Classes.AdjMatrix;
import projecto_1.Classes.DataInterpreter;
import projecto_1.Classes.List;

/**
 *
 * @author Ignacio
 */
public class Archivo extends javax.swing.JFrame {
    String texto;
    boolean firstRun = true;
    JFileChooser fileChooser;
    /**
     * Creates new form archive
     */
    public Archivo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fileChooser = new JFileChooser();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Abrir = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 280));

        Abrir.setText("ABRIR");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        jPanel1.add(Abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        Guardar.setText("GUARDAR");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        Iniciar.setText("INICIAR");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        jPanel1.add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        jLabel1.setText("COMPONENTE JFILECHOOSER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String abrirArchivo() {
        texto = "";
        boolean usuariosSection = false;
        boolean relacionesSection = false;
        boolean formatoValido = false;

        try {
            fileChooser.showOpenDialog(this);
            File abre = fileChooser.getSelectedFile();

            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                String line;
                while ((line = lee.readLine()) != null) {
                    if (line.equals("usuarios")) {
                        usuariosSection = true;
                        relacionesSection = false;
                        formatoValido = true;
                        texto += line + "\n"; // Agregar el título "usuarios"
                        continue; // Saltar la línea del encabezado
                    } else if (line.equals("relaciones")) {
                        usuariosSection = false;
                        relacionesSection = true;
                        formatoValido = true;
                        texto += line + "\n"; // Agregar el título "relaciones"
                        continue; // Saltar la línea del encabezado
                    }

                    if (usuariosSection && line.startsWith("@")) {
                        texto += line + "\n";
                    } else if (relacionesSection && line.matches("@\\w+, @\\w+")) {
                        texto += line + "\n";
                    } else {
                        // Formato no válido
                        formatoValido = false;
                        break;
                    }
                }

                lee.close();
            }

            if (!formatoValido) {
                JOptionPane.showMessageDialog(null,
                    "Error: El archivo no cumple con el formato requerido.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
                texto = ""; // Reiniciar el texto
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" +
                "\nNo se ha encontrado el archivo",
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }

        firstRun = false;
        return texto;
    }

    private void iniciarGrafo(){ 
        String[] dataUsr = null;
        String[] dataFollow = null;
        DataInterpreter dataText = new DataInterpreter();
        List data = new List();
        if (firstRun){
            //Uusa la data dada en los txt para diferenciar Usr de seguidores
            data = dataText.getDafaultData();
            dataUsr = (String[]) data.searchPos(0);
            dataFollow = (String[]) data.searchPos(1);
            firstRun = false;
        }
        else{
            //Uusa la data dada en los txt para diferenciar Usr de seguidores
            String newData = this.getData();
            dataText.setData(newData);
            data = dataText.getData();
            dataUsr = (String[]) data.searchPos(0);
            dataFollow = (String[]) data.searchPos(1);
        }
        
        //crea la Matrix, el 3 no importa, el despues modifica el size
        AdjMatrix test = new AdjMatrix(3);
        
        //crea la lista que va a guardar a todos los grupos
        List stronglyConnected = new List();

        //aplica kosaraju y guarda los grupos en una lista
        stronglyConnected = test.kosaraju(dataUsr,dataFollow);
        
        System.out.println("TERMINE???");
        
        int groupNum = stronglyConnected.isSize();
//        System.out.println("Group Num: " + groupNum);
        
        //esto es un print de que hay en cada grupo, pero sirve para acceder a cada dato dentro del grupo
        for (int i = 0; i < groupNum; i++) {
            System.out.print("Grupo "+(i+1)+": ");
            int[] specGroup = (int[]) stronglyConnected.searchPos(i);
            for (int x : specGroup) {
                //aqui se modifica lo que se va a hacer para cada item en el grupo
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private void guardarArchivo() {

            try
            {
                    String nombre="";
                    JFileChooser file=new JFileChooser();
                    file.showSaveDialog(this);
                    File guarda =file.getSelectedFile();

                    if(guarda !=null)
                    {
                            nombre=file.getSelectedFile().getName();
                            /*guardamos el archivo y le damos el formato directamente,
                             * si queremos que se guarde en formato doc lo definimos como .doc*/
                            FileWriter  save=new FileWriter(guarda+".txt");
                            save.write(jTextArea1.getText());
                            save.close();
                            JOptionPane.showMessageDialog(null,
                                            "El archivo se a guardado Exitosamente",
                                            "Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
             }
       catch(IOException ex)
       {
             JOptionPane.showMessageDialog(null,
                             "Su archivo no se ha guardado",
                             "Advertencia",JOptionPane.WARNING_MESSAGE);
       }
    }

    public String getData(){
        System.out.println(texto);
        return texto;
    }

    
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        iniciarGrafo();
    }//GEN-LAST:event_IniciarActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        String archivo=abrirArchivo();
        jTextArea1.setText(archivo);
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        guardarArchivo();
    }//GEN-LAST:event_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Archivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
