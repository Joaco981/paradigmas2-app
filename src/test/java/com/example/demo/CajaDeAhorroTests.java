package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CajaDeAhorroTests
{
    @Test
    void test1() {
        CajaDeAhorro caja = new CajaDeAhorro();
        assert caja.saldo() == 0;
    }
    
    @Test
    void test2() {
        CajaDeAhorro caja = new CajaDeAhorro();
        caja.depositar(100);
        assert caja.saldo() == 100;
    }

    @Test
    void extraer_cuando_deposito_100_extraigo_10_debe_quedar_90() {
        CajaDeAhorro caja = new CajaDeAhorro();
        caja.depositar(100);
        caja.extraer(10);
        assert caja.saldo() == 90;
    }

    @Test
    void extraer_cuando_deposito_100_extraigo_110_debe_arrojar_un_error() {
        CajaDeAhorro caja = new CajaDeAhorro();
        caja.depositar(100);
       
        assertThrows(RuntimeException.class, () -> {
            caja.extraer(110);
        }, "Saldo insuficiente");
    }

    @Test
    void titular_debe_asignarse_como_titular_una_persona() {
        CajaDeAhorro caja = new CajaDeAhorro();
        
        Persona persona1 = new Persona();
        persona1.nombre("Joaquin");

        caja.titular(persona1);

        assert caja.titular().nombre() == "Joaquin";
        
    }
 
}