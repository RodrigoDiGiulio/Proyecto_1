/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 *
 * @author RDG
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

    public String getStartUserEdge() {
        return startUserEdge;
    }

    public void setStartUserEdge(String startUserEdge) {
        this.startUserEdge = startUserEdge;
    }

    public String getEndUserEdge() {
        return endUserEdge;
    }

    public void setEndUserEdge(String endUserEdge) {
        this.endUserEdge = endUserEdge;
    }

    public boolean getIsLinear() {
        return isLinear;
    }

    public void setIsLinear(boolean isLinear) {
        this.isLinear = isLinear;
    }
    
    
    
}
