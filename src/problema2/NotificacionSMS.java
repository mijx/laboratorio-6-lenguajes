package problema2;

public class NotificacionSMS extends Notificacion{
    private String error = "";

    public NotificacionSMS(String destinatario, String mensaje) {
        super(destinatario, mensaje, "Mensaje de texto (SMS)");
    }

    @Override
    public boolean enviar() {
        if (!getDestinatario().matches("[0-9]{7,15}")) {
            error = "número de teléfono inválido";
            return false;
        }
        if (getMensaje().length() > 160) {
            error = "el mensaje supera los 160 caracteres";
            return false;
        }
        return true;
    }

    @Override
    public String obtenerError() {
        return error;
    }
}
