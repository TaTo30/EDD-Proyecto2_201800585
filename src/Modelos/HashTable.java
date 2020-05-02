
package Modelos;


public class HashTable<T> {
    
    private final int Size;
    private int n;
    private final List<T>[] Elementos;
    
    
    private int Funcion(int clave){
        return clave%Size;
    }
    
    public HashTable(int size){
        this.Size = size;
        this.n = 0;
        Elementos = new List[size];        
        for (int i = 0; i < Elementos.length; i++) {
            Elementos[i] = null;
        }
    }

    public int Size(){
        return n;
    }
    
    public void Insertar(int clave, T objeto){
        int indice = Funcion(clave);
        if (Elementos[indice] != null) {
            Elementos[indice].AddLast(objeto, clave);
            n++;
        }else{
            Elementos[indice] = new List<>();
            Elementos[indice].AddLast(objeto, clave);
            n++;
        }        
    }
    
    public void Eliminar(int clave){
        int indice = Funcion(clave);
        if (Elementos[indice] != null) {
            Elementos[indice].RemoveKey(clave);
            n--;
        }
        
        if (!Elementos[indice].Contain()) {
             Elementos[indice] = null;
        }
    }
    
    public T Obtener(int clave){
        int indice = Funcion(clave);
        if (Elementos[indice] != null) {
            return Elementos[indice].ElementKey(clave);
        }else{
            return null;
        }
    }
    
    
    
    
}
