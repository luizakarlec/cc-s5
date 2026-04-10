# Missionarios e Canibais
Três missionários e três canibais estão à beira de um rio e dispõem de um barco com capacidade para apenas duas pessoas. O problema consiste em determinar as tripulações de uma série de travessias de forma que todo o grupo atravesse para o outro lado do rio, respeitando a condição de que, em nenhum momento, os canibais sejam mais numerosos do que os missionários em qualquer uma das margens.

## Estados do Problema 
São representados por ``(mE, cE, mD, cD, barco)``

### Estado inicial (todos na esquerda)
```
mE = 3
cE = 3
mD = 0
cD = 0
barco = 'e'
```
### Estado final - (todos na direita)
```
mE = 0
cE = 0
mD = 3
cD = 3
barco = 'd'
```

## Regras de transição
Métodos da Classe
1) doisCanibais
2) doisMissionarios
3) umCanibal
4) umMissionario
5) canibalMissionario 

## Visitados
Cada estado visitado é armazenado no HashSet visitados

## Restrições
```
mE > 0 && mE < cE //se existem missionários na esquerda, não podem ser ser menos que os canibais
mD > 0 && mD < cD //se existem missionários na direita, não podem ser menos que os canibais
```

## Verificações
1) é válido?
2) foi visitado?
3) é a meta/objetivo?


