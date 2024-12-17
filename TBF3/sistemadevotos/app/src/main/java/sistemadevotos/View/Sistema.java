package main.java.sistemadevotos.view;

import main.java.sistemadevotos.exception.LimiteDeVotosDiariosException;
import main.java.sistemadevotos.util.TecladoUtil;
import sistemadevotos.controller.VotacaoController;
import sistemadevotos.repository.FuncionarioRepository;
import sistemadevotos.repository.RestauranteRepository;

/**
 * Classe principal para execução do sistema de votação.
 * <p>
 * Esta classe fornece um menu interativo para realizar ações como cadastro de votos,
 * visualização dos resultados da votação, e listagem de restaurantes ou funcionários.
 * </p>
 * <p>
 * O sistema se mantém em execução até que o usuário selecione a opção de sair.
 * </p>
 *
 * @author Gustavo
 * @version 1.0
 */
public class Sistema {

    private static VotacaoController controller = new VotacaoController();
    private static RestauranteRepository restauranteRepository = new RestauranteRepository();
    private static FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    private static boolean sair = false;

    /**
     * Método principal que inicia a execução do sistema.
     * Um menu interativo é exibido até que o usuário selecione a opção de sair.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informe uma Opção:");
            executaAcao(opcao);
        }
    }

    /**
     * Executa a ação correspondente à opção fornecida pelo usuário.
     *
     * @param opcao A opção informada pelo usuário.
     */
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
                    System.out.println(restauranteRepository.listar());
                    break;
                case 4:
                    System.out.println(funcionarioRepository.listar());
                    break;
                case 5:
                    System.out.println("Fim!!!");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Realiza o cadastro de um voto.
     *
     * @throws LimiteDeVotosDiariosException Se o limite diário de votos for excedido.
     */
    private static void cadastroDeVoto() {
        try {
            String nomeFuncionario = TecladoUtil.lerString("Informe o nome do Funcionário:");
            String nomeRestaurante = TecladoUtil.lerString("Informe o nome do Restaurante:");
    
            // Chamada ao método corrigida para passar os parâmetros necessários.
            controller.CadVoto(nomeFuncionario, nomeRestaurante);
    
            System.out.println("Voto inserido com sucesso!");
        } catch (LimiteDeVotosDiariosException e) {
            System.out.println("Limite de Votos atingidos " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Algo deu errado: " + e.getMessage());
        }
    }
    /**
     * Exibe o resultado total da votação.
     */
    private static void resultadoDaVotacao() {
        System.out.println("Resultado da Votação:");
        System.out.println(controller.totalDeVotosEmGeral());
    }

    /**
     * Exibe o menu de opções no terminal.
     */
    private static void menu() {
        System.out.println("________________________");
        System.out.println("(1) Cadastro de votos");
        System.out.println("(2) Resultado da votação");
        System.out.println("(3) Listar Restaurantes");
        System.out.println("(4) Listar Funcionários");
        System.out.println("(5) Sair");
        System.out.println("________________________");
    }
}
