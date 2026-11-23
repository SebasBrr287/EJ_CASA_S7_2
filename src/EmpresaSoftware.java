// EmpresaSoftware.java (Agregación con Proyecto)
import java.util.ArrayList;

public class EmpresaSoftware {
    private String nombre;
    private ArrayList<Proyecto> proyectos;

    public EmpresaSoftware(String nombre) {
        this.nombre = nombre;
        this.proyectos = new ArrayList<>();
    }

    public void agregarProyecto(Proyecto proyecto) {
        if (proyecto != null) {
            proyectos.add(proyecto);
        }
    }

    public Proyecto buscarProyecto(String codigo) {
        for (Proyecto p : proyectos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProyecto(String codigo) {
        Proyecto encontrado = buscarProyecto(codigo);
        if (encontrado != null) {
            return proyectos.remove(encontrado);
        }
        return false;
    }

    public double calcularPresupuestoTotal() {
        double total = 0;
        for (Proyecto p : proyectos) {
            total += p.getPresupuesto();
        }
        return total;
    }

    public String mostrarProyectos() {
        if (proyectos.isEmpty()) {
            return "La empresa no tiene proyectos asignados.";
        }
        StringBuilder sb = new StringBuilder("Proyectos de " + nombre + ":\n");
        for (Proyecto p : proyectos) {
            sb.append(" * ").append(p.obtenerInfo()).append("\n");
        }
        return sb.toString();
    }

    // Desafío: Retorna el proyecto de mayor presupuesto
    public Proyecto obtenerProyectoMayorPresupuesto() {
        if (proyectos.isEmpty()) return null;
        Proyecto mayor = proyectos.get(0);
        for (Proyecto p : proyectos) {
            if (p.getPresupuesto() > mayor.getPresupuesto()) {
                mayor = p;
            }
        }
        return mayor;
    }
}