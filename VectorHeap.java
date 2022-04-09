/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de datos
 * Hoja de trabajo 7
 * Sofi Lam 21548
 * Daniel Gómez 21429
 * Grupo 2
 */
public class VectorHeap<E extends Comparable<E>> implements iPriorityQueue<E>{
    private Paciente[] theheap;
    private int e_array = 0;

// Se crea el método que asegura que la raíz sea menor que cada hijo
public void HeapTheArray(int index){
    int hojamenor;
    Paciente root= theheap[index];
    while(index<e_array/2){
        //obtener indice del hijo de la izquierda
        int left=2*index+1;
        int right= left+1;
        //Si el hijo de la izquierda es menor que el de la derecha, se guarda el de la izquierda como el menor
        //No se como arreglar esto :(
        if((right >= e_array) && (theheap[left].compareTo(theheap[right]))){ 
            
            //el código del video:
            /**
             * public void heapTheArray(int index) 
             * int largestChild;
             * Data3 root = theHeap[index];
             * while (index < itemsInArray / 2) {
             * / Get the index for the leftChild
             * int leftChild = 2 * index + 1;
             * // Get the index for the rightChild
             * int rightChild = leftChild + 1;
             * // If leftChild is less then rightChild
             * // save rightChild in largestChild
             * if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key) {
             * System.out.println("Put Value " + theHeap[rightChild]
             *  + " in largestChild");
             * largestChild = rightChild;
             * } else {
             * System.out.println("Put Value " + theHeap[leftChild]
             * + " in largestChild")
             * Otherwise save leftChild in largestChild
             * largestChild = leftChild; }
             *  // If root is greater then the largestChild
             *  // jump out of while
             * if (root.key >= theHeap[largestChild].key)
             *                 break;
             * System.out.println("Put Index Value " + theHeap[largestChild]
             *     + " in Index " + index);
             * // Save the value in largest child into the top
             * // index
             * theHeap[index] = theHeap[largestChild];
             * index = largestChild;
             * System.out.println();
             *  printTree2(4);
             *  System.out.println(); }
             * theHeap[index] = root;}*/
        }
    }
}

//Se crea el método para agregar una nueva hoja al árbol
    public void insert(int i, Paciente patient){
        theheap[i]= patient;
    }
    //Se crea el método para agrandar el largo del arbol
    public void itemsarray(){
        e_array ++;
    }
    
    //Se crea para eliminar una hoja
    public Paciente pop(){
        if(e_array !=0){
            Paciente root = theheap[0];
            theheap[0]=theheap[--e_array];
            // agregar método heapthearray
            HeapTheArray(0);
            return root;
        }
        return null;
    }
    @Override
    public E getFirst() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void add(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    private void shiftDown(){

    }

    private void shiftUp(){

    }
    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }
    
}


