/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFileChooserClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import projecto_1.Classes.AdjMatrix;
import projecto_1.Classes.DataInterpreter;
import projecto_1.Classes.List;

/**
 *
 * @author RDG
 */
public class Menu extends javax.swing.JFrame{
    //Atributos
    String texto = "usuarios\n@pepe\n@mazinger\n@juanc\n@xoxojaime\n@tuqui33\n@sancho23\n@terciopelo\n@caribedoble\n@africa\n@totalfree\n@radiogaga\n@cipriano\n@newageforever\nrelaciones\n@pepe, @mazinger\n@mazinger, @juanc\n@mazinger, @tuqui33\n@tuqui33, @xoxojaime\n@xoxojaime, @pepe\n@juanc, @sancho23\n@sancho23, @mazinger\n@sancho23, @terciopelo\n@terciopelo, @newageforever\n@terciopelo, @caribedoble\n@caribedoble, @africa\n@africa, @cipriano\n@cipriano, @totalfree\n@cipriano, @radiogaga\n@totalfree, @africa\n@totalfree, @radiogaga\n@radiogaga, @caribedoble\n";
    boolean firstRun = true;
    JFileChooser fileChooser;
    int lastRGB = 0;
    int lastGroup = 0;
    int currentGroup = 0;
    
    /**
     * Creates new form archive
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fileChooser = new JFileChooser();
        if(firstRun == true){
            jLabel1.setText("DATA POR DEFECTO");
            jTextArea1.setText("usuarios\n@pepe\n@mazinger\n@juanc\n@xoxojaime\n@tuqui33\n@sancho23\n@terciopelo\n@caribedoble\n@africa\n@totalfree\n@radiogaga\n@cipriano\n@newageforever\nrelaciones\n@pepe, @mazinger\n@mazinger, @juanc\n@mazinger, @tuqui33\n@tuqui33, @xoxojaime\n@xoxojaime, @pepe\n@juanc, @sancho23\n@sancho23, @mazinger\n@sancho23, @terciopelo\n@terciopelo, @newageforever\n@terciopelo, @caribedoble\n@caribedoble, @africa\n@africa, @cipriano\n@cipriano, @totalfree\n@cipriano, @radiogaga\n@totalfree, @africa\n@totalfree, @radiogaga\n@radiogaga, @caribedoble\n");
            Guardar.setVisible(false);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 380));

        pack();
    }// </editor-fold>                        
    
    private String getColor(){
        String color = "";
        switch(lastRGB){
            case 11:
                color = "rgb(255,178,102)";
                break;
            case 4:
                color = "rgb(255,255,102)";
                break;
            case 8:
                color = "rgb(178,255,102)";
                break;
            case 7:
                color = "rgb(102,255,102)";
                break;
            case 9:
                color = "rgb(102,255,178)";
                break;
            case 2:
                color = "rgb(102,255,255)";
                break;
            case 10:
                color = "rgb(102,178,255)";
                break;
            case 5:
                color = "rgb(102,102,255)";
                break;
            case 1:
                color = "rgb(178,102,255)";
                break;
            case 6:
                color = "rgb(255,102,255)";
                break;
            case 3:
                color = "rgb(255,102,178)";
                break;
            case 12:
                color = "rgb(255,255,255)";
                break;
            case 13:
                color = "rgb(0,0,0)";
                break;
        }
        return color;
    }
    
    private String abrirArchivo() {
        jLabel1.setText("DATA DEL ARCHIVO");
        firstRun = false;
        Guardar.setVisible(true);
        texto = "";
        boolean enSeccionUsuarios = false;
        boolean enSeccionRelaciones = false;
        boolean formatoValido = false;

        try {
            fileChooser.showOpenDialog(this);
            File archivoSeleccionado = fileChooser.getSelectedFile();

            if (archivoSeleccionado != null) {
                FileReader archivo = new FileReader(archivoSeleccionado);
                BufferedReader lector = new BufferedReader(archivo);

                String linea;
                while ((linea = lector.readLine()) != null) {
                    if (linea.equals("usuarios")) {
                        enSeccionUsuarios = true;
                        enSeccionRelaciones = false;
                        formatoValido = true;
                        texto += linea + "\n"; 
                        continue; 
                    } else if (linea.equals("relaciones")) {
                        enSeccionUsuarios = false;
                        enSeccionRelaciones = true;
                        formatoValido = true;
                        texto += linea + "\n";
                        continue; 
                    }

                    if (enSeccionUsuarios && linea.startsWith("@")) {
                        texto += linea + "\n";
                    } else if (enSeccionRelaciones && linea.matches("@\\w+, @\\w+")) {
                        texto += linea + "\n";
                    } else {
                        formatoValido = false;
                        break;
                    }
                }

                lector.close();
            }

            if (!formatoValido) {
                JOptionPane.showMessageDialog(null,
                    "Error: El archivo no cumple con el formato requerido.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
                texto = "";
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" +
                "\nNo se ha encontrado el archivo",
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    private Graph iniciarGrafo(){ 
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
        
//
        Graph grafo = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        
        grafo.setAttribute("ui.stylesheet", 
                "node{\n"                   + 
                "size: 30px, 30px;\n"       +
                "fill-color: #ff0000;\n"    +
                "text-mode: normal;\n"      +
                "}");
//

        //esto es un print de que hay en cada grupo, pero sirve para acceder a cada dato dentro del grupo
        for (int i = 0; i < groupNum; i++) {
            System.out.print("Grupo "+(i+1)+": ");
            int[] specGroup = (int[]) stronglyConnected.searchPos(i);
            for (int x : specGroup) {
                String currentUsrID = dataUsr[x];
                //aqui se modifica lo que se va a hacer para cada item en el grupo
                if (specGroup.length < 2){
                    grafo.addNode(currentUsrID).setAttribute("ui.label", currentUsrID);
                    grafo.getNode(currentUsrID).setAttribute("ui.style", "fill-color: rgb(255,102,102);");
                    System.out.print("|" + x + " " + currentUsrID +"|");
                }else{
                    grafo.addNode(currentUsrID).setAttribute("ui.label", currentUsrID);
                    grafo.getNode(currentUsrID).setAttribute("ui.style", "fill-color: " + getColor() + ";");
                    System.out.print("|" + x + " " + currentUsrID +"|");
                }
              
            }
            System.out.println();

            if (currentGroup != lastGroup){         
            lastRGB++;
            }
            lastGroup = currentGroup;
            currentGroup++;
        }
        
        for (int i = 0; i < dataFollow.length; i++) {
            String tempFollow = dataFollow[i];
//            System.out.println(tempFollow);
            String followArray[] = tempFollow.split(", ");
//            System.out.println(followArray[0]);
//            System.out.println(followArray[1]);
            grafo.addEdge(followArray[0] + "_" + followArray[1], followArray[0], followArray[1]);
        }
        
        return grafo;
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
    
    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {                                      
        String archivo=abrirArchivo();
        jTextArea1.setText(archivo);
    }                                     

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        guardarArchivo();
    }                                       

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Graph grafo = iniciarGrafo();
        this.setVisible(true);
//        Graph grafo = MostrarGrafo();
        grafo.display();
//        String archivo = abrirArchivo();
        GraphMenu ventana2 = new GraphMenu(grafo, this.getData());
        ventana2.setVisible(true);

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
