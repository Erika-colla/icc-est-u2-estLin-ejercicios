package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i); 
            pila.push(caracter);             
        }
        String cadenaInvertida = "";
        while (!pila.isEmpty()) {
            cadenaInvertida += pila.pop();
        }
        return cadenaInvertida;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else {
                if (pila.isEmpty()) {
                    return false;
                }

                char tope = pila.pop();
                if ((caracter == ')' && tope != '(') ||
                    (caracter == ']' && tope != '[') ||
                    (caracter == '}' && tope != '{')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> temporal = new Stack<>();
        while(!pila.isEmpty()){
            int actual = pila.pop();
            
            while (!temporal.isEmpty() && temporal.peek() > actual) {
                pila.push(temporal.pop());
            }
            temporal.push(actual);
        }
        
        // Transferir los elementos ordenados de temporal a la lista
        List<Integer> listaOrdenada = new ArrayList<>();
        while (!temporal.isEmpty()) {
            listaOrdenada.add(temporal.pop());
        }

        return listaOrdenada;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }
        
        List<Integer> resultado = new ArrayList<>();
        resultado.addAll(pares);
        resultado.addAll(impares);
        return resultado;
    }
}
