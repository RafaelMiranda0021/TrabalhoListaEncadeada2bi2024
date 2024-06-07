package br.unipar.trabalho_lista_encadeada2bi;


public class Cliente {
    int codigo;
    String nome;
    String Nascimento;
    String telefone;
    Cliente anterior;
    Cliente proximo;

    public Cliente(int codigo, String nome, String Nascimento, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.Nascimento = Nascimento;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Data de Nascimento: " + Nascimento + ", Telefone: " + telefone;
    }
}

class ListaDuplamenteEncadeada {
    Cliente primeiro;
    Cliente ultimo;

    public void adicionar(Cliente novo) {
        if (primeiro == null) {
            primeiro = ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }
    }

    public boolean remover(int codigo) {
        Cliente presente = primeiro;
        while (presente != null && presente.codigo != codigo) {
            presente = presente.proximo;
        }

        if (presente == null) {
            return false;
        }

        if (presente == primeiro) {
            primeiro = presente.proximo;
        } else {
            presente.anterior.proximo = presente.proximo;
        }

        if (presente == ultimo) {
            ultimo = presente.anterior;
        } else {
            presente.proximo.anterior = presente.anterior;
        }

        return true;
    }

    public Cliente buscar(int codigo) {
        Cliente atual = primeiro;
        while (atual != null && atual.codigo != codigo) {
            atual = atual.proximo;
        }
        return atual;
    }

    public String listarTodos() {
        StringBuilder sb = new StringBuilder();
        Cliente atual = primeiro;
        while (atual != null) {
            sb.append(atual.toString()).append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }
}
