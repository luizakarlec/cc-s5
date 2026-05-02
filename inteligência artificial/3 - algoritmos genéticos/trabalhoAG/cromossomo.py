class Cromossomo:

    def __init__(self, valor, estado_final):
        self.valor = valor
        self.aptidao = self.calcular_aptidao(estado_final)
    
    def calcular_aptidao(self, estado_final):
        nota = 0
        for i in range(len(estado_final) - 1):
            # se uma cidade de número maior vier primeiro que uma cidade de número menor = 10
            if (self.valor[i] > self.valor[i+1]):
               nota += 10

        for i in range(len(estado_final)):
            # se na rota aparecer mais de uma vez a mesma cidade (número) = 20
            for j in range(len(estado_final)):
                if (self.valor[i] == self.valor[j] and i != j):
                    nota += 10
            
        return nota
    
    def __eq__(self, other):
        if isinstance(other, Cromossomo):
            return self.valor == other.valor
        return False
    
    def __gt__(self, other):
        return self.aptidao <= other.aptidao
    
    def __str__(self):
        return f"valor= {self.valor}, aptidao= {self.aptidao}"
        # return "valor=" + str(self.valor) + ", aptidao=" + str(self.aptidao )