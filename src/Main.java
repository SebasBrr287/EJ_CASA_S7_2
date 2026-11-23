//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Nombre de la empresa: ");
    EmpresaSoftware empresa = new EmpresaSoftware(sc.nextLine());

    System.out.print("¿Cuántos proyectos deseas agregar?: ");
    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
        System.out.println("\nProyecto #" + (i + 1));
        System.out.print("Código: ");
        String cod = sc.nextLine();
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Presupuesto: ");
        double pres = Double.parseDouble(sc.nextLine());

        Proyecto p = new Proyecto(cod, nom, pres);
        empresa.agregarProyecto(p);
    }

    System.out.println("\n" + empresa.mostrarProyectos());
    System.out.println("Presupuesto total: $" + String.format("%.2f", empresa.calcularPresupuestoTotal()));

    Proyecto mayor = empresa.obtenerProyectoMayorPresupuesto();
    System.out.println("Mayor presupuesto: " + (mayor != null ? mayor.obtenerInfo() : "Ninguno"));

    System.out.print("\nCódigo de proyecto a buscar: ");
    Proyecto buscado = empresa.buscarProyecto(sc.nextLine());
    System.out.println(buscado != null ? buscado.obtenerInfo() : "No encontrado.");

    System.out.print("Código de proyecto a eliminar: ");
    System.out.println("Eliminado: " + empresa.eliminarProyecto(sc.nextLine()));
    System.out.println("\n" + empresa.mostrarProyectos());
    sc.close();

}
