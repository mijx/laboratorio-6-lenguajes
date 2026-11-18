package problema1;

public class Hemoglobina extends Examen{
    public Hemoglobina(Afiliado paciente) {
        super("problema1.Hemoglobina Glicosilada", paciente);
    }

    @Override
    public double precioAPagar() {
        return 20.0*porcentajePago();
    }
}
