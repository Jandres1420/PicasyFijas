package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * Clase encargada del back del juego PicasyFijas
 */
public class PicasyFijas {
    private List<Integer> numeroR;
    private static  PicasyFijas _instance = new PicasyFijas();
    private int picas, fijas;
    public static PicasyFijas getInstance(){
        return _instance;
    }
    /**
     * Singleton que genera la lista de numeros randoms que la persona
     * tiene que encontrar con picas y fijas
     */
    public PicasyFijas(){
        generateRandoms();
    }

    /**
     * convertir el metodo GET de String a un arreglo de Integer
     * @param input
     */
    public void convertir(String input){

        String[] numeros = input.split(",");
        Integer[] valores = new Integer[numeros.length];
        for(int i = 0; i < valores.length; i++){
            valores[i] = Integer.parseInt(numeros[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.<Integer>asList(valores));
        list.forEach(i -> System.out.println("numeros ingresados " + i));
        System.out.println("Este es el numero de fijas :" + numeroDeFijas(list));
        System.out.println("Este es el numero de picas :" +numeroDePicas(list));
        
        
    }
    /**
    *Genera la lista de numeros Randoms que tiene que descubrir el jugador 
    */
    public void generateRandoms(){
        numeroR = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i<4 ; i++){
            int numeroRandom = random.nextInt(9);
            while(numeroR.contains(numeroRandom)){
                numeroRandom = random.nextInt(9);
            }
            numeroR.add(numeroRandom);   
        }        
        numeroR.forEach(i->System.out.println(i));
    }
    /**
     * Clase que encuentra cuantas fijas hay dependiendo de la lista pasada
     * @param userList
     * @return
     */
    public int numeroDeFijas(ArrayList<Integer> userList){ 
        fijas = 0;
        for(int i = 0; i<userList.size();i++){
            if(userList.get(i)==numeroR.get(i)){
                fijas++;
            }
        }
    //    fijas = (int)userList.stream().filter(name -> name.equals(numeroR.forEach())).count();
        return fijas;
    }

    /**
     * Clase que encuentra las fijas segun la lista pasada
     * @param userList
     * @return
     */
    public int numeroDePicas(List<Integer> userList){
        picas = 0;
        for(int i = 0; i<userList.size();i++){
            if(numeroR.contains(userList.get(i)) && numeroR.get(i) != userList.get(i)){
                picas++;
            }
        }
      //  picas = (int)userList.stream().filter(name -> name.equals(numeroR.stream().iterator().next())).count();
        return picas;
    }

    /**
     * @return int picas, return the fijas
     */
    public int getPicas() {
        return picas;
    }

    /**
     * @param picas the fijas to set
     */
    public void setPicas(int picas) {
        this.picas = picas;
    }

    /**
     * @param fijas the fijas to set
     */
    public void setFijas(int fijas) {
        this.fijas = fijas;
    }

    /**
     * @return return the fijas
     */
    public int getFijas() {
        return fijas;
    }

    /**
     * @return List<Integer> return the numeroR
     */
    public List<Integer> getNumeroR() {
        return numeroR;
    }

    /**
     * @param numeroR the numeroR to set
     */
    public void setNumeroR(List<Integer> numeroR) {
        this.numeroR = numeroR;
    }

}
