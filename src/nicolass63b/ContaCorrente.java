package nicolass63b;

import java.io.Serializable;

/**
 *
 * @author Nicolas S
 */
public class ContaCorrente extends Conta implements Serializable{
    private double limite;
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
      this.limite = limite;
    }

    String[] split(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
