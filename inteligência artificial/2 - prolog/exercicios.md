# Domínio: Sistema Escolar

1) Pré-requisitos: Crie fatos disciplina(Nome) e pre_requisito(Anterior, Posterior). Escreva uma regra pode_cursar(Aluno, Disciplina) que verifica se o aluno já completou os requisitos necessários.

2) Aprovação: Com fatos nota(Aluno, Disciplina, Valor), crie a regra aprovado(Aluno, Disciplina) (nota >= 7.0) e reprovado (Aluno, Disciplina) (nota < 7.0).

```prolog
disciplina("Inteligência Artificial").
disciplina("Estrutura de Dados").
disciplina("Algoritmos B").

pre_requisito("Algoritmos B", "Estrutura de Dados").
pre_requisito("Estrutura de Dados", "Inteligência Artificial").

ja_cursou("Freitas", "Algoritmos B").
ja_cursou("Luiza", "Estrutura de Dados").


nota("Luiza", "Estrutura de Dados", 8).
nota("Luiza", "Inteligência Artificial", 6).


pode_cursar(Aluno, Disciplina) :-
	ja_cursou(Aluno, Pre),
	pre_requisito(Pre, Disciplina).

aprovado(Aluno, Disciplina) :-
    nota(Aluno, Disciplina, Valor),
    Valor >= 7.
 
reprovado(Aluno, Disciplina) :-
    nota(Aluno, Disciplina, Valor),
    Valor < 7.
```

# Domínio: Logística e Locação

3) Conectividade de Cidades: Defina fatos estrada(CidadeA, CidadeB). Crie a regra pode_viajar(De, Para) que indica se há uma conexão direta. Bônus: discuta por que estrada(a, b) não implica automaticamente estrada(b, a) sem uma regra de simetria.

5) Localização: Use fatos esta_em(Objeto, Comodo) e comodo_em(Comodo, Casa). Crie a regra localizacao_geral(Objeto, Casa) para inferir onde o objeto está no nível da propriedade.

```prolog
estrada("Santa Maria", "Sao Borja").

pode_viajar(CidadeA, CidadeB) :-
    estrada(CidadeA, CidadeB).

esta_em("Caneca", "Quarto").
comodo_em("Quarto", "CasaLuiza").

localizacao_geral(Objeto, Casa) :-
    esta_em(Objeto, Comodo),
    comodo_em(Comodo, Casa).
```

# Domínio: Recomendação e Preferências

5) Cardápio: Crie fatos ingrediente(Prato, Item) e vegano(Item). Escreva a regra prato_vegano(Prato) que é verdadeira apenas se todos os ingredientes forem veganos (útil para introduzir o conceito de negação ou falha).

6) Streaming: Com fatos filme(Nome, Genero) e usuario_gosta(Usuario, Genero), crie a regra recomendar(Filme, Usuario).

```prolog

```

# Domínio: Mundo de Blocos (Clássico da IA)

7) jl

# Domínio: Classificação e Regras de Negócio

8) jio
9) hl
10) jikl
