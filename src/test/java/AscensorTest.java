import bo.edu.ucb.Ascensor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AscensorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

//  Requerimiento 1: Estado Inicial del ascensor

    @Test
    public void elEstadoInicialDelAscensorDebeEstablecerseEnElPiso1() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Logica de la prueba
        int pisoActual = ascensor.getPisoActual();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(1, pisoActual);
    }

    @Test
    public void elEstadoInicialDelAscensorDebeEstablecerseConDireccionArriba() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Logica de la prueba
        String direccion = ascensor.getDireccion();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals("arriba", direccion);
    }

//  Requerimiento 2: Creacion de una persona

    @Test
    public void cuandoSeCreaUnaPersonaDeberiaEstarEnUnPisoAleatorioEntre1y3() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Logica de la prueba
        int pisoPersona = ascensor.CrearPersona();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertTrue(pisoPersona >= 1 && pisoPersona <= 3);
    }

//  Requerimiento 3: Llamada al ascensor
    @Test
    public void cuandoSeLlamaAlAscensorElPisoDestinoDeberiaSerElPisoEnElQueSeEncuentraLaPersona() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona = 3;
        // 2. Logica de la prueba
        ascensor.LlamarAscensor(pisoPersona);
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoPersona, ascensor.getPisoDestino());
    }

    @Test
    public void siElPisoDestinoNoEstaEntre1y3EntoncesLanzarExcepcion() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona = 4;
        // 2. Logica de la prueba

        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        exception.expect(Exception.class);
        ascensor.LlamarAscensor(pisoPersona);
    }

    @Test
    public void siLaPersonaSeEncuentraEnUnPisoSuperiorAlPisoActualDelAscensorEntoncesElAscensorDebeMoverseHaciaArriba() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona = 3;
        // 2. Logica de la prueba
        ascensor.LlamarAscensor(pisoPersona);
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals("arriba", ascensor.getDireccion());
    }

    @Test
    public void siLaPersonaSeEncuentraEnUnPisoInferiorAlPisoActualDelAscensorEntoncesElAscensorDebeMoverseHaciaAbajo() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        ascensor.MoverAscensor(3);
        // 2. Logica de la prueba
        int pisoPersona = 1;
        ascensor.LlamarAscensor(pisoPersona);
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals("abajo", ascensor.getDireccion());
    }

//    Requerimiento 4: Entrar al ascensor
    @Test
    public void siLaPersonaSeEncuentraEnElPiso1AlComenzarElDiaEntoncesLaPersonaPuedeEntrarAlAscensor() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoDestino = 3;
        // 2. Logica de la prueba
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino);
        ascensor.SalirPersona();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoDestino, ascensor.getPisoActual());
    }

    @Test
    public void siLaPersonaSeEncuentraEnElPiso2AlComenzarElDiaEntoncesLaPersonaDebeEsperarEnElPiso2HastaQueElAscensorLlegue() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona = 2;
        int pisoDestino = 3;
        // 2. Logica de la prueba
        ascensor.LlamarAscensor(pisoPersona);
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino);
        ascensor.SalirPersona();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoDestino, ascensor.getPisoActual());
    }

    @Test
    public void siLaPersonaSeEncuentraEnElPiso3AlComenzarElDiaEntoncesLaPersonaDebeEsperarEnElPiso3HastaQueElAscensorLlegue() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona = 3;
        int pisoDestino = 2;
        // 2. Logica de la prueba
        ascensor.LlamarAscensor(pisoPersona);
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino);
        ascensor.SalirPersona();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoDestino, ascensor.getPisoActual());
    }

    @Test
    public void siHayDosPersonasEsperandoAlAscensorEntoncesElAscensorDebeRecogerALaPrimeraPersonaQueLlamoAlAscensor() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona1 = 3;
        int pisoDestino1 = 1;
        int pisoPersona2 = 2;
        int pisoDestino2 = 1;
        // 2. Logica de la prueba
        ascensor.LlamarAscensor(pisoPersona1);
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino1);
        ascensor.SalirPersona();
        ascensor.LlamarAscensor(pisoPersona2);
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino2);
        ascensor.SalirPersona();
        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoDestino2, ascensor.getPisoActual());
    }

    @Test
    public void siHayDosPersonasEsperandoAlAscensorEntoncesElSegundoLlamadoDelAscensorDebeSerIgnorado() throws Exception {
        // 1. Preparacion de la prueba
        Ascensor ascensor = new Ascensor();
        int pisoPersona1 = 3;
        int pisoDestino1 = 1;
        int pisoPersona2 = 2;
        // 2. Logica de la prueba
        // La primera persona llama al ascensor y entra
        ascensor.LlamarAscensor(pisoPersona1);
        ascensor.EntrarPersona();
        ascensor.MoverAscensor(pisoDestino1);
        // La segunda persona llama al ascensor y espera
        ascensor.LlamarAscensor(pisoPersona2);
        ascensor.SalirPersona();

        // 3. Verificacion o assert (Asercion - verificacion de una condicion)
        assertEquals(pisoDestino1, ascensor.getPisoActual());
    }


}
