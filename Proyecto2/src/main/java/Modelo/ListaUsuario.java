/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.EstructuraDeDatos;
/**
 *
 * @author fi944
 */
public class ListaUsuario extends EstructuraDeDatos {
    private NodoLS primero;
    private NodoLS ultimo;
    private int tamanio;

    public ListaUsuario(){
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public NodoLS getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLS primero) {
        this.primero = primero;
    }

    public NodoLS getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLS ultimo) {
        this.ultimo = ultimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public boolean Vacio() {
        return primero == null && ultimo == null;
    }

    @Override
    public String toString() {
        return "ListaUsuario{" + "primero=" + primero + ", ultimo=" + ultimo + ", tamanio=" + tamanio + '}';
    }
    
    // Agregar elemento a la lista
    @Override
    public void add(Object e) {
        NodoLS nuevo = new NodoLS((Usuario) e, primero);
        primero = nuevo;
        if ( ultimo == null ) {
            ultimo = primero;
        }
        tamanio++;
    }
    
    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Object find(Object e) {
        String userToValidate = (String) e;
        NodoLS aux = primero;
       
        boolean encontrado = false;
       
        while(aux != null && encontrado != true){
            if(userToValidate.equals(aux.getUser().getNombre())){
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
       }
       return encontrado;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int getSize() {
        return tamanio;
    }

    @Override
    public Object get(int i) {
        int e = 0;
        NodoLS aux = primero;
        
        while(aux != null){
            if(e == i){
                return aux;
            } else{
                aux = aux.getSiguiente();
            }
            e++;
        }
        return null;
    }

    @Override
    public void pop() {
        if(!Vacio()){
            if(primero==ultimo){
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
            }
            tamanio--;
        }
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
