/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 * La clase DataInterpreter, que se encarga de tene la data default
 * y de entender los archivos
 * @author RDG
 * @version 10/20/2023
 * @param <T>
 */
public class DataInterpreter {
    //Atributos
    private String dafaultData = "usuarios\n@pepe\n@mazinger\n@juanc\n@xoxojaime\n@tuqui33\n@sancho23\n@terciopelo\n@caribedoble\n@africa\n@totalfree\n@radiogaga\n@cipriano\n@newageforever\n\nrelaciones\n@pepe, @mazinger\n@mazinger, @juanc\n@mazinger, @tuqui33\n@tuqui33, @xoxojaime\n@xoxojaime, @pepe\n@juanc, @sancho23\n@sancho23, @mazinger\n@sancho23, @terciopelo\n@terciopelo, @newageforever\n@terciopelo, @caribedoble\n@caribedoble, @africa\n@africa, @cipriano\n@cipriano, @totalfree\n@cipriano, @radiogaga\n@totalfree, @africa\n@totalfree, @radiogaga\n@radiogaga, @caribedoble";
    private String data;

    public DataInterpreter() {
        this.dafaultData = dafaultData;
        this.data = data;
    }

    public List getDafaultData() {
        List retData = new List();
        String tempUsr[] = null;
        String tempFollow[] = null;
        String tempUsrString = "";
        String tempFollowString = "";
        dafaultData = dafaultData.replaceAll("usuarios\n","");
//        dafaultData = dafaultData.replaceAll("\nrelaciones\n","");
        String[] dataArray = dafaultData.split("\n\nrelaciones\n");
        tempUsrString = dataArray[0];
        tempFollowString = dataArray[1];
        tempUsr = tempUsrString.split("\n");
        tempFollow = tempFollowString.split("\n");
//        for (String x : tempUsr) {
//            System.out.println(x);
//        }
//        for (String x : tempFollow) {
//            System.out.println(x);
//        }
        retData.addStart(tempUsr);
        retData.addEnd(tempFollow);
        return retData;
    }

    public List getData(){
        List retData = new List();
        String tempUsr[] = null;
        String tempFollow[] = null;
        String tempUsrString = "";
        String tempFollowString = "";
        data = data.replaceAll("usuarios\n","");
        String[] dataArray = data.split("\n\nrelaciones\n");
        tempUsrString = dataArray[0];
        tempFollowString = dataArray[1];
        tempUsr = tempUsrString.split("\n");
        tempFollow = tempFollowString.split("\n");
//        for (String x : tempUsr) {
//            System.out.println(x);
//        }
//        for (String x : tempFollow) {
//            System.out.println(x);
//        }
        retData.addStart(tempUsr);
        retData.addEnd(tempFollow);
        return retData;
    }

    public void setData(String data){
        this.data = data;
    }
}
