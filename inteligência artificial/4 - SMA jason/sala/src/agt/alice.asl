laboratorio(ia, 101).
laboratorio(ed, 108).
laboratorio(redes, 316).

!start.

+!start : true 
    <- 
        .print("hello world.");
        .send(bob, tell, lanche(sanduiche)).

+!kqml_received(Agente, askOne, laboratorio(Disciplina, Laboratorio), MsgId)
    <- 
        .print(Agente, " está perguntando qual o laboratório de ", Disciplina, "que é no ", Laboratorio);
        ?laboratorio(Disciplina, Laboratorio);
        .send(Agente, reply, laboratorio(Disciplina, Laboratorio), MsgId).
