package concursoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class notas {

		public static void main(String[] args) {
	
		        Scanner scanner = new Scanner(System.in);
		        scanner.useLocale(Locale.US);
		        
		        System.out.printf("Digite a quantidade de pessoas: ");
		        int N = scanner.nextInt();
		        scanner.nextLine(); 

		        List<String> nomes = new ArrayList<>();
		        List<Double> notasEtapa1 = new ArrayList<>();
		        List<Double> notasEtapa2 = new ArrayList<>();
		        List<Double> medias = new ArrayList<>();
		        List<String> aprovados = new ArrayList<>();
		      
		        for (int i = 0; i < N; i++) {
		            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
		            String nome = scanner.nextLine();
		            System.out.print("Digite a nota da etapa 1 da " + nome + ": ");
		            double nota1 = scanner.nextDouble();
		            System.out.print("Digite a nota da etapa 2 da " + nome + ": ");
		            double nota2 = scanner.nextDouble();
		            scanner.nextLine(); 

		            nomes.add(nome);
		            notasEtapa1.add(nota1);
		            notasEtapa2.add(nota2);

		            
		            double media = (nota1 + nota2) / 2;
		            medias.add(media);
		            if (media >= 70) {
		                aprovados.add(nome);
		            }
		        }

		   //notas
		        System.out.println("\nTabela de pessoas e suas médias:");
		        System.out.printf("%-20s %-10s%n", "Nome", "Média");
		        for (int i = 0; i < N; i++) {
		            System.out.printf("%-20s %.2f%n", nomes.get(i), medias.get(i));
		        }

		       
		        System.out.println("\nPessoas aprovadas:");
		        if (!aprovados.isEmpty()) {
		            for (String nome : aprovados) {
		                System.out.println(nome);
		            }
		        } else {
		            System.out.println("Nenhuma pessoa aprovada.");
		        }


		        double porcentagemAprovacao = (aprovados.size() / (double) N) * 100;
		        System.out.printf("\nPorcentagem de aprovação: %.2f%%%n", porcentagemAprovacao);

		        
		        if (!medias.isEmpty()) {
		            double maiorMedia = medias.get(0);
		            String nomeMaiorMedia = nomes.get(0);
		            for (int i = 1; i < medias.size(); i++) {
		                if (medias.get(i) > maiorMedia) {
		                    maiorMedia = medias.get(i);
		                    nomeMaiorMedia = nomes.get(i);
		                }
		            }
		            System.out.printf("\nPessoa com a maior média: %s com média %.2f%n", nomeMaiorMedia, maiorMedia);
		        }

		        
		        if (!aprovados.isEmpty()) {
		            double somaMediasAprovados = 0;
		            for (double media : medias) {
		                if (media >= 70) {
		                    somaMediasAprovados += media;
		                }
		            }
		            double mediaAprovados = somaMediasAprovados / aprovados.size();
		            System.out.printf("\nNota média das pessoas aprovadas: %.2f%n", mediaAprovados);
		        } else {
		            System.out.println("\nNão há candidatos aprovados.");
		        }

		        scanner.close();
		}
		}