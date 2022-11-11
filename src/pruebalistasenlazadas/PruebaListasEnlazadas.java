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
public class PruebaListasEnlazadas {
    
    public static void llenar(Nodo nod){ 
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante: "));         nod.setCodigo(cod); 
        String nom = JOptionPane.showInputDialog("Digite NOMBRE del Estudiante: ");         
        nod.setNombre(nom); 
        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 1:"));         
        nod.setNota1(n1); 
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 2:"));         
        nod.setNota2(n2); 
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 3:"));         
        nod.setNota3(n3); 
    }
    
    public static void mostrar(Nodo nod){         
        String datosNodo = "";
     
        datosNodo = datosNodo+String.valueOf("" + "CODIGO: " + nod.getCodigo()+ 
                "\n" + "NOMBRE: " + nod.getNombre()+
                "\n" + "NOTA 1: " + nod.getNota1() + 
                "\n" + "NOTA 2: " + nod.getNota2() + 
                "\n" + "NOTA 3: " + nod.getNota3() + 
                "\n" + "Definitiva: " + nod.definitiva() + "\n\n");
                JOptionPane.showMessageDialog(null, 
                    "=========== INFORMACÓN DE LOS NODOS DE LA LISTA =========== \n" + datosNodo); 
    }
    
    public static void listar(Nodo nod){ 
            Nodo temp = nod; 
        while(temp != null){             
            mostrar(temp); 
            temp = temp.getSiguiente(); 
        }     
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaEnlazada lis = new ListaEnlazada();
        
        int cod;         
        Nodo aux;
        int ContMenu = 0;
        
        JOptionPane.showMessageDialog(null, "bienvenido a la insdcriccion de estuciantes");
        
        
        do{
            ContMenu = Integer.parseInt(JOptionPane.
                    showInputDialog("=========== SELECCIONE UNA OPCIÓN DEL MENÚ =========== "+
                    "\n" + "1. Agregar un Nodo a la Lista" +
                    "\n" + "2. Mostrar Nodos de la Lista" +
                    "\n" + "3. Cantidad de Nodos de la Lista" +
                    "\n" + "4. Buscar la Información de un estudiante" +
                    "\n" + "5. Eliminar Nodo de la Lista" +
                    "\n" + "6. Informe: Promedio General y Máxima Nota" +
                    "\n" + "7. Borrar toda la Lista" +
                    "\n" + "8. Borrar datos de la lista segun si es par o impar" +
                    "\n" + "9. Agregar un Nodo al principio de la lista" +
                    "\n" + "10. Agregar un Nodo al entre dos Nodos de la lista" +
                    "\n" + "11. Invertir lista" +
                    "\n" + "12. Ordenar Lista segun nota final (Mayor a Menor)" +
                    "\n" + "13. Salir"+ "\n \n Seleccione una opción del 1 al 10: "));
            
          switch(ContMenu){
            case 1:
                aux = new Nodo();
                llenar(aux);                 
                lis.agregar(aux); 
                break;
            case 2:
                if(lis.getCabeza() != null){                     
                    listar(lis.getCabeza());
                }else{ 
                  JOptionPane.showMessageDialog(null, "La Lista Está Vacía....");
                }
                break;
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "========= NÚMERO DE NODOS DE LA LISTA =========\n" 
                        + lis.contarNodos()+ " Nodos");                 
                break;             
            case 4:                  
                cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante a Buscar: ")); 
                aux = lis.buscar(cod); 
                if(aux != null){                     
                    mostrar(aux); 
                }else{ 
                    JOptionPane.showMessageDialog(null, "La información del estudiante No se encuentra en la lista"); 
                }
                break;
            case 5:
                cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante a Eliminar: ")); 
                aux = lis.buscar(cod);                 
                if(aux != null){                     
                    lis.eliminar(aux); 
                    JOptionPane.showMessageDialog(null, "La información fue eliminada correctamente...."); 
                }else{ 
                    JOptionPane.showMessageDialog(null, "El código del estudiante NO EXISTE en la Lista"); 
                }
                break;
            case 7:
                JOptionPane.showMessageDialog(null, 
                        "========= INFORME PROMEDIO GENERAL Y MÁXIMA NOTA  ========= \n\n" + 
                        "Promedio General: " + lis.promedioGeneral()
                        + "\n y Máxima Nota: " + lis.maximaDefinitiva());
                break;
            case 8:
                if (lis.parOimpar(lis.contarNodos())){
                    JOptionPane.showMessageDialog(null, "La lista de estudiantes es par...");
                }else {
                    JOptionPane.showMessageDialog(null, "La lista de estudiantes es impar...");
                }
                lis.eliminarParOImpar(lis.contarNodos());
            case 9:
                aux = new Nodo();
                llenar(aux);
                lis.insertarAlPrincipio(lis.contarNodos(), aux);
                break;
            case 10:
                aux = new Nodo();
                llenar(aux);
                lis.insertarEntreDos(lis.contarNodos(), aux);
                break;
            case 11:
                lis.invertirLista();
                JOptionPane.showMessageDialog(null, "La lista ha sido Invertida");
                break;
            case 12:
                lis.Ordenamiento();
                JOptionPane.showMessageDialog(null, "La lista ha sido Ordenada Correctamente");
                break;
            }
        }while(ContMenu != 13);
    }
}
