/*
 * Escrevendo um Comparator com classe an�nima
 * 
 A classe ComparadorPorTamanho conforme o exemplo do pojeto Comparators � bem pequena. � comum haver a necessidade de criar
v�rios crit�rios de compara��o, e muitas vezes eles s�o utilizados apenas num �nico ponto do nosso
programa.

H� uma forma de escrever essa classe e instanci�-la numa �nica instru��o. Voc� faz isso dando new
em Comparator . Mas como, se dissemos que uma interface n�o pode ser instanciada? Realmente new
Comparator() n�o compila. Mas vai compilar se voc� abrir chaves e implementar tudo o que �
necess�rio. Veja o c�digo:
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
			o m�todo compare() no objeto instanciado. O uso das chaves {} permitiu
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
		
		
		//A partir da  vers�o do Java 8 h� uma forma mais simples de obter esse mesmo Comparator		
		//Escrevendo um Comparator com lambda
		
		List<String> listaNomes2 = new ArrayList<>();
		
		
		listaNomes2.add("Marcia");
		listaNomes2.add("Adeilton");
		listaNomes2.add("marta");
		
		
		Collections.sort(listaNomes2, (s1, s2)->Integer.compare(s1.length() , s2.length()));   /*conceito de callback(chamar de volta)
		A fun��o (s1, s2)->Integer.compare(s1.length() , s2.length()) ser� chamada de volta pelo m�todo sort enquanto tiver elementos
		na lista para serem comparados */
		
		/*
		O c�digo (s1, s2) -> Integer.compare(s1.length(), l2.length()) gerar� uma inst�ncia de
     Comparator que o compare retorna Integer.compare(s1.length, l2.length) . At� mesmo o
     return n�o � necess�rio, j� que s� temos uma instru��o ap�s o -> 
		 * */
		
		System.out.println(listaNomes2);
		
		
		/*
		Uma outra novidade apartir do Java 8 � a possibilidade de declarar m�todos concretos dentro de uma
       interface, os chamados default methods. At� o Java 7 n�o existia sort em listas. Colocar um novo
       m�todo abstrato em uma interface pode ter consequ�ncias dr�sticas: todo mundo que a implementava
       para de compilar! Mas colocar um m�todo default n�o tem esse mesmo impacto devastador, j� que as
       classes que implementama interface 'herdam' esse m�todo. Ent�o voc� pode fazer:
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
		
		/*H� outros m�todos nas cole��es que utilizam do lambda para serem mais sucintos.
          Um deles � o forEach .*/
		
		//listaNomes4.forEach((s1,s2)-> System.out.println(s1, s2));
		
		
		
	}
}
