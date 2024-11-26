package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.Oferta;

public class SuperposicionTest {
	
	Oferta mismoHorario1,
	mismoHorario2,
	horarioDentroDelOtro1,
	horarioDentroDelOtro2,
	horarioTerminaDentroDelOtro1,
	horarioTerminaDentroDelOtro2,
	horarioEmpiezaDentroDelOtro1,
	horarioEmpiezaDentroDelOtro2;

    
    @Before 
    public void inicializar() throws Exception {
        mismoHorario1 = new Oferta("Pedro", 2, 6, 1000, "Teatro","10/4/2024");
        mismoHorario2 = new Oferta("Lucas", 2, 6, 800, "Teatro","10/4/2024");
        horarioDentroDelOtro1 = new Oferta("Pedro", 2, 8, 1, "Teatro","10/4/2024");
        horarioDentroDelOtro2 = new Oferta("Lucas", 4, 6, 1, "Teatro","10/4/2024");
        horarioTerminaDentroDelOtro1 = new Oferta("Pedro", 6, 8, 1, "Teatro","10/4/2024");
        horarioTerminaDentroDelOtro2 = new Oferta("Lucas", 1, 7, 1, "Teatro","10/4/2024");
        horarioEmpiezaDentroDelOtro1 = new Oferta("Pedro", 1, 10, 1, "Teatro","10/4/2024");
        horarioEmpiezaDentroDelOtro2 = new Oferta("Lucas", 5, 15, 1, "Teatro","10/4/2024");
    }

    @Test
    public void mismoHorarioTest() {
    
        assertFalse(mismoHorario1.seSuperpone(mismoHorario2));
    }
   
    @Test
    public void horarioDentroDeotroTest() {
    
        assertFalse(horarioDentroDelOtro1.seSuperpone(horarioDentroDelOtro2));
    }
    
    @Test
    public void horarioTerminaDentroDeOtroTest() {
    
        assertFalse(horarioTerminaDentroDelOtro1.seSuperpone(horarioTerminaDentroDelOtro2));
    }
    
    @Test
    public void horarioEmpiezaDentroDelotroTest() {
    
        assertFalse(horarioEmpiezaDentroDelOtro1.seSuperpone(horarioEmpiezaDentroDelOtro2));
    }
    
    @Test
    public void sinSuperposicionTest() {
    	Oferta oferta1 = new Oferta("Carlos", 0, 5, 1000, "Teatro","10/4/2024");
        Oferta oferta2 = new Oferta("Laura", 6, 8, 600, "Danza","10/4/2024");
        assertTrue(oferta1.seSuperpone(oferta2));
    }
}
