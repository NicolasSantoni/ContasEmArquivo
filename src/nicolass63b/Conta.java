package nicolass63b;

import java.io.Serializable;

public class Conta implements Serializable {
  private static String nomeBanco;
  private int numero;
  private int agencia;
  protected double saldo;

  public String getNomeBanco() {
    return nomeBanco;
  }

  public void setNomeBanco(String nomeBanco) {
    Conta.nomeBanco = nomeBanco;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getAgencia() {
    return agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  }

  public double getSaldo() {
    return saldo;
  }

  public void depositar(double valor) {
    this.saldo += valor;
  }
  
  public boolean realizarSaque(double valor){
    if(valor<=saldo){
      saldo-=valor;
      return true;
    }
    return false; 
  }
}
