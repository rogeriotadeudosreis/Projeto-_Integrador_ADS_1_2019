package projeto_Integrador_ADS_1_2019_Senai_Fatesg_Goiania;

import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class projeto_Integrador_2019_ADS {

	static int[] contSalas = new int[9];
	static int opcFilmes = 0;
	static int opcEntrada = 0;
	static int opcao = 0;
	static int poltrona = 0;
	static int entrada = 0;
	static int resp = 0;

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// Declarando as matrizes e atribuindo o tamanho delas e variáveis

		int linha = 10;
		int coluna = 10;

		String[][] sala1_Manha = new String[linha][coluna];
		String[][] sala1_Tarde = new String[linha][coluna];
		String[][] sala1_Noite = new String[linha][coluna];
		String[][] sala2_Manha = new String[linha][coluna];
		String[][] sala2_Tarde = new String[linha][coluna];
		String[][] sala2_Noite = new String[linha][coluna];
		String[][] sala3_Manha = new String[linha][coluna];
		String[][] sala3_Tarde = new String[linha][coluna];
		String[][] sala3_Noite = new String[linha][coluna];
		String[] menuFilmes = { "CORINGA - Sessão Manhã - Sala 1\n", "MALÉVOLA DONA DO MAL - Sessão Tarde - Sala 1\n",
				"AS PANTERAS - Sessão Noite - Sala 1\n", "DORA A CIDADE PERDIDA - Sessão Manhã - Sala 2\n",
				"OS PARÇAS - Sessão Tarde - Sala 2\n", "DR. DO SONO - Sessão Noite - Sala 2\n",
				"O EXTERMINADOR DESTINO SOMBRIO - Sessão Manhã - Sala 3\n", "MUSSUM - Sessão Tarde - Sala 3 \n",
				"MEDO PROFUNDO - Sessão Noite - Sala 3\n" };
		String[] menuPrincipal = { "Venda de Ingressos\n", "Reimpressão de Ingressos\n",
				"Gerar Relatórios de Estatísticas\n", "Sair\n" };
		String sessaoM = "";
		String sessaoT = "";
		String sessaoN = "";
		String entrada = "";
		String sala = "";
		String status = "OCUPADA";
		String idCine = "          Cine ABC    ";
		String usuarioInf = "ADMIN";
		String senhaInf = "ADMIN";
		String rodapeEmpresa = "ADR - SISTEMAS & SOLUÇÕES EM TECNOLOGIA\n";
		char[] vetorFileira = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		char fileira = '0';
		int[] somaSessoes = new int[3];
		String sessao = "";
		int maiorFilme = 0;
		int menorSessao = 0;
		int maiorSessao = 0;
		int posicaoMaior = 0;
		int posicaoMenor = 0;
		int posicao;
		int escolha;
		int fileiraNumerica;
		int contSessaoManha = 0;
		int contSessaoTarde = 0;
		int contSessaoNoite = 0;
		int tentativas = 3;
		int cont = 0;
		float valorPago = 0.00f;
		float valorMeia = 12.50f;
		float valorInteira = 25.00f;

		// Método para gerar matrizes preenchidas com 20% de lugares reservados.

		metodo(sala1_Manha, idCine, rodapeEmpresa, "A", "Manhã", "Coringa", 0);
		metodo(sala1_Tarde, idCine, rodapeEmpresa, "A", "Tarde", "Malevola", 1);
		metodo(sala1_Noite, idCine, rodapeEmpresa, "A", "Noite", "As Panteras", 2);
		metodo(sala2_Manha, idCine, rodapeEmpresa, "B", "Manhã", "Dora", 3);
		metodo(sala2_Tarde, idCine, rodapeEmpresa, "B", "Tarde", "Os Parças", 4);
		metodo(sala2_Noite, idCine, rodapeEmpresa, "B", "Noite", "Dr. Sono", 5);
		metodo(sala3_Manha, idCine, rodapeEmpresa, "C", "Manhã", "O Exterminador", 6);
		metodo(sala3_Tarde, idCine, rodapeEmpresa, "C", "Tarde", "Mussum", 7);
		metodo(sala3_Noite, idCine, rodapeEmpresa, "C", "Noite", "Medo Profundo", 8);

		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
		String dataFormatada = formatar.format(data);

		// Inicio da execução do programa
		System.out.print(
				"  --------------------------------------------------------------------------------------------------------------------------------\n"
						+ "  Sistema de Venda de Ingressos de Cinema                                                                    "
						+ dataFormatada + "\n"
						+ "  --------------------------------------------------------------------------------------------------------------------------------\n"
						+ "\n\n\n\n" + "                                                           Cine ABC\n\n\n"
						+ "                                                           Usuario: ");

		boolean teste = false;
		do {

			usuarioInf = teclado.next().toUpperCase().toString();
			if (usuarioInf.equals("ADMIN")) {
				teste = true;
			} else {
				System.out.println("Usuário Inválido ! Digite Novamente: ");
			}

		} while (teste == false);

		System.out.print("                                                           Senha  : ");

		senhaInf = teclado.next().toUpperCase().toString();

		do {

			if (senhaInf.equals("ADMIN")) {

				System.out.println("\nBem vindo ao Sistema !");
				break;
			} else {
				System.out.printf("\nSenha Inválida ! Após %d Tentativas Sua Senha Será Bloqueada! ", tentativas);
				System.out.printf("\nDigite Novamente Sua Senha: ");
				senhaInf = teclado.next().toUpperCase().toString();
				cont++;
			}
		} while (cont < tentativas);

		if (!senhaInf.equals("ADMIN")) {
			System.out.printf("“DESCULPE, Senha Bloqueada! Procure o Administrador.");
			System.exit(0);
		}

		// Escolhendo a opção desejada

		do {
			System.out.println(
					"\n                                                    Digite a Opção Desejada                                ");

			// Imprime o menu principal
			imprimevetor(menuPrincipal);

			// validaOpcaoMenuPrincipal();
			opcao = validaOpcaoMenuPrincipal(opcao);

			switch (opcao) {

			case 1: // Caso 1 - redireciona para venda de ingressos
				do {
					System.out.printf("\n\t\t\t%s\n", menuPrincipal[opcao - 1]); // Opção do menuPrincipal escolhida

					imprimevetor(menuFilmes); // Imprime a lista de filmes e suas respectivas sessões

					System.out.print("\n-> Escolha o código de seu filme e sessão:    -> ");

					opcFilmes = validaOpcFilmes(opcFilmes);

					contSalas[opcFilmes - 1]++;

					// Este vetor armazena a quantidade de filmes escolhidos
					switch (opcFilmes) {

					// Caso escolha filme 1
					case 1:
						System.out.print("\n     -> Ok, Você escolheu:\n");

						// Impressão do filme escolhido
						System.out.printf("\n%d) %s\n", opcFilmes, menuFilmes[opcFilmes - 1]);
						System.out.println("");

						// De acordo com o filme e sessão escolhido, é impresso a sala para escolha da
						// fila e poltrona
						metodoMostrar(sala1_Manha);
						contSessaoManha++;

						// Escolha da fileira ou fila
						System.out.print("\nInforme a fileira que deseja comprar : -> ");

						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);

						// Escolha da poltrona ou assento
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);

						// Escolha do tipo de entrada (inteira ou meia)
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");

						opcEntrada = validaTipoEntrada(opcEntrada);

						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala1_Manha[i][poltrona - 1] = status;
							}

						}
						// Verificando o tipo de entrada para determinar o valor a ser pago
						switch (opcEntrada) {
						case 1:
							entrada = "Inteira";
							valorPago = valorInteira;

							break;
						case 2:
							entrada = "Meia";
							valorPago = valorMeia;

							break;
						}
						// Imprimindo o bilhete
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));

						// Armazenando os dados do bilhete na posição da respectiva sala
						sala1_Manha[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);

						// Impressão do bilhete via posição da respectiva sala (apenas conferência)
						// System.out.println(sala1_Manha[fileiraNumerica][poltrona - 1]);

						break;

					// Caso escolha filme 2
					case 2:

						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala1_Tarde);
						contSessaoTarde++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);

						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala1_Tarde[i][poltrona - 1] = status;
							}

						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala1_Tarde[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);

						break;

					// Caso escolha filme 3
					case 3:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala1_Noite);
						contSessaoNoite++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala1_Noite[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala1_Noite[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);

						break;

					// Caso escolha filme 4
					case 4:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala2_Manha);
						contSessaoManha++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala2_Manha[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;
							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala2_Manha[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);
						break;

					// Caso escolha filme 5
					case 5:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala2_Tarde);
						contSessaoTarde++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala2_Tarde[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala2_Tarde[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);
						break;

					// Caso escolha filme 6
					case 6:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala2_Noite);
						contSessaoNoite++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala2_Noite[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala2_Noite[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);
						break;

					// Caso escolha filme 7
					case 7:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala3_Manha);
						contSessaoManha++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala3_Manha[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala3_Manha[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);
						break;

					// Caso escolha filme 8
					case 8:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala3_Tarde);
						contSessaoTarde++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala3_Tarde[i][poltrona - 1] = status;
							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));
						sala3_Tarde[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);
						break;

					// Caso escolha filme 9
					case 9:
						System.out.print("\n     -> Ok, Você escolheu:\n");
						System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
						System.out.println("");
						metodoMostrar(sala3_Noite);
						contSessaoNoite++;
						System.out.print("\nInforme a fileira que deseja comprar : -> ");
						fileira = teclado.next().toUpperCase().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a poltrona: -> ");

						poltrona = validaPoltrona(poltrona);
						System.out.print("\nInforme a entrada: (1) Inteira ou (2) Meia: > ");
						opcEntrada = validaTipoEntrada(opcEntrada);
						for (int i = 0; i < vetorFileira.length; i++) {
							if (fileira == vetorFileira[i]) {
								sala3_Noite[i][poltrona - 1] = status;

							}
						}

						switch (opcEntrada) {
						case 1:
							entrada = "INTEIRA";
							valorPago = valorInteira;
							break;
						case 2:
							entrada = "MEIA";
							valorPago = valorMeia;

							break;
						}
						System.out.println(montarBilhete(idCine, menuFilmes[opcFilmes - 1], fileira, poltrona,
								valorPago, entrada, rodapeEmpresa));

						sala3_Noite[fileiraNumerica][poltrona - 1] = montarBilhete(idCine, menuFilmes[opcFilmes - 1],
								fileira, poltrona, valorPago, entrada, rodapeEmpresa);

						break;

					}

					System.out.println("\nComprar Outro Ingresso ? (1) Sim (2) Não ");
					resp = validaTipoResp(resp);

				} while (resp == 1 && opcao != 4);

				System.out.println();
				System.out.println("Pagamento Realizado com Sucesso!");
				break;

			// Aqui referente a escolha do menuPrincipal
			// 2ª opção > Reimpressão de Ingresso
			case 2:
				do {
					System.out.printf("%s\n", menuPrincipal[opcao - 1]);
					imprimevetor(menuFilmes);
					System.out.println();
					System.out.print("\nEscolha o código de seu filme e a sessão -> ");
					opcFilmes = validaOpcFilmes(opcFilmes);
					System.out.printf("\n%s\n", menuFilmes[opcFilmes - 1]);
					if (opcFilmes == 1) {
						metodoMostrar(sala1_Manha);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);
						System.out.println(sala1_Manha[fileiraNumerica][poltrona - 1]);

					} else if (opcFilmes == 2) {
						metodoMostrar(sala1_Tarde);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala1_Tarde[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 3) {
						metodoMostrar(sala1_Noite);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala1_Noite[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 4) {
						metodoMostrar(sala2_Manha);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);
						System.out.println(sala2_Manha[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 5) {
						metodoMostrar(sala2_Tarde);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala2_Tarde[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 6) {
						metodoMostrar(sala2_Noite);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala2_Noite[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 7) {
						metodoMostrar(sala3_Manha);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);
						System.out.println(sala3_Manha[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 8) {
						metodoMostrar(sala3_Tarde);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala3_Tarde[fileiraNumerica][poltrona - 1]);
					} else if (opcFilmes == 9) {
						metodoMostrar(sala3_Noite);
						System.out.println();
						System.out.print("\nInforme a Fileira --> ");
						fileira = teclado.next().charAt(0);
						fileiraNumerica = converteFileiraCharToInt(fileira);
						System.out.print("\nInforme a Poltrona --> ");

						poltrona = validaPoltrona(poltrona);

						System.out.println(sala3_Noite[fileiraNumerica][poltrona - 1]);
					}

					System.out.print("\nReimprimir Outro ingresso ? (1) Sim (2) Não ");
					resp = validaTipoResp(resp);

				} while (resp == 1);
				break;

			// Aqui referente a escolha do menuPrincipal
			// 3ª opção > Relatório de Estatísticas
			case 3:
				System.out.printf("%s\n", menuPrincipal[opcao - 1]);
				System.out.printf("Total de Ingressos Vendidos por Sala:");
				System.out.println();
				for (int i = 0; i < contSalas.length; i++) {
					if (i == 0 || i == 3 || i == 6) {
						sessaoM = "MANHÃ";

					} else {
						if (i == 1 || i == 4 || i == 7) {
							sessaoT = "TARDE";

						} else {
							sessaoN = "NOITE";

						}
					}

					System.out.printf("\n%s > vendido %d vezes.\n", menuFilmes[i], contSalas[i]);

				}

				for (int i = 0; i < contSalas.length; i++) {
					if (i == 0) {
						maiorFilme = contSalas[i];

					}
					if (contSalas[i] > maiorFilme) {
						maiorFilme = contSalas[i];
						posicaoMaior = i;
					}
					if (contSalas[i] < menorSessao) {
						menorSessao = contSalas[i];
						posicaoMenor = i;
					}
				}
				System.out.println("Sessões Vendidas");

				System.out.printf("\nO filme mais vendido foi %s %d vezes\n", menuFilmes[posicaoMaior], maiorFilme);
				System.out.printf("\nSessão %s vendida %d vezes\n", sessaoM, contSessaoManha);
				System.out.printf("\nSessão %s vendida %d vezes\n", sessaoT, contSessaoTarde);
				System.out.printf("\nSessão %s vendida %d vezes\n", sessaoN, contSessaoNoite);

				for (int i = 0; i < somaSessoes.length; i++) {
					somaSessoes[0] = contSessaoManha;
					somaSessoes[1] = contSessaoTarde;
					somaSessoes[2] = contSessaoNoite;
					if (i == 0) {
						maiorSessao = somaSessoes[i];
						menorSessao = somaSessoes[i];
					}
					if (somaSessoes[i] > maiorSessao) {
						maiorSessao = somaSessoes[i];
						posicaoMaior = i;
					}
					if (somaSessoes[i] < menorSessao) {
						menorSessao = somaSessoes[i];
						posicaoMenor = i;
					}
				}

				if (posicaoMaior == 0 || posicaoMaior == 3 || posicaoMaior == 6) {
					sessao = "MANHÃ";

				} else {
					if (posicaoMaior == 1 || posicaoMaior == 4 || posicaoMaior == 7) {
						sessao = "TARDE";

					} else {
						sessao = "NOITE";

					}
				}
				System.out.printf("\nA Sessão " + sessao + " foi a mais vendida, com o total de vendas = %d ",
						contSalas[posicaoMaior]);

				if (posicaoMenor == 1 || posicaoMenor == 4 || posicaoMenor == 7) {
					sessao = "MANHÃ";

				} else {
					if (posicaoMenor == 2 || posicaoMenor == 5 || posicaoMenor == 8) {
						sessao = "TARDE";

					} else {
						sessao = "NOITE";

					}
				}

				System.out.printf("\nA Sessão " + sessao + " foi a menos vendida, com o total de vendas = %d ",
						contSalas[posicaoMenor]);
				break;

			// Aqui referente a escolha do menuPrincipal
			// 4ª opção > Finalizando o Sistema ou Volta ao menuPrincipal
			case 4:

				System.out.println(
						"\n                                              [  Fim do Programa - Obrigado -   ]                                      \n");
				System.exit(0);
			}

			System.out.println("\nVoltar ao Menu Principal ? (1) Sim (2) Não ");

			resp = validaTipoResp(resp);

		} while (resp == 1);
		System.out.println(
				"\n                                              [  Fim do Programa - Obrigado -   ]                                      \n");

		teclado.close();

	}

	public static int validaTipoResp(int Resp) {

		do {
			try {
				Resp = Integer.parseInt(teclado.next());
				if (Resp != 1 && Resp != 2) {
					System.out.printf("\nResposta inválida! Digite (1) Sim (2) Não: ");
				}

			} catch (Exception erro) {
				System.err.printf("\nResposta inválida!");
			}

		} while (Resp != 1 && Resp != 2);

		return Resp;

	}

	public static int validaOpcFilmes(int opcFilmes) {
		do {

			try {

				opcFilmes = Integer.parseInt(teclado.next());
				if (opcFilmes != 1 && opcFilmes != 2 && opcFilmes != 3 && opcFilmes != 4 && opcFilmes != 5
						&& opcFilmes != 6 && opcFilmes != 7 && opcFilmes != 8 && opcFilmes != 9) {
					System.out.println("\nOpção Inválida! Digite entre 1 a 9: ");
				}

			} catch (Exception erro) {
				System.err.println("\nOpção inválida!");

			}

		} while (opcFilmes != 1 && opcFilmes != 2 && opcFilmes != 3 && opcFilmes != 4 && opcFilmes != 5
				&& opcFilmes != 6 && opcFilmes != 7 && opcFilmes != 8 && opcFilmes != 9);
		return opcFilmes;
	}

	public static int validaOpcaoMenuPrincipal(int opcao) {

		do {
			try {

				opcao = Integer.parseInt(teclado.next());

				if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
					System.out.printf("\nOpção inválida, digite entre 1 a 4: ");
				}

			} catch (Exception erro) {

				System.err.printf("\nOpção inválida!");

			}

		} while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

		return opcao;
	}

	public static int validaPoltrona(int poltrona) {
		do {
			try {
				poltrona = Integer.parseInt(teclado.next());
				if (poltrona != 1 && poltrona != 2 && poltrona != 3 && poltrona != 4 && poltrona != 5 && poltrona != 6
						&& poltrona != 7 && poltrona != 8 && poltrona != 9 && poltrona != 10) {
					System.out.printf("\nPoltrona inválida! Por favor, digite entre 1 a 10: ");
				}

			} catch (Exception erro) {
				System.err.printf("\nNúmero de poltrona inválida!");
			}

		} while (poltrona != 1 && poltrona != 2 && poltrona != 3 && poltrona != 4 && poltrona != 5 && poltrona != 6
				&& poltrona != 7 && poltrona != 8 && poltrona != 9 && poltrona != 10);
		return poltrona;
	}

	public static int validaTipoEntrada(int opcEntrada) {

		do {
			try {
				opcEntrada = Integer.parseInt(teclado.next());
				if (opcEntrada != 1 && opcEntrada != 2) {
					System.out.printf("\nTipo de entrada inválida! Digite entre 1 e 2: ");
				}

			} catch (Exception erro) {
				System.err.printf("\nTipo de entrada inválida!");
			}

		} while (opcEntrada != 1 && opcEntrada != 2);

		return opcEntrada;

	}

	private static String toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}

	// Métodos utilizados durante este projeto (vários)
	public static int sorteia(int limiteInferior, int limiteSuperior) {
		Random rd = new Random();
		return rd.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
	}

	public static String montarBilhete(String idCine, String sala, char fileira, int poltrona, Float valorPago,
			String Entrada, String rodapeEmpresa) {
		String text = "";
		text += "\n" + idCine + "";
		text += "\n" + sala + "";
		text += "Fila............: " + fileira + "\n";
		text += "Poltrona........: " + poltrona + "\n";
		text += "ValorPago.......R$ " + valorPago + "\n";
		text += "Entrada.......: " + Entrada + "";
		return text += "\n" + rodapeEmpresa + "\n";
	}

	public static int converteFileiraCharToInt(char fileira) {
		if (fileira == 'a' || fileira == 'A')
			return 0;
		else if (fileira == 'b' || fileira == 'B')
			return 1;
		else if (fileira == 'c' || fileira == 'C')
			return 2;
		else if (fileira == 'd' || fileira == 'D')
			return 3;
		else if (fileira == 'e' || fileira == 'E')
			return 4;
		else if (fileira == 'f' || fileira == 'F')
			return 5;
		else if (fileira == 'g' || fileira == 'G')
			return 6;
		else if (fileira == 'h' || fileira == 'H')
			return 7;
		else if (fileira == 'i' || fileira == 'I')
			return 8;
		else if (fileira == 'j' || fileira == 'J')
			return 9;
		return 0;
	}

	public static char converteFileiraIntToChar(int fileira) {
		if (fileira == 0)
			return 'A';
		else if (fileira == 1)
			return 'B';
		else if (fileira == 2)
			return 'C';
		else if (fileira == 3)
			return 'D';
		else if (fileira == 4)
			return 'E';
		else if (fileira == 5)
			return 'F';
		else if (fileira == 6)
			return 'G';
		else if (fileira == 7)
			return 'H';
		else if (fileira == 8)
			return 'I';
		else if (fileira == 9)
			return 'J';
		return 'N';
	}

	public static void imprimematrizFilmes(String[][] matrizFilmes) {

		for (int i = 0; i < matrizFilmes.length; i++) {
			for (int j = 0; j < matrizFilmes.length; j++) {
				if (matrizFilmes[i][j] != null)
					System.out.print("OCUPADO" + "  \t  ");
				else {
					System.out.print("[   ]");
				}
			}
			System.out.println();
		}
	}

	public static void imprimevetor(String[] vetor) {

		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%d) %s\n", i + 1, vetor[i]);
		}

	}

	public static void metodo(String mat[][], String idCine, String sala, String sessao, String filme,
			String rodapeEmpresa, int posicao) {

		int linha = 0;
		int coluna = 9;
		char linhaChar = 'A';
		int tipo;
		Float valorPago;
		String tipoString;

		for (int i = 0; i < 20; i++) {
			do {
				linha = sorteia(0, 9);
				linhaChar = converteFileiraIntToChar(linha);
				coluna = sorteia(0, 9);
			} while (mat[linha][coluna] != null);

			tipo = sorteia(1, 2);
			if (tipo == 1) {
				valorPago = (float) 25;
				tipoString = "Inteira";

			} else {
				valorPago = (float) (25.0 / 2.0);
				tipoString = "Meia";
			}
			contSalas[posicao]++;

			mat[linha][coluna] = montarBilhete(idCine, sala, linhaChar, coluna, valorPago, tipoString, rodapeEmpresa);
		}
	}

	public static void metodoMostrar(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] != null)
					System.out.print("OCUPADO" + "\t\t");
				else {
					System.out.print(converteFileiraIntToChar(i) + "" + (j + 1) + "  [ ]  " + "\t");
				}
			}
			System.out.println();
		}
	}

}
