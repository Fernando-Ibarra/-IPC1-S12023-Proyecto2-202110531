/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.EstructuraDeDatos;
import static Modelo.Utils.myImages;

/**
 *
 * @author fi944
 */
public class ListaImagenes extends EstructuraDeDatos {
    
    private int tam;
    private NodoLD cabeza;
    private NodoLD cola;
    
    // Constructor que crea una lista vacia
    public ListaImagenes(){
        tam = 0;
        cabeza = new NodoLD(null, null, null);
        cola = new NodoLD(null, cabeza, null);
        cabeza.setSiguiente(cola);
    }

    public NodoLD getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoLD cabeza) {
        this.cabeza = cabeza;
    }

    public NodoLD getCola() {
        return cola;
    }

    public void setCola(NodoLD cola) {
        this.cola = cola;
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
    
    public int getTam() {
        return tam;
    }    

    public boolean estaVacia() {
        return tam == 0;
    }

    @Override
    public String toString() {
        String s = "[";
        NodoLD v = cabeza.getSiguiente();
        int i = 1;
        while(v != cola ){
            s+= i + " path: " + v.getImg().getPath() + " usuario: " + v.getImg().getCategoria().getUser().getNombre() + " Categoria: " + v.getImg().getCategoria().getCategoria();
            v = v.getSiguiente();
            if(v != cola){
                s += ", ";
                i++;
            }
        }
        s += "]";
        return s;
    }

    public String toString2() {
        String s = "[";
        NodoLD v = cabeza.getSiguiente();
        int i = 1;
        while(v != cola ){
            s+= i + " - " + v;
            v = v.getSiguiente();
            if(v != cola){
                s += ", ";
                i++;
            }
        }
        s += "]";
        return s;
    }  

    
    public void AgregarAntes(NodoLD v, NodoLD z){
        NodoLD u = v.getAnterior();
        z.setAnterior(u);
        z.setSiguiente(v);
        v.setAnterior(z);
        u.setSiguiente(z);
        tam++;
    }
    
    public void borrar(NodoLD v){
        NodoLD u = v.getAnterior();
        NodoLD w = v.getSiguiente();
        w.setAnterior(u);
        u.setSiguiente(w);
        v.setAnterior(null);
        v.setSiguiente(null);
        tam--;
    }
    
    public NodoLD siguiente(NodoLD v) {
        if(v == cola) {
            return v;
        } else {
            return v.getSiguiente();
        }
    }
    
    // Agregar al último
    @Override
    public void add(Object e) {
        AgregarAntes(cola, (NodoLD) e);
    }

    @Override
    public Object peek() {
        if(estaVacia()){
            return "La lista esta vacía";
        } else {
            return cabeza.getSiguiente();
        }
    }

    @Override
    public Object find(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public Object getNext() {
        return false;
    }

    @Override
    public int getSize() {
        return getTam();
    }

    @Override
    public Object get(int i) {
        int e = 1;
        NodoLD aux = cabeza.getSiguiente();
        
        while(aux != null){
            if(e == i){
                return aux;
            } else {
                if(tieneSig(aux) || tienePrev(aux)){
                    aux = aux.getSiguiente();
                } else {
                    return null;
                }
            }
            e++;
        }
        return null;
    }  
    
    public NodoLD getNodo(String categoria){
        NodoLD aux = cabeza.getSiguiente();
        
        while(aux != null){
            String cate = aux.getImg().getCategoria().getCategoria();
            if(cate.equals(categoria)){
                return aux;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public boolean tienePrev ( NodoLD v) { return v != cabeza ; }

    public boolean tieneSig ( NodoLD v) { return v != cola ; }

    @Override
    public void pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        borrar((NodoLD) e);
    }

}
