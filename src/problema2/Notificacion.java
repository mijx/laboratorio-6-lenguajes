package problema2;

public abstract class Notificacion {
    private String destinatario;
    private String mensaje;
    private String tipo;

    public Notificacion(String destinatario, String mensaje, String tipo) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract boolean enviar();

    public abstract String obtenerError();

    public void mostrarResultado() {
        boolean exito = enviar();

        System.out.println();
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Tipo de notificación: " + tipo);

        if (exito) {
            System.out.println("Estado: Notificación enviada correctamente");
        } else {
            System.out.println("Estado: Error al enviar la notificación (" + obtenerError() + ")");
        }
    }
}
