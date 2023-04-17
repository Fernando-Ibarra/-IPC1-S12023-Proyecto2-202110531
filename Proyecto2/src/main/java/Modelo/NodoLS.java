/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fi944
 */
public class NodoLS {
    private Usuario user;
    private NodoLS siguiente;

    // Insertar Inicio
    public NodoLS(Usuario user, NodoLS siguiente) {
        this.user = user;
        this.siguiente = siguiente;
    }
    
    public NodoLS(Usuario user){
        this.user = user;
        this.siguiente = null;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public NodoLS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLS siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoLS{" + "user=" + user.getNombre() + ", siguiente=" + siguiente + '}';
    }
    
    
}
