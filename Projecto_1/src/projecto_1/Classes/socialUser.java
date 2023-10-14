/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 * Esta es la clase socialUser, que se encarga de tener la data del usuario,
 * tanto como se identifica comom a quien sigue
 * @author RDG
 * @version 10/14/2023
 */
public class socialUser {
    //Atributos
    private String socialUsername;
    private int[] follow;

    public socialUser(String socialUsername, int[] follow) {
        this.socialUsername = socialUsername;
        this.follow = follow;
    }

    public String getSocialUsername() {
        return socialUsername;
    }

    public void setSocialUsername(String socialUsername) {
        this.socialUsername = socialUsername;
    }

    public int[] getFollow() {
        return follow;
    }

    public void setFollow(int[] follow) {
        this.follow = follow;
    }
    
    
    
}
