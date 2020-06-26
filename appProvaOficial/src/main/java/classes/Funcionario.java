package classes;

import java.text.DecimalFormat;

public final class Funcionario extends Pessoa {

    protected String matricula, cargo;
    protected double salario;
    protected int tempoServico;
    protected boolean ativo;

    public Funcionario(String nome, String sobrenome, String matricula, String cargo, int tempoServico) {
        super(nome, sobrenome);
        this.matricula = matricula;
        this.cargo = cargo;
        this.tempoServico = tempoServico;
        this.ativo = true;
        calculaSalario();
    }

    public Funcionario() {
        super();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getSalario() {
        return salario;
    }

    public void calculaSalario() {
        switch (cargo) {
            case "Servente":
                salario = (1 + tempoServico / 1200) * 940;
                break;
            case "Auxiliar":
                salario = (1 + tempoServico / 1200) * 1600;
                break;
            case "Técnico":
                salario = (1 + tempoServico / 1200) * 2200;
                break;
            case "Especialista":
                salario = (1 + tempoServico / 1200) * 3400;
                break;
        }
    }

    public void bonificaFuncionario(float percentualBonificacao) {

        salario = salario + ((salario * percentualBonificacao) / 100);
    }

    public void encerraContrato() {
        ativo = false;
    }

    public float calculaInss() {
        DecimalFormat df = new DecimalFormat("#.##");
        double inss = (salario * 8) / 100;
        df.format(inss);
        return (float) inss;
    }

    public float calculaIr() {
        if (salario <= 1500) {
            return (float) 0;
        } else if (salario <= 3200) {
            return (float) (salario * 15) / 100;
        } else {
            return (float) (salario * 27) / 100;
        }
    }

    public float calculaSalarioLiquido() {
        return (float) salario - calculaIr() - calculaInss();
    }

    @Override
    public String toString() {
        return dados()  + 
                "Matricula: " + matricula + 
                "\nCargo: " + cargo + 
                "\nSalario: " + salario + 
                "\nSalário Liquido: " + calculaSalarioLiquido() +
                "\nTempo de Serviço: " + tempoServico +
                "\nAtivo: " + ativo;
    }

}
