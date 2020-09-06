/** Autor: Samuel da Costa Araujo Nunes
 *Componente Curricular: MI-Programação
 *Concluido em: 22/01/2020
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package Util;

import Model.Autor;
import Model.Livro;
import java.util.ArrayList;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class ArvoreBinariaBusca {

//--------------------------Declaração de atributos---------------------------//
    private No raiz;

//--------------------------Declaração do contrutor---------------------------//
    /**
     * Este é o metodo contrutor, responsavel por inicializar o objeto da classe
     * ArvoreBinariaBusca, criando um nó Raiz.
     */
    public ArvoreBinariaBusca() {
        raiz = new No();
    }

//----------------------------------GetRaiz-----------------------------------//
    /**
     * Metodo que retorna o nó raiz da arvore.
     *
     * @return A raiz da árvore
     */
    public No getRaiz() {
        return raiz;
    }
//--------------------------------temFilhos-----------------------------------//

    /**
     * Este metodo avalia se um nó, possui algum filho.
     *
     * @param pai Um nó, que será avalido.
     * @return Um valor lógico, indicando se há ou não a presença de um filho no
     * nó.
     */
    public boolean temFilhos(No pai) {
        return pai.getEsquerda() != null || pai.getDireita() != null;
    }
//----------------------------------Inserir-----------------------------------//

    /**
     * Este método é responsavel por inserir, um Livro a estrutura de dados.
     *
     * @param livro Um livro da classe Livro, que será inserido.
     */
    public void inserir(Livro livro) {
        if (raiz.getLivro() != null) {
            if (livro.getNumEbook() > raiz.getLivro().getNumEbook()) {
                inserir(raiz.getDireita(), livro, raiz);
            } else if (livro.getNumEbook() < raiz.getLivro().getNumEbook()) {
                inserir(raiz.getEsquerda(), livro, raiz);
            }
        } else {
            raiz.setLivro(livro);
        }

    }

    private void inserir(No no, Livro livro, No pai) {
        if (no != null) {
            if (livro.getNumEbook() > no.getLivro().getNumEbook()) {
                inserir(no.getDireita(), livro, no);
            } else if (livro.getNumEbook() < no.getLivro().getNumEbook()) {
                inserir(no.getEsquerda(), livro, no);
            }
        } else {
            if (livro.getNumEbook() > pai.getLivro().getNumEbook()) {
                pai.setDireita(new No(livro));
            } else if (livro.getNumEbook() < pai.getLivro().getNumEbook()) {
                pai.setEsquerda(new No(livro));
            }
        }
    }
//--------------------------------Deletar-------------------------------------//

    /**
     * Este método é responsavel por excluir um Objeto Livro da estrutura de
     * dados, usando como atributo chave o Id do Ebook.
     *
     * @param id Id do Ebook, que deverá ser deletado
     * @return O Livro deletado da arvore.
     */
    public Livro remover(int id) {
        if (raiz.getLivro() != null) {
            Livro livroAtual = raiz.getLivro();
            if (livroAtual.getNumEbook() > id) {
                return remover(raiz.getEsquerda(), id);
            } else if (livroAtual.getNumEbook() < id) {
                return remover(raiz.getDireita(), id);
            } //Achou o nó a ser removido
            else {
                //1o caso: Nó sem filhos
                if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                    raiz.setLivro(null);
                } //2o caso: Nó apenas com filho a direita
                else if (raiz.getEsquerda() == null) {
                    No aux = raiz.getDireita();
                    raiz = aux;
                } //3o caso: Nó apenas com filho a esquerda
                else if (raiz.getDireita() == null) {
                    No aux = raiz.getEsquerda();
                    raiz = aux;
                } //4o caso: Nó com dois filhos.
                else {
                    No aux = raiz.getDireita();
                    No auxPai = raiz;
                    while (aux.getEsquerda() != null) {
                        auxPai = aux;
                        aux = aux.getEsquerda();
                    }
                    raiz.setLivro(aux.getLivro());
                    auxPai.setEsquerda(null);
                }
                return livroAtual;
            }
        }
        return null;
    }

    private Livro remover(No no, int id) {
        if (no.getLivro() != null) {
            Livro livroAtual = no.getLivro();
            if (livroAtual.getNumEbook() > id) {
                return remover(no.getEsquerda(), id);
            } else if (livroAtual.getNumEbook() < id) {
                return remover(no.getDireita(), id);
            } //Achou o nó a ser removido
            else {
                //1o caso: Nó sem filhos
                if (no.getEsquerda() == null && no.getDireita() == null) {
                    no.setLivro(null);
                } //2o caso: Nó apenas com filho a direita
                else if (no.getEsquerda() == null) {
                    No aux = no.getDireita();
                    no.setDireita(aux.getDireita());
                    no.setEsquerda(aux.getEsquerda());
                    no.setLivro(aux.getLivro());
                } //3o caso: Nó apenas com filho a esquerda
                else if (no.getDireita() == null) {
                    No aux = no.getEsquerda();
                    no.setDireita(aux.getDireita());
                    no.setEsquerda(aux.getEsquerda());
                    no.setLivro(aux.getLivro());
                } //4o caso: Nó com dois filhos.
                else {
                    No aux = no.getDireita();
                    No auxPai = no;
                    while (aux.getEsquerda() != null) {
                        auxPai = aux;
                        aux = aux.getEsquerda();
                    }
                    no.setLivro(aux.getLivro()); 
                    auxPai.setEsquerda(null);
                }
                return livroAtual;
            }
        }
        return null;
    }

//--------------------------ListQuantLivroPorAutor----------------------------//
    private ArrayList<Autor> listQuantidadeLivrosPorAutor;

    /**
     * Este método é responsavel por listar a quantidade de Livros escrito por
     * um autor, de todos os autores catalogados.
     */
    public void listarAutorPorQuantidade() {
        listQuantidadeLivrosPorAutor = new ArrayList();
        listarAutorPorQuantidade(raiz.getEsquerda());
        if (listQuantidadeLivrosPorAutor.isEmpty()) {
            Autor autor = new Autor(raiz.getLivro().getAutor(), 1);
            listQuantidadeLivrosPorAutor.add(autor);
        } else {
            Boolean verificador = false;
            String autorAtual = raiz.getLivro().getAutor();
            for (Autor autor : listQuantidadeLivrosPorAutor) {
                if (autorAtual.equals(autor.getNome())) {
                    autor.setQuantLivros(autor.getQuantLivros() + 1);
                    verificador = true;
                }
            }
            if (!verificador) {
                Autor autor = new Autor(raiz.getLivro().getAutor(), 1);
                listQuantidadeLivrosPorAutor.add(autor);
            }

        }
        listarAutorPorQuantidade(raiz.getDireita());

        listQuantidadeLivrosPorAutor.forEach((autor) -> {
            autor.displayAutor();
        });
        listQuantidadeLivrosPorAutor = null;
    }

    private void listarAutorPorQuantidade(No no) {
        if (no != null) {
            listarAutorPorQuantidade(no.getEsquerda());

            if (listQuantidadeLivrosPorAutor.isEmpty()) {
                Autor autor = new Autor(no.getLivro().getAutor(), 1);
                listQuantidadeLivrosPorAutor.add(autor);
            } else {
                Boolean verificador = false;
                String autorAtual = no.getLivro().getAutor();
                for (Autor autor : listQuantidadeLivrosPorAutor) {
                    if (autorAtual.equals(autor.getNome())) {
                        autor.setQuantLivros(autor.getQuantLivros() + 1);
                        verificador = true;
                    }
                }
                if (!verificador) {
                    Autor autor = new Autor(no.getLivro().getAutor(), 1);
                    listQuantidadeLivrosPorAutor.add(autor);
                }

            }

            listarAutorPorQuantidade(no.getDireita());
        }
    }

//---------------------------ListLivrosDoAutor--------------------------------//
    private ArrayList<Livro> livrosDoAutor;

    /**
     * Este método é responsavel por achar os livros escritos por um autor
     * especifico.
     *
     * @param nomeDoAutor O nome do autor que deverá ser buscado.
     */
    public void listLivrosDoAutor(String nomeDoAutor) {
        if (raiz != null) {
            livrosDoAutor = new ArrayList();
            listLivrosDoAutor(raiz.getEsquerda(), nomeDoAutor);
            if (nomeDoAutor.equals(raiz.getLivro().getAutor())) {
                livrosDoAutor.add(raiz.getLivro());
            }
            listLivrosDoAutor(raiz.getDireita(), nomeDoAutor);

            if (livrosDoAutor.isEmpty()) {
                System.out.println("Não foi encontrado nenhum autor com esse nome!!");
            }

            int contador = 0;
            while (contador < livrosDoAutor.size()) {
                Livro aux = livrosDoAutor.get(contador);
                aux.displayLivroUI();
                contador++;
            }

            return;
        }
        System.out.println("A Arvore está vazia!!");
    }

    private void listLivrosDoAutor(No no, String nomeDoAutor) {
        if (no != null) {
            listLivrosDoAutor(no.getEsquerda(), nomeDoAutor);
            if (nomeDoAutor.equals(no.getLivro().getAutor())) {
                livrosDoAutor.add(no.getLivro());
            }
            listLivrosDoAutor(no.getDireita(), nomeDoAutor);
        }
    }

//-----------------------------DisplayOrdem-----------------------------------//
    /**
     * Este método é responsavel por imprimir para o usuario, a lista de livros
     * catalogados seguindo a ordem crescentes dos Ids de Ebook.
     */
    public void displayOrdem() {
        if (raiz != null) {
            displayOrdem(raiz.getEsquerda());// Por ser recusivo, este metodo 
                                           //alcança até o ultimo nó a esquerda
            raiz.getLivro().displayLivroUI();
            displayOrdem(raiz.getDireita());
        }
    }

    private void displayOrdem(No no) {
        if (no != null) {
            displayOrdem(no.getEsquerda());
            no.getLivro().displayLivroUI();
            displayOrdem(no.getDireita());
        }
    }

//---------------------------------Find---------------------------------------//
    /**
     * Este método é responsavel por procurar e retornar um Livro cadastrado na
     * estrutura de dados, usando como parametro o seu Id de Ebook.
     *
     * @param id Id do Ebook, a ser procurado.
     * @return Livro, que possui o Id do Ebook.
     */
    public Livro find(int id) {
        if (raiz.getLivro() != null) {
            if (id > raiz.getLivro().getNumEbook()) {
                return find(raiz.getDireita(), id);
            } else if (id < raiz.getLivro().getNumEbook()) {
                return find(raiz.getEsquerda(), id);
            } else {
                return raiz.getLivro();
            }
        } else {
            return null;
        }

    }

    private Livro find(No no, int id) {
        if (no != null) {
            if (id > no.getLivro().getNumEbook()) {
                return find(no.getDireita(), id);
            } else if (id < no.getLivro().getNumEbook()) {
                return find(no.getEsquerda(), id);
            } else {
                return no.getLivro();
            }
        } else {
            return null;
        }
    }
//---------------------------------FindAno------------------------------------//
    private ArrayList listaLivroPorAno;

    /**
     * Este método é responsavel por criar uma lista, contendo todos os livros
     * publicados em um certo ano.
     *
     * @param ano Ano em que, os livros foram escritos.
     * @return Retorna uma <b>ArrayList</b>, contendo todos os Livros do ano
     * esperado.
     */
    public ArrayList findAno(int ano) {
        listaLivroPorAno = new ArrayList();
        if (raiz != null) {
            if (raiz.getLivro().getAno() == ano) {
                listaLivroPorAno.add(raiz.getLivro());
            }
            findAno(raiz.getEsquerda(), ano);
            findAno(raiz.getDireita(), ano);
        }
        return listaLivroPorAno;
    }

    private void findAno(No no, int ano) {
        if (no != null) {
            if (no.getLivro().getAno() == ano) {
                listaLivroPorAno.add(no.getLivro());
            }
            findAno(no.getEsquerda(), ano);
            findAno(no.getDireita(), ano);
        }
    }
//--------------------------------IsEmpty-------------------------------------//

    /**
     * Este método é responsavel por verificar se a estrutura de dados está
     * vazia.
     *
     * @return Um valor lógico, indicando se a Árvore está vazia ou não.
     */
    public boolean isEmpty() {
        return raiz == null || raiz.getLivro() == null;
    }
//--------------------------GerarListaEmPreOrdem------------------------------//    
    ArrayList listaOrdenada;

    /**
     * Este método é responsavel por criar uma lista, contendo todos os livros
     * contidos na estrutura de dados, em pré ordem.
     *
     * @return Retorna uma <b>ArrayList</b>, contendo todos os Livros em
     * pré-ordem.
     */
    public ArrayList gerarListaEmPreOrdem() {
        listaOrdenada = new ArrayList();
        if (raiz != null) {
            listaOrdenada.add(raiz.getLivro());
            incluirLista(raiz.getEsquerda());
            incluirLista(raiz.getDireita());
        }
        return listaOrdenada;
    }

    private void incluirLista(No no) {
        if (no != null) {
            listaOrdenada.add(no.getLivro());
            incluirLista(no.getEsquerda());
            incluirLista(no.getDireita());
        }
    }

//----------------------------------------------------------------------------//
}
