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

```prolog
ingrediente(salada, alface).
ingrediente(salada, tomate).
ingrediente(salada, cenoura).
ingrediente(churrasco,arroz).
ingrediente(churrasco,carne).
 
 
vegano(alface).
vegano(tomate).
vegano(cenoura).
vegano(pao).
vegano(arroz).
 
prato_vegano(Prato) :-
    ingrediente(Prato, _),
    forall(ingrediente(Prato, Item), vegano(Item)).
```

6) Streaming: Com fatos filme(Nome, Genero) e usuario_gosta(Usuario, Genero), crie a regra recomendar(Filme, Usuario).


```prolog
%filme(Nome,Genero).
filme(star_wars,ficcao).
filme(senhor_dos_aneis,fantasia).
filme(hobbit,fantasia).
filme(blade_runner,ficcao).
filme(it,terror).
filme(exorcista,terror).

usuario_gosta(alex,ficcao).
usuario_gosta(alex,fantasia).
usuario_gosta(bernardo,terror).
usuario_gosta(andrisa,terror).

recomendar(F,U) :-
    filme(F,Genero),
    usuario_gosta(U,Genero).
```

# Domínio: Mundo de Blocos (Clássico da IA)

7) jl

```prolog
% 4
% 3
% 2
% 1
% 0

sobre(4,3).
sobre(3,2).
sobre(2,1).
sobre(1,0).

abaixo(BAb, BAc) :-
    sobre(BAc, BAb).

abaixo(BAb, BAc) :-
    sobre(BAc, I),
    abaixo(BAb, I).
```

# Domínio: Classificação e Regras de Negócio

8) jio
9) hl
10) jikl

```prolog
tem_penas(pinguim).
tem_penas(galinha).
tem_penas(coruja).

poe_ovos(pinguim).
poe_ovos(galinha).
poe_ovos(coruja).

ave(A) :-
    tem_penas(A),
	poe_ovos(A).

%%%%%%

cliente(luly,1000).
cliente(alex,4).
cliente(germano,300).

produto(risoles,8).
produto(sanduiche,10).
produto(chocolate,5).
produto(cafezinho,2).

pode_comprar(C,P) :-
    cliente(C,Saldo),
    produto(P,Custo),
    Saldo >= Custo.

%%%%%%

time(gramado).
time(canela).
time(santa_maria).
 
venceu(gramado, canela).
venceu(gramado, santa_maria).
venceu(canela, santa_maria).
venceu(santa_maria, canela).
 
invicto(X) :-
    time(X),
    not(venceu(_, X)).
```
