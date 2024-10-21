package ServiciosYProcesos.src;
import java.util.concurrent.locks.ReentrantLock;

public class Ejecutor implements Runnable {
    private String nombre;

    public Ejecutor(String nombre) {
        this.nombre = nombre;
      
    }
    private static ReentrantLock cerrojo= new ReentrantLock();

    @Override
    public void run() {
        // ejecutar un contador q se incremente 1000 veces de uno en uno
        // y q muestre por pantalla cada 10 incrementos el valor del contador principal
        Contador miContador = new Contador();
        for (int i = 1; i < 1001; i++) {
            cerrojo.lock();
            Contador.incrementarContadorPrincipal();
            cerrojo.unlock();
            miContador.incrementarContadorIndividual();
            if (miContador.getContadorIndividual() % 10 == 0) {
                System.out.println("El ejecutor: " + this.nombre +
                        " ha incrementado el contador Principal hasta: " +
                        Contador.getContadorPrincipal() +
                        " y su contador  individual es: " +
                        miContador.getContadorIndividual());

            }

        }

    }

}
