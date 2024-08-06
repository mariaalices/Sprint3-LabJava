package fiap;

import java.util.Scanner;

public class Sprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner e = new Scanner(System.in);
		// DECLARANDO VAR. QUE IRA CONTROLAR O TAMANHO DO VETOR
		int equipes = 0, combates = 0;
		// VARIAVEL QUE IRA CONTROLAR O LAÇO WHILE
		String resp = " ";

		// O LAÇO DO/WHILE PERMITE QUE USUÁRIO NÃ PRECISE RODAR O PROGRAMA DUAS VEZES,
		// ELE RODA APENAS UMA E USA QUANTAS VEZES QUISER.
		do {

			// ADICIONANDO O NUMERO DE EQUIPES
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("--------------------------- RANKING ROBÔCUP ---------------------------");
			System.out.println("INSIRA A QUANTIDADE DE EQUIPES PARTICIPANDO:");
			equipes = e.nextInt();

			// DECLARANDO VETOR NUMERO DE EQUIPES
			int[] numEquipe = new int[equipes];
			// VETOR NOTAS
			float[] nota = new float[equipes];

			// NOTA: O VETOR TEVE QUE SER DECLARADO POIS A VARIAVEL DE CONTROLE DO VETOR DEVE SER INICIADA ANTES.

			// FOR QUE CONTROLA A ADIÇÃO DOS NUMEROS DE EQUIPE NO VETOR
			for (int i = 0; i < equipes; i++) {
				System.out.println("Insira o número de equipe da EQUIPE " + (i + 1)
						+ "(Lembre-se, o número deve estar entre 11 e 99):");
				numEquipe[i] = e.nextInt();

				while (numEquipe[i] < 11 || numEquipe[1] > 99) {
					System.out.println("O NÚMERO DE EQUIPE DEVE ESTAR ENTRE 11 E 99:");
					numEquipe[i] = e.nextInt();
				}
				// CONDIÇÃO QUE TESTA A DUPLICIDADE DE NUM. DE EQUIPES
				if (i > 0) {

					while (numEquipe[i] == numEquipe[i - 1]) {
						System.out.println("ESTE NÚMERO DE EQUIPE JÁ CADASTRADO! POR FAVOR SELECIONE OUTRO:");
						numEquipe[i] = e.nextInt();
					} // FIM WHILE, CHECA DUPLICIDADE
				} // FIM IF, CHECA PRIMEIRA RODAGEM FOR
			} // FIM FOR, ADICIONA EQUIPE

			System.out.println("---------------------------------------------------------------------");
			// ITEM 1 CONCLUÍDO!
			System.out.println("---------------------------------------------------------------------");
			for (int a = 0; a < equipes; a++) {
				System.out.println("INSIRA A NOTA DE DESIGN DA EQUIPE " + numEquipe[a] + ":");
				nota[a] = e.nextFloat();
			}
			System.out.println("---------------------------------------------------------------------");
			// ITEM 2 CONCLUÍDO
			System.out.println("---------------------------------------------------------------------");
			System.out.println("INSIRA O NÚMEROS DE COMBATES DAS EQUIPES:");
			combates = e.nextInt();

			// VETOR COMBATE
			char[] resultCombate = new char[combates];
			int[] pontos = new int[equipes];
			// FOR PERCORRE EQUIPES
			for (int b = 0; b < equipes; b++) {
				// FOR PERCORRE COMBATES
				for (int c = 0; c < combates; c++) {
					System.out.println("INSIRA O RESULTADO DO COMBATE" + (c + 1) + " DA EQUIPE " + numEquipe[b]
							+ ":(V p/ VITÓRIA,D p/ DERROTA,E p/ EMPATE)");
					// TO UPPER CASE EM CHAR (PESQUISEI PRA DABER COMO FAZER!)
					resultCombate[c] = Character.toUpperCase(e.next().charAt(0));
					// WHILE CHECA DADO (v,D,E)
					while (!(resultCombate[c] == 'V' || resultCombate[c] == 'D' || resultCombate[c] == 'E')) {
						System.out.println("Por favor insira um caractere válido (V, D ou E):");
						resultCombate[c] = Character.toUpperCase(e.next().charAt(0));
					}
					// IF ADICIONA PONTO
					if (resultCombate[c] == 'V') {
						pontos[b] += 7;
					} else if (resultCombate[c] == 'E') {
						pontos[b] += 4;
					}
				}
				// IF ADICIONA PONTO. NOTA: NÃO EXISTE UM ELSE PRA DERROTA POIS NÃO SERA CONTABILIZADO PONTOS

			}

			System.out.println("---------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("---------------------- RANKING DAS EQUIPES --------------------------");
			// IF PERCORRE EQUIPES
			
			for (int i = 0; i < equipes - 1; i++) {
				for (int j = i + 1; j < equipes; j++) {
					if (pontos[i] < pontos[j] || (pontos[i] == pontos[j] && nota[i] < nota[j])) {
						// Troca as equipes de posição
						int x = numEquipe[i];
						numEquipe[i] = numEquipe[j];
						numEquipe[j] = x;

						int y = pontos[i];
						pontos[i] = pontos[j];
						pontos[j] = y;

						float z = nota[i];
						nota[i] = nota[j];
						nota[j] = z;
					}
				}
			}
			// FOR SAIDA
			for (int a = 0; a < equipes; a++) {
				System.out.println(nota[a]);
			}
			for (int i = 0; i < equipes; i++) {
				System.out.print((i + 1) + ". " + numEquipe[i] + " - " + pontos[i] + " pontos");
				if (i < equipes - 1 && pontos[i] == pontos[i + 1]) {
					// Se a próxima equipe tem a mesma pontuação, exibe a nota de design
					System.out.print(" - Nota de design: " + nota[i]);
				}
				System.out.println();
			}

			// AGORA, IRA HAVER A VALIDAÇÃO DE DIGITAÇÃO DO USUÁRIO (SIM/NAO)
			System.out.println("================================ FIM ================================");
			System.out.println("DESEJA REALIZAR OUTRO RANKING? DIGITE SIM OU NÃO");
			resp = e.next().toUpperCase();
			while (!resp.equalsIgnoreCase("SIM") && !resp.equalsIgnoreCase("NÃO")) {
				System.out.println("Digite SIM ou NÃO:");
				resp = e.next().toUpperCase();
			}
		} while (resp.equalsIgnoreCase("SIM"));
		System.out.println("VOCÊ ENCERROU O ALGORITMO, POR FAVOR FECHE A JANELA. ATÉ BREVE! :)");

	}

}
