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
    private String[] follow;

    public socialUser(String socialUsername, String[] follow) {
        this.socialUsername = socialUsername;
        this.follow = follow;
    }

    public String getSocialUsername() {
        return socialUsername;
    }

    public void setSocialUsername(String socialUsername) {
        this.socialUsername = socialUsername;
    }

    public String[] getFollow() {
        return follow;
    }

    public void setFollow(String[] follow) {
        this.follow = follow;
    }
    
    
    
}
