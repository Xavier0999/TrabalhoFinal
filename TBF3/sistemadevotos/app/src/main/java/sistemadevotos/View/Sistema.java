package main.java.sistemadevotos.view;

import br.org.fundatec.controller.CidadeController;
import br.org.fundatec.exception.AplicacaoException;
import main.java.sistemadevotos.exception.LimiteDeVotosDiariosException;
import main.java.sistemadevotos.util.TecladoUtil;
import sistemadevotos.controller.VotacaoController;

public class Sistema {

 private static VotacaoController controller = new VotacaoController();
    private static boolean sair = false;



    public static void main(String[] args) {
        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informe uma Opcao:");
            executaAcao(opcao);
        }
    }


    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                   cadastroDeVoto();
                    break;
                case 2:
                    resultadoDaVotacao();
                    break;
                case 3:
                   System.out.println(restauranteRepository.listar);
                    break;
                case 4:
                   System.out.println(funcionarioRepository.listar);
                    break;
                case 5:
                   System.out.println("Fim!!!");
                    break;
                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        }catch (AplicacaoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastroDeVoto() throws  LimiteDeVotosDiariosException{
        String nome = TecladoUtil.lerString("Informe o nome do Funcionario:");
        String restaurante = TecladoUtil.lerString("Informe o nome do Restaurante:");
        
        controller.CadVoto(nome, nomeRestaurante);

        System.out.println("Voto inserido!");

}

private static void resultadoDaVotacao() throws LimiteDeVotosDiariosException {
    System.out.println(controller.totalDeVotosEmGeral());
}
private static void menu() {
    System.out.println("________________________");
    System.out.println("(1) Cadastro de votos");
    System.out.println("(2) Resultado da votaçao");
    System.out.println("(3) buscar Restaurante");
    System.out.println("(4) buscar Funciorio");
    System.out.println("(5) Sair");
    System.out.println("________________________");
}
}


