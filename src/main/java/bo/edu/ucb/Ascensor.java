package bo.edu.ucb;

public class Ascensor {
    private String direccion ;
    private int pisoActual;
    private int pisoDestino;
    private boolean ascensorOcupado = false;

    public Ascensor() {
        this.direccion = "arriba";
        this.pisoActual = 1;
        this.pisoDestino = 1;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public int CrearPersona() throws Exception {
        return (int) (Math.random() * 3 + 1);
    }

    public void MoverAscensor (int pisoDestino) throws Exception {
        if (this.pisoActual == pisoDestino) {
            return;
        }
        if (pisoDestino < 1 || pisoDestino > 3) {
            throw new Exception("El piso destino no es valido");
        }
        if (this.pisoActual > pisoDestino) {
            this.direccion = "abajo";
        }
        if (this.pisoActual < pisoDestino) {
            this.direccion = "arriba";
        }
        this.pisoDestino = pisoDestino;
        // Mover el ascensor
        this.pisoActual = pisoDestino;
    }

    public void LlamarAscensor (int pisoPersona) throws Exception {
        if (ascensorOcupado) {
            return;
        }
        MoverAscensor(pisoPersona);
    }

    public void EntrarPersona() {
        if (!ascensorOcupado) {
            ascensorOcupado = true;
        }
    }

    public void SalirPersona() {
        if (ascensorOcupado) {
            ascensorOcupado = false;
        }
    }
}
