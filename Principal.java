/*
 * Escrevendo um Comparator com classe anônima
 * 
 A classe ComparadorPorTamanho conforme o exemplo do pojeto Comparators é bem pequena. É comum haver a necessidade de criar
vários critérios de comparação, e muitas vezes eles são utilizados apenas num único ponto do nosso
programa.

Há uma forma de escrever essa classe e instanciá-la numa única instrução. Você faz isso dando new
em Comparator . Mas como, se dissemos que uma interface não pode ser instanciada? Realmente new
Comparator() não compila. Mas vai compilar se você abrir chaves e implementar tudo o que é
necessário. Veja o código:
 * */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {

	public static void main(String [] args) {
		
		List<String> listaNomes = new ArrayList<>();
		
		listaNomes.add("claudio");
		listaNomes.add("Anabeatriz");
		listaNomes.add("zilda");
		listaNomes.add("bernadete");
		
			/* criando a classe anonima 
			
			Instanciando a interface Comparator<> e ao mesmo tempo implementando 
			o método compare() no objeto instanciado. O uso das chaves {} permitiu
			instanciar a interface Comparator ,criando assim, uma classe anonima.
			Dispensando assim a necessidade de criar uma classe Comparador que implementa a 
			interface Comparator<>
			
			 * */
		
		
		Comparator<String> comparador = new Comparator<String>() {
			
			public int compare(String str1, String str2) {
				
				return Integer.compare(str1.length(), str2.length());	//compara pelo tamanho das Strings			
			}						
			
		};
		
		
		
		
		
		Collections.sort(listaNomes, comparador);
		
		
		System.out.println(listaNomes);
		
		
		//A partir da  versão do Java 8 há uma forma mais simples de obter esse mesmo Comparator		
		//Escrevendo um Comparator com lambda
		
		List<String> listaNomes2 = new ArrayList<>();
		
		
		listaNomes2.add("Marcia");
		listaNomes2.add("Adeilton");
		listaNomes2.add("marta");
		
		
		Collections.sort(listaNomes2, (s1, s2)->Integer.compare(s1.length() , s2.length()));   /*conceito de callback(chamar de volta)
		A função (s1, s2)->Integer.compare(s1.length() , s2.length()) será chamada de volta pelo método sort enquanto tiver elementos
		na lista para serem comparados */
		
		/*
		O código (s1, s2) -> Integer.compare(s1.length(), l2.length()) gerará uma instância de
     Comparator que o compare retorna Integer.compare(s1.length, l2.length) . Até mesmo o
     return não é necessário, já que só temos uma instrução após o -> 
		 * */
		
		System.out.println(listaNomes2);
		
		
		/*
		Uma outra novidade apartir do Java 8 é a possibilidade de declarar métodos concretos dentro de uma
       interface, os chamados default methods. Até o Java 7 não existia sort em listas. Colocar um novo
       método abstrato em uma interface pode ter consequências drásticas: todo mundo que a implementava
       para de compilar! Mas colocar um método default não tem esse mesmo impacto devastador, já que as
       classes que implementama interface 'herdam' esse método. Então você pode fazer:
		 * */
		
		List<String> listaNomes3 = new ArrayList<>();
		
		listaNomes3.add("Betinho");
		listaNomes3.add("carlos");
		listaNomes3.add("ancelmo");
		
		listaNomes3.sort((s1,s2)->Integer.compare(s1.length(), s2.length()));	
		
		
		System.out.println(listaNomes3);
		
		
		List<String> listaNomes4 = new ArrayList<>();
		
		listaNomes4.add("carlinhos");
		listaNomes4.add("Zeze");
		listaNomes4.add("Mendes");
		listaNomes4.add("Andresssa");
		
		/*Há outros métodos nas coleções que utilizam do lambda para serem mais sucintos.
          Um deles é o forEach .*/
		
		//listaNomes4.forEach((s1,s2)-> System.out.println(s1, s2));
		
		
		
	}
}
