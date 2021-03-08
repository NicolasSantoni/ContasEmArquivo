package nicolass63b;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Nicolas S
 */
public class Banco {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner lerDados = new Scanner(System.in);
        ContaCorrente[] cc = new ContaCorrente[10];
        ContaPoupanca[] cp = new ContaPoupanca[10];
        int op;
        int opC;
        int contC = 0;
        int contP = 0;
        int cont = 0;
        String nomeBanco;
        int agencia;
        do {            
            System.out.print("Indique a opção desejada:\n1 - Criar conta corrente\n2 - Criar conta poupança\n3 - Acessar conta corrente\n4 - Acessar conta poupança\n5 - Sair\n");
            op = lerDados.nextInt();
            if (op==1) {
                File pasta = new File("./arquivos");
                if (!pasta.exists()){
                    pasta.mkdir();
                }
                File ContaCorrente = new File(pasta, "ContaCorrente.arq");
                try{
                    if (!ContaCorrente.exists()) {
                        ContaCorrente.createNewFile();
                    }
                    else{
                        ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(ContaCorrente.getAbsolutePath()));
                        ContaCorrente[] ccc = (ContaCorrente[]) objLeitura.readObject();
                        for(int i = 0; i < 10; i++ ){
                            if (ccc[i] != null) {
                                System.out.print("funfa");
                                cc[i] = new ContaCorrente();
                                String n = ccc[i].getNomeBanco();
                                cc[i].setNomeBanco(n);
                                int nu = ccc[i].getNumero();
                                cc[i].setNumero(nu);
                                int a = ccc[i].getAgencia();
                                cc[i].setAgencia(a);
                                double l = ccc[i].getLimite();
                                cc[i].setLimite(l);
                                double d = ccc[i].getSaldo();
                                cc[i].depositar(d);
                                contC = i+1;
                                System.out.print(contC);
                            }
                            
                        }
                    }
                    ObjectOutputStream arqC = new ObjectOutputStream(new FileOutputStream(ContaCorrente.getAbsolutePath()));
                    cc[contC] = new ContaCorrente();
                    System.out.print("Indique o nome do banco: ");
                    nomeBanco = lerDados.next();
                    cc[contC].setNomeBanco(nomeBanco);
                    System.out.print("Indique o número de sua conta: ");
                    int numero = lerDados.nextInt();
                    cc[contC].setNumero(numero);
                    System.out.print("Indique a agência: ");
                    agencia = lerDados.nextInt();
                    cc[contC].setAgencia(agencia);
                    System.out.print("Indique o limite da conta: ");
                    double limite = lerDados.nextFloat();
                    cc[contC].setLimite(limite);
                    cc[contC].depositar(0);
                    arqC.writeObject(cc);
                    contC++;
                }
                catch(Exception e){
                    System.out.print("Ocorreu um erro!");
                    e.printStackTrace();
                }
            }
            else if (op==2) {
                File pasta = new File("./arquivos");
                if (!pasta.exists()){
                    pasta.mkdir();
                }
                File ContaPoupanca = new File(pasta, "ContaPoupanca.arq");
                try{
                    if (!ContaPoupanca.exists()) {
                        ContaPoupanca.createNewFile();
                    }
                    else{
                        ObjectInputStream objLeituraP = new ObjectInputStream(new FileInputStream(ContaPoupanca.getAbsolutePath()));
                        ContaPoupanca[] cpp = (ContaPoupanca[]) objLeituraP.readObject();
                        for(int i = 0; i < 10; i++ ){
                            if (cpp[i] != null) {
                                cp[i] = new ContaPoupanca();
                                String n = cpp[i].getNomeBanco();
                                cp[i].setNomeBanco(n);
                                int nu = cpp[i].getNumero();
                                cp[i].setNumero(nu);
                                int a = cpp[i].getAgencia();
                                cp[i].setAgencia(a);
                                double d = cpp[i].getSaldo();
                                cp[i].depositar(d);
                                contP = i+1;
                            }
                            
                        }
                    }
                    ObjectOutputStream arqP = new ObjectOutputStream(new FileOutputStream(ContaPoupanca.getAbsolutePath()));
                    cp[contP] = new ContaPoupanca();
                    System.out.print("Indique o nome do banco: ");
                    nomeBanco = lerDados.next();
                    cp[contP].setNomeBanco(nomeBanco);
                    System.out.print("Indique o número de sua conta: ");
                    int numero = lerDados.nextInt();
                    cp[contP].setNumero(numero);
                    System.out.print("Indique a agência: ");
                    agencia = lerDados.nextInt();
                    cp[contP].setAgencia(agencia);
                    cp[contP].depositar(0);
                    arqP.writeObject(cp);
                    contP++;
                }
                catch(Exception e){
                    System.out.print("Ocorreu um erro!");
                    e.printStackTrace();
                }
            }
            else if (op==3) {              
                File pasta = new File("./arquivos");
                if (!pasta.exists()){
                    pasta.mkdir();
                }
                File ContaCorrente = new File(pasta, "ContaCorrente.arq");
                if (!ContaCorrente.exists()) {
                    System.out.print("Não há nenhuma conta registrada!\n");
                }
                else{
                    System.out.print("Indique o número de sua conta:\n");
                    int nom = lerDados.nextInt();
                    ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(ContaCorrente.getAbsolutePath()));
                    ContaCorrente[] ccc = (ContaCorrente[]) objLeitura.readObject();
                    int t = -1;
                    for(int i = 0; i < ccc.length; i++ ){
                        if (ccc[i] != null) {
                            if (ccc[i].getNumero() == nom) {
                                t = i;
                            }
                        }
                    }
                    while(t == -1){
                        System.out.print("Banco não encontrado! Indique outro:\n");
                        nom = lerDados.nextInt();
                        for(int i = 0; i < ccc.length; i++ ){
                            if (ccc[i] != null) {
                                if (ccc[i].getNumero() == nom) {
                                    t = i;
                                }
                            }
                        }
                    }
                    System.out.print("Indique a opção desejada:\n1 - Realizar depósito\n2 - Realizar saque\n3 - Verificar saldo\n");
                    opC = lerDados.nextInt();
                    if (opC==1) {
                        System.out.print("Indique o valor a ser depositado: ");
                        double valor = lerDados.nextFloat();
                        if ((ccc[t].getSaldo()+valor)>ccc[t].getLimite()) {
                            System.out.println("O depósito não pode ser realizado! Limite ultrapassado.\n");
                        }
                        else {
                            ObjectOutputStream arqC = new ObjectOutputStream(new FileOutputStream(ContaCorrente.getAbsolutePath()));
                            ccc[t].depositar(valor);
                            arqC.writeObject(ccc);
                            System.out.println("Depósito realizado com sucesso!\n");
                        }
                    }
                    else if (opC==2) {
                        System.out.print("Indique o valor a ser sacado: ");
                        double valor = lerDados.nextFloat();
                        if (ccc[t].realizarSaque(valor)) {
                            ObjectOutputStream arqC = new ObjectOutputStream(new FileOutputStream(ContaCorrente.getAbsolutePath()));
                            arqC.writeObject(ccc);
                            System.out.println("Saque realizado com sucesso!\n");
                        }
                        else {
                            System.out.println("Saque não realizado! Dinheiro insuficiente.\n");
                        }
                    }
                    else if (opC==3) {
                        System.out.println("Saldo: "+ccc[t].getSaldo());
                    }
                }
            }
            else if (op==4) {
                File pasta = new File("./arquivos");
                if (!pasta.exists()){
                    pasta.mkdir();
                }
                File ContaPoupanca = new File(pasta, "ContaPoupanca.arq");
                if (!ContaPoupanca.exists()) {
                    System.out.print("Não há nenhuma conta registrada!\n");
                }
                else{
                    System.out.print("Indique o número de sua conta:\n");
                    int nom = lerDados.nextInt();
                    ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(ContaPoupanca.getAbsolutePath()));
                    ContaPoupanca[] cpp = (ContaPoupanca[]) objLeitura.readObject();
                    int t = -1;
                    for(int i = 0; i < cpp.length; i++ ){
                        if (cpp[i] != null) {
                            if (cpp[i].getNumero() == nom) {
                                t = i;
                            }
                        }
                    }
                    while(t == -1){
                        System.out.print("Banco não encontrado! Indique outro:\n");
                        nom = lerDados.nextInt();
                        for(int i = 0; i < cpp.length; i++ ){
                            if (cpp[i] != null) {
                                if (cpp[i].getNumero() == nom) {
                                    t = i;
                                }
                            }
                        }
                    }
                    System.out.print("Indique a opção desejada:\n1 - Realizar depósito\n2 - Realizar saque\n3 - Verificar saldo\n");
                    opC = lerDados.nextInt();
                    if (opC==1) {
                        System.out.print("Indique o valor a ser depositado: ");
                        double valor = lerDados.nextFloat();
                        cpp[t].depositar(valor);
                        ObjectOutputStream arqP = new ObjectOutputStream(new FileOutputStream(ContaPoupanca.getAbsolutePath()));
                        arqP.writeObject(cpp);
                        System.out.println("Depósito realizado com sucesso!\n");
                    }
                    else if (opC==2) {
                        System.out.print("Indique o valor a ser sacado: ");
                        double valor = lerDados.nextFloat();
                        if (cpp[t].realizarSaque(valor)) {
                            System.out.println("Saque realizado com sucesso!");
                            ObjectOutputStream arqP = new ObjectOutputStream(new FileOutputStream(ContaPoupanca.getAbsolutePath()));
                            arqP.writeObject(cpp);
                        }
                        else {
                            System.out.println("Saque não realizado! Dinheiro insuficiente.");
                        }
                    }
                    else if (opC==3) {
                        System.out.println("Saldo: "+cpp[t].getSaldo());
                    }
                }
            }
        }
        while (op<5 && op>0);
    }
}
