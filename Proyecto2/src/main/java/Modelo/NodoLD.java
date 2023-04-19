/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fi944
 */
public class NodoLD {
    
    private Imagen img;
    private NodoLD anterior;    
    private NodoLD siguiente;

    public NodoLD(Imagen img, NodoLD anterior, NodoLD siguiente) {
        this.img = img;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public Imagen getImg() {
        return img;
    }

    public void setImg(Imagen img) {
        this.img = img;
    }

    public NodoLD getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLD anterior) {
        this.anterior = anterior;
    }

    public NodoLD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLD siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    // Constructor para cuando aun no hay nodos
    public NodoLD(Imagen img){
        this.img = img;
        this.siguiente = null;
        this.anterior = null;
    }

}
