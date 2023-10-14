/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 * Esta es la clase socialUserEdge, que es la que se encarga de ver las
 * conexiones entre usuario A y usuario B.
 * A ->  B
 * A <-  B
 * A <-> B
 * A <!> B
 * @author RDG
 * @version 10/14/2023
 */
public class socialUserEdge {
    //Atributos
    private String startUserEdge;
    private String endUserEdge;
    private boolean isLinear;

    public socialUserEdge(String startUserEdge, String endUserEdge, boolean isLinear) {
        this.startUserEdge = startUserEdge;
        this.endUserEdge = endUserEdge;
        this.isLinear = isLinear;
    }    
    
    
    
}
