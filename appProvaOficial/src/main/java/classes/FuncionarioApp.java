package classes;

import javax.swing.JOptionPane;

public class FuncionarioApp {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog(null, "Informe o primeiro nome", "Prova Eng", 3);
        String sobrenome = JOptionPane.showInputDialog(null, "Informe o sobrenome", "Prova Eng", 3);
        String matricula = JOptionPane.showInputDialog(null, "Informe a matricula", "Prova Eng", 3);
        String[] cargoOp = {"Servente", "Auxiliar", "Técnico", "Especialista"};
        String cargo = (String) JOptionPane.showInputDialog(null, "Escolha o combustível do carro", "Automóvel", 3, null, cargoOp, cargoOp[0]);
        int tempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tempo de serviço", "Prova Eng", 3));

        Funcionario func = new Funcionario(nome, sobrenome, matricula, cargo, tempo);

        int opUsr = 0;
        while (opUsr == 0) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n1.Listar as informações do usuário.\n2.Reajustar o salário do funcionario.\n3.Demitir o funcionario.\n4.Finalizar o programa", "Prova Eng", 3));
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, func.toString());
                    break;
                case 2:
                    if (func.isAtivo()) {
                        float reajuste = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o percentual:", "Prova Eng", 3));
                        func.bonificaFuncionario(reajuste);
                    } else {
                        JOptionPane.showMessageDialog(null, "Funcionario Demitido!", "Eng Prova", 3);
                    }
                    break;
                case 3:
                    if (func.isAtivo()) {
                        int demitir = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja demitir?\n1.Sim\n2.Não", "Eng Prova", 3));
                        if (demitir == 1) {
                            func.encerraContrato();
                        }
                        JOptionPane.showMessageDialog(null, "Funcionario Demitido", "Eng Prova", 2);
                    } else {
                        int opRecontratar = Integer.parseInt(JOptionPane.showInputDialog(null, "Funcionario já foi demitido, deseja recontrata-lo?\n1.Sim\n2.Não", "Eng Prova", 3));
                        if (opRecontratar == 1) {
                            func.setAtivo(true);
                            JOptionPane.showMessageDialog(null, "Funcionario recontratado", "Eng Prova", 3);
                        }
                    }
                    break;
                case 4:
                    int sair = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja sair do sistema?\n1.Sim\n2.Não", "Eng Prova", 3));
                    if (sair == 1) {
                        opUsr = 1;
                    }
                    break;
            }
        }
        System.exit(0);

    }
}
