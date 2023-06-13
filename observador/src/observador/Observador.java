
package observador;

import java.util.ArrayList;
import java.util.List;

    // Interface Observador
    interface Observer{
        void update(Bebidas bebidas);
    }

    // Classe Sujeito
    class Subject{
        private List<Observer> observers = new ArrayList<>();
        private Bebidas bebidas;
    
        public void addObserver(Observer observer){
            observers.add(observer);
        }
    
        public void removeObserver(Observer observer){
            observers.remove(observer);
        }
    
        public void notifyObservers(){
            for (Observer observer : observers){
                observer.update(bebidas);
            }
        }
    
        public void setBebida(Bebidas bebidas){
            this.bebidas = bebidas;
            notifyObservers();
        }
    
        public Bebidas getBebida(){
            return bebidas;
        }
    }

    // Classe Bebidas
    class Bebidas{
        private String nome;
        
        public Bebidas(String nome){
            this.nome = nome;
        }
    
        public String getNome(){
            return nome;
        }
    
        public void setNome(String nome){
            this.nome = nome;
        }
    }

    // Classe TipoBebidas (Observador concreto)
        class TipoBebidas implements Observer{
        private String tipo;
    
        public TipoBebidas(String tipo){
            this.tipo = tipo;
        }
    
        public void update(Bebidas bebidas){
            System.out.println("Tipo de bebida: " + tipo + 
                    ", Bebida atual: " + bebidas.getNome());
        }
    }

    // Exemplo de uso do padrão Observer
    public class Observador {
        public static void main(String[] args){
            // Cria o sujeito
            Subject subject = new Subject();
        
            // Cria os observadores
            TipoBebidas observador1 = new TipoBebidas("Refrigerante");
            TipoBebidas observador2 = new TipoBebidas("Cafe");
        
            // Adiciona os observadores ao sujeito
            subject.addObserver(observador1);
            subject.addObserver(observador2);
        
            // Define uma bebida no sujeito
            Bebidas bebida = new Bebidas("Coca-Cola");
            subject.setBebida(bebida);
        
            // Resultado esperado: os observadores receberão a notificação da nova bebida
        
            // Modifica a bebida no sujeito
            Bebidas novaBebida = new Bebidas("Cafe Expresso");
            subject.setBebida(novaBebida);
        
            // Resultado esperado: os observadores receberão a notificação da nova bebida
        }
    }
