package problema2;

public class NotificacionCorreo extends Notificacion{
    public NotificacionCorreo(String destinatario, String mensaje) {
        super(destinatario, mensaje, "Correo electrónico");
    }

    @Override
    public boolean enviar() {
        String correo = getDestinatario();
        int posArroba = correo.indexOf("@");
        return posArroba > 0 && correo.indexOf(".", posArroba) > posArroba + 1
                && !correo.endsWith(".");
    }

    @Override
    public String obtenerError() {
        return "correo electrónico inválido";
    }
}
