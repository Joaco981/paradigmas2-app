package com.example.demo;

public class CajaDeAhorro {
    // Atributos o Variables internas
    private int saldo;
    private Persona titular;

    public void depositar(int monto) {
        //saldo += monto;

        setSaldo(getSaldo() + monto);
    }
    
    private void setSaldo(int valor){
        saldo = valor;
    }

    public int getSaldo(){
        return saldo;

    }

    public int extraer(int monto) {
       
        if (getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }
        setSaldo(getSaldo() - monto);
        return getSaldo();
    }

    public void titular(Persona valor) {
        titular = valor;
    }

    public Persona titular(){
        return titular;
    }
}
