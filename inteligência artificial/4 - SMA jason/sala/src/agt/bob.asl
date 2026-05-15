time(gremio).
idade(19).
disciplina(ia, sexta).
disciplina(ed, quarta).

!start.

+!start : true 
    <- 
        .print("hello world.").

+dia(Dia) : disciplina(Disciplina, Dia)
    <-
        .print("Oba, tenho aula de IA! Alice, qual é o laboratório?");
        .send(alice, askOne, laboratorio(Disciplina, Laboratorio), MsgId).