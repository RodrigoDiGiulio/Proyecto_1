/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package JFileChooserClasses;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import projecto_1.Classes.DataInterpreter;
import projecto_1.Classes.Stack;
import projecto_1.Classes.AdjMatrix;
import projecto_1.Classes.List;
import projecto_1.Classes.DataInterpreter;

/**
 * Esta clase frame es la que se encarga de hacer toda la parte de interfaz para ejecutar el grafo
 * esta basada en la libreria de JFileChooser de Cristian Henao
 * @author RDG
 * @version 10/20/2023
 */
public class Frame extends JFrame implements ActionListener{
    
    private Container contenedor;
    JLabel labelTitulo;/*declaramos el objeto Label*/
    JTextArea areaDeTexto;
    JButton botonAbrir;/*declaramos el objeto Boton*/
    JButton botonGuardar;/*declaramos el objeto Boton*/
    JButton botonIniciar;/*declaramos el objeto Boton*/
    JScrollPane scrollPaneArea;
    JFileChooser fileChooser; /*Declaramos el objeto fileChooser*/
    String texto;
    boolean firstRun = true;

    //constructor
    public Frame(){
        contenedor = getContentPane();
        contenedor.setLayout(null);

        /*Creamos el objeto*/
        fileChooser=new JFileChooser();

        /*Propiedades del Label, lo instanciamos, posicionamos y
         * activamos los eventos*/
        labelTitulo= new JLabel();
        labelTitulo.setText("COMPONENTE JFILECHOOSER");
        labelTitulo.setBounds(110, 20, 180, 23);

        areaDeTexto = new JTextArea();
        //para que el texto se ajuste al area
        areaDeTexto.setLineWrap(true);
        //permite que no queden palabras incompletas al hacer el salto de linea
        areaDeTexto.setWrapStyleWord(true);
        scrollPaneArea = new JScrollPane();
        scrollPaneArea.setBounds(20, 50, 350, 270);
        scrollPaneArea.setViewportView(areaDeTexto);

        /*Propiedades del boton, lo instanciamos, posicionamos y
         * activamos los eventos*/
        botonAbrir= new JButton();
        botonAbrir.setText("Abrir");
        botonAbrir.setBounds(50, 330, 80, 23);
        botonAbrir.addActionListener(this);

        botonGuardar= new JButton();
        botonGuardar.setText("Guardar");
        botonGuardar.setBounds(150, 330, 80, 23);
        botonGuardar.addActionListener(this);
        
        botonIniciar = new JButton();
        botonIniciar.setText("Iniciar");
        botonIniciar.setBounds(250, 330, 80, 23);
        botonIniciar.addActionListener(this);

        /*Agregamos los componentes al Contenedor*/
        contenedor.add(labelTitulo);
        contenedor.add(scrollPaneArea);
        contenedor.add(botonAbrir);
        contenedor.add(botonGuardar);
        contenedor.add(botonIniciar);
        //Asigna un titulo a la barra de titulo
        setTitle("CoDejaVu : Ventana JFileChooser");
        //tamano de la ventana
        setSize(400,400);
        //pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    @Override
    public void actionPerformed(ActionEvent evento) {
            if (evento.getSource()==botonAbrir)
            {
                    String archivo=abrirArchivo();
                    areaDeTexto.setText(archivo);
            }

            if (evento.getSource()==botonGuardar)
            {
                    guardarArchivo();
            }
            if (evento.getSource()==botonIniciar)
            {
                    iniciarGrafo();
            }
    }

    /**
     * Permite mostrar la ventana que carga 
     * archivos en el area de texto
     * @return
     */
    private String abrirArchivo() {

            String aux=""; 		
            texto="";

            try
            {
                    /*llamamos el metodo que permite cargar la ventana*/
            fileChooser.showOpenDialog(this);
            /*abrimos el archivo seleccionado*/
                    File abre = fileChooser.getSelectedFile();

                    /*recorremos el archivo, lo leemos para plasmarlo
                     *en el area de texto*/
                    if(abre!=null)
                    { 				
                            FileReader archivos=new FileReader(abre);
                            BufferedReader lee=new BufferedReader(archivos);
                            while((aux=lee.readLine())!=null)
                                    {
                                     texto+= aux+ "\n";
                                    }

                            lee.close();
                    } 			
            }
            catch(IOException ex)
            {
              JOptionPane.showMessageDialog(null,ex+"" +
                            "\nNo se ha encontrado el archivo",
                            "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
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

    /**
     * Guardamos el archivo del area 
     * de texto en el equipo
     */
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
                            save.write(areaDeTexto.getText());
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
}