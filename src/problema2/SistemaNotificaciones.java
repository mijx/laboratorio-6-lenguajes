package problema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SistemaNotificaciones {
    private BufferedReader br;

    public SistemaNotificaciones() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String leerLinea() {
        try {
            String linea = br.readLine();
            if (linea == null) {
                return "";
            }
            return linea;
        } catch (IOException e) {
            System.out.println("Error al leer los datos.");
            return "";
        }
    }

    private void mostrarMenu() {
        System.out.println("=== SISTEMA DE NOTIFICACIONES ===");
        System.out.println("1. Enviar por correo electrónico");
        System.out.println("2. Enviar por mensaje de texto (SMS)");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        String texto = leerLinea();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Notificacion crearNotificacion(int opcion) {
        System.out.print("Destinatario: ");
        String destinatario = leerLinea();

        System.out.print("Mensaje: ");
        String mensaje = leerLinea();

        Notificacion notificacion;
        if (opcion == 1) {
            notificacion = new NotificacionCorreo(destinatario, mensaje);
        } else {
            notificacion = new NotificacionSMS(destinatario, mensaje);
        }
        return notificacion;
    }

    public void ejecutar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            if (opcion == 1 || opcion == 2) {
                Notificacion notificacion = crearNotificacion(opcion);
                notificacion.mostrarResultado();
                System.out.println();
            } else if (opcion != 3) {
                System.out.println("Opción inválida, intente de nuevo.\n");
            }

        } while (opcion != 3);

        System.out.println("Programa finalizado.");

        try {
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar la lectura de datos.");
        }
    }
}
