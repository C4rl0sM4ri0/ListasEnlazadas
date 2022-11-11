/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalistasenlazadas;

import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett Packard
 */
public class ListaEnlazada {
    
    private Nodo cabeza;
    
    public ListaEnlazada(){         
        cabeza = null;
    } 
    
    public void setCabeza(Nodo cab){ 
        cabeza = cab; 
    }
    
    public Nodo getCabeza(){ 
        return cabeza; 
    }
    
    public Nodo ultimo(){         
        Nodo temp = cabeza;         
        while(temp != null){                
        if(temp.getSiguiente() == null){                 
            break;
        }
         else{                   
                temp = temp.getSiguiente();  
            } 
        } 
        return temp; 
    }  
     
    public int contarNodos(){         
        int contador = 0;
        Nodo temp = cabeza;         
        while(temp != null){             
            contador++;
         
            temp = temp.getSiguiente(); 
        } 
        return contador; 
    }
    
    public void agregar(Nodo nuevo){         
        if(cabeza == null){         
            setCabeza(nuevo);
        }else{ 
            ultimo().setSiguiente(nuevo);
        } 
    }
    
        public Nodo buscar(int cod){         
            Nodo temp = cabeza;         
            while(temp != null){ 
            if(temp.getCodigo() == cod){             
                break;             
            }else{ 
                temp = temp.getSiguiente(); 
            } 
        } 
        return temp; 
    }
        
        public void eliminar(Nodo nd){
            Nodo anterior;         
            if(nd == cabeza){         
                cabeza = cabeza.getSiguiente(); 
            }else{
            anterior = cabeza;             
            while(anterior.getSiguiente() != nd){                 
                anterior = anterior.getSiguiente(); 
            }           
                anterior.setSiguiente(nd.getSiguiente()); 
        }
        nd.setSiguiente(null);
    } 

        public float promedioGeneral(){ 
            int cantidad = 0;         
            float suma = 0;         
            Nodo temp = cabeza;         
        while(temp != null){             
            cantidad++; 
            suma = suma + temp.definitiva();             
            temp = temp.getSiguiente(); 
        } 
        if(cantidad > 0)             
            return suma/cantidad;         
        else 
            return 0; 
    }
        
        public float maximaDefinitiva(){ 
            float def, max;         
            max = 0; 
            Nodo temp = cabeza;         
        while(temp != null){             
            def = temp.definitiva(); 
        if(def > max){ 
            max = def; 
        } 
            temp = temp.getSiguiente(); 
        }
        return max; 
        }
        
        public void limpiar(){         
        while(cabeza != null){             
            eliminar(cabeza); 
        } 
    }
        public void Ordenamiento() { 
            Nodo ni;
            Nodo nj;
            ni = cabeza;

            while(ni != null){
                nj = ni.getSiguiente();
            while(nj != null){
                if(ni.definitiva() < nj.definitiva()){
                    cambiar(ni,nj);
                }
             nj = nj.getSiguiente();
            }
            ni = ni.getSiguiente(); 
        }
    }
        
        public void cambiar(Nodo p1, Nodo p2){
            
            Nodo temp = new Nodo();
            temp.copiar(p1);
            p1.copiar(p2);
            p2.copiar(temp);
        }
        
        public boolean parOimpar(int tam){
            
            
            return tam % 2 == 0;
        }
        
        public void eliminarParOImpar(int tam){
            
            Nodo temp = cabeza;
            Nodo eliminar = cabeza;
            Nodo anterior;
            int contadorSecundario = 1;
            
            while(temp != null) {
                boolean espar = parOimpar(contarNodos());
                if(espar) {
                    if(contadorSecundario % 2 == 0) {
                        eliminar(temp);
                    }
                }
                else {
                    if(contadorSecundario % 2 != 0) {
                        eliminar(temp);
                        
                    }

                }
                contadorSecundario++;
                temp = temp.getSiguiente();
            }
        }
        
        public void insertarAlPrincipio(int cont, Nodo aux){
            
        if(cont >= 2){
	aux.setSiguiente(cabeza);
	cabeza = aux;
        }else {
            JOptionPane.showMessageDialog(null, "Este es el principio de la lista o la Lista de Estudiantes esta vacia");
            JOptionPane.showMessageDialog(null, "Porfavor eliga una opcion 1 del Menu...");
        }
    }
        
        public void insertarEntreDos(int cont, Nodo aux){
            
            Nodo siguiente = cabeza.getSiguiente();
            
            if (cont >= 2){
                cabeza.setSiguiente(aux);
                aux.setSiguiente(siguiente);
            }else{
                JOptionPane.showMessageDialog(null, "Solo hay un numero en la lista o la Lista de Estudiantes esta vacia");
            JOptionPane.showMessageDialog(null, "Por favor eliga una opcion 1 del Menu...");
            }
        }
        
        public void invertirLista() {
            
            Nodo aux = cabeza, temp = null;
            while (aux.getSiguiente() != null) {
            temp = aux.getSiguiente();
            aux.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(cabeza);
            cabeza = temp;
        }
    }
        
        
}
