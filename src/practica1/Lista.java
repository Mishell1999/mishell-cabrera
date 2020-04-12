package practica1;

public class Lista {


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Lista {
	public Nodo inicio = null;
	public int tamanio = 0;
	Scanner entrada = new Scanner(System.in);
	
	public boolean isVacia(){
		return tamanio == 0;
	}
	
	public void agregarNodoFIFO(Cliente informacionCliente){
		Nodo nodoTmp = new Nodo(informacionCliente, null);

		if(isVacia()){
			inicio = nodoTmp;
		}else{
			Nodo nodoTmp2 = inicio;
			while (nodoTmp2.siguiente!=null){
				nodoTmp2 = nodoTmp2.siguiente;
			}
			nodoTmp2.siguiente = nodoTmp;
		}
		tamanio++;

}


public void agregarNodoLIFO(Cliente informacionCliente){
	Nodo nodoTmp = new Nodo(informacionCliente, null);
	
	if(isVacia()){
		inicio = nodoTmp;
	}else{
		nodoTmp.siguiente = inicio;
		inicio = nodoTmp;
	}
	tamanio++;
}

public void imprimirLista(){
	Nodo nodoTmp = inicio;
	System.out.println("");
	System.out.println("");
	System.out.println("---------- IMPRESION DE LA LISTA ENLAZADA ----------");
	System.out.print("|" + nodoTmp.informacionNodo.nombre +"|->");
	while(nodoTmp.siguiente!=null){
		nodoTmp = nodoTmp.siguiente;
		System.out.print("|" + nodoTmp.informacionNodo.nombre +"|->");
	}
	System.out.print("null");
}
public void generarGrafo(){
	try{
		Nodo nodoTmp = inicio;
		
		BufferedWriter escritura = new BufferedWriter(new FileWriter("/Users/Mishell Cabrera/Desktop/Proyecto/graphviz-prueba/grafica1.gv"));
		
		escritura.write("digraph C {\n");
		escritura.write("  rankdir=LR;\n");
		escritura.write("  node [shape=box];\n");
		
		String lineaGraph= "  ";
		lineaGraph = lineaGraph + "\"" + nodoTmp.informacionNodo.nombre + "\" -> ";
		
		while(nodoTmp.siguiente!=null){
			nodoTmp = nodoTmp.siguiente;
			lineaGraph = lineaGraph + "\"" + nodoTmp.informacionNodo.nombre + "\" -> ";
		}
		lineaGraph = lineaGraph + "\"null\";\n";
		escritura.write(lineaGraph);
		escritura.write("}\n");
		escritura.close();
		System.out.println("Ya escribio lo solicitado en el archivo: /Users/Mishell Cabrera/Desktop/Proyecto/graphviz-prueba/gra");
	}catch(Exception e){
		e.printStackTrace();
	}
	
}


public void buscarElemento(String nombreCliente){
	Nodo nodoTmp = inicio;
	int contador = 0;
	boolean encontrado = false;
	while(nodoTmp.siguiente!=null){
		
		if(nodoTmp.informacionNodo.nombre.contains(nombreCliente)){
			System.out.println("Se encontro el cliente registrado: " + contador);
			encontrado = true;
		}
		
		nodoTmp = nodoTmp.siguiente;
		contador++;
	}
	
	if(!encontrado){
		System.out.println("No se encontro el Cliente");
	}
}

public void actualizarElementoLista(String nombreCliente){
	Nodo nodoTmp = inicio;
	int contador = 0;
	boolean encontrado = false;
	while(nodoTmp.siguiente!=null){
		
		if(nodoTmp.informacionNodo.nombre.contains(nombreCliente)){
			System.out.println("Se encontro el Cliente en el registro: " + contador);
			System.out.println("-----------------------------------");
			System.out.println("| Datos del cliente registrado:");
			System.out.println("| nombre: " + nodoTmp.informacionNodo.nombre);
			System.out.println("| nit: " + nodoTmp.informacionNodo.nit);
			System.out.println("| fecha_de_nacimiento: " + nodoTmp.informacionNodo.fecha_de_nacimiento);
			System.out.println("| Hora: " + nodoTmp.informacionNodo.Hora);
			System.out.println("| telefono: " + nodoTmp.informacionNodo.telefono);
			System.out.println("| placa: " + nodoTmp.informacionNodo.placa);
			
			System.out.println("-----------------------------------");
			System.out.println("Que dato desea actualizar?: 1-Nombre 2-NIT 3-fecha de nacimiento 4-Hora 5-Telefono 6-placa del vehiculo");
			int opcionA = entrada.nextInt();
			switch(opcionA){
			case 1:
				System.out.println("Ingrese el nuevo nombre del cliente: ");
				String newNombre= entrada.next();
				nodoTmp.informacionNodo.nombre = newNombre;
				break;
			case 2:
				System.out.println("Ingrese el nuevo nombre: ");
				int newNit= entrada.nextInt();
				nodoTmp.informacionNodo.nit = newNit;
				break;
			case 3:
				System.out.println("Ingrese la nueva fecha de nacimiento: ");
				int newFecha_de_nacimiento= entrada.nextInt();
				nodoTmp.informacionNodo.fecha_de_nacimiento =newFecha_de_nacimiento;
				break;
			case 4:
				System.out.println("Ingrese la nueva Hora: ");
				int newHora= entrada.nextInt();
				nodoTmp.informacionNodo.Hora = newHora;
				break;
			case 5:
				System.out.println("Ingrese el telefono nuevo del cliente: ");
				int newTelefono= entrada.nextInt();
				nodoTmp.informacionNodo.telefono = newTelefono;
				break;
				
			case 6:
				System.out.println("Ingrese la nueva placa del vehiculo: ");
				int newPlaca= entrada.nextInt();
				nodoTmp.informacionNodo.placa = newPlaca;
				break;
				
				
			}
			encontrado = true;
			System.out.println("El cliente se ha actualizado con exito!.");
		}
		
		nodoTmp = nodoTmp.siguiente;
		contador++;
	}
	
	if(!encontrado){
		System.out.println("No se encontro el cliente");
	}
}

public void eliminarElemento(String nombreCliente){
	Nodo nodoTmp = inicio;
	Nodo nodoAnterior = null;
	int contador = 0;
	boolean encontrado = false;
	while(nodoTmp.siguiente!=null){
		
		if(nodoTmp.informacionNodo.nombre.contains(nombreCliente)){
			System.out.println("Se encontro el cliente: " + contador);
			if(contador==0){
				Nodo eliminado = null;
				eliminado = inicio;
				inicio = inicio.siguiente;
				eliminado.siguiente = null;
				encontrado = true;
				break;
			}else{
				nodoAnterior.siguiente = nodoTmp.siguiente;
				encontrado = true;
				break;
			}
		}
		nodoAnterior = nodoTmp;
		nodoTmp = nodoTmp.siguiente;
		contador++;
	}
	
	if(!encontrado){
		System.out.println("No se encontro el cliente que desea eliminar");
	}
}


}



