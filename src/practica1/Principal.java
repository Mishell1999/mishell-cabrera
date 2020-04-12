package practica1;

public class Principal {


import java.util.Scanner;

public class Principal {
	
	public static void main(String []args){
		Lista miListaEnlazada = new Lista();
		Scanner entrada = new Scanner(System.in);	
		
		int opcion = 1;
		do{
			System.out.println("Por favor ingrese el nombre del cliente:");
			String newNombre= entrada.next();
			System.out.println("Ingrese el numero de NIT: ");
			int newNit= entrada.nextInt();
			System.out.println("Ingrese la fecha de nacimiento: ");
			int newFecha_de_nacimiento= entrada.nextInt();
			System.out.println("Ingrese la Hora de entrada: ");
			int newHora= entrada.nextInt();
			System.out.println("Ingrese el numero de telefono: ");
			int newTelefono= entrada.nextInt();
			System.out.println("Ingrese la placa del vehiculo: ");
			int newPlaca= entrada.nextInt();
			
			
			
			Cliente newCliente = new Cliente( newNombre, newNit, newFecha_de_nacimiento,newHora,newTelefono,newPlaca);
			
			miListaEnlazada.agregarNodoLIFO(newCliente);
			
			System.out.println("Desea ingrear otro cliente? 1.-SI, 2.-NO");
			opcion = entrada.nextInt();
			
		}while(opcion==1);
		
		String nombreCliente= "";		
		do{
			System.out.println("");
			System.out.println("---- REGISTRO -----");
			System.out.println("1.- Recorrer Lista");
			System.out.println("2.- Buscar el cliente registrado");
			System.out.println("3.- Actualizar el cliente ingresado");
			System.out.println("4.- Eliminar Cliente");
			System.out.println("5.- Generar Grafo");
			System.out.println("6.- Salir");	
			opcion = entrada.nextInt();
			switch(opcion){
			case 1:		
				miListaEnlazada.imprimirLista();
				break;
			case 2:
				System.out.println("Que Cliente de la lista desea buscar:");
				nombreCliente = entrada.next();
				miListaEnlazada.buscarElemento(nombreCliente);
				break;
			case 3:
				System.out.println("Que Cliente de la lista desea actualizar:");
				nombreCliente = entrada.next();
				miListaEnlazada.actualizarElementoLista(nombreCliente);
				break;
			case 4:
				System.out.println("Que Cliente de la lista desea eliminar:");
				nombreCliente = entrada.next();
				miListaEnlazada.eliminarElemento(nombreCliente);
				break;
			case 5:
				System.out.println("Se esta generando el archivo .gv para grafo");
				miListaEnlazada.generarGrafo(); 
				break;
			default:
				break;
			}
			System.out.println("");
		}while(opcion != 5);
	}


}
