import random

class Util:
    cidades = "123456789"
    tamanho = len(cidades)
    
    @staticmethod
    def gerar_rota(n):     
        rotas = ''

        for i in range(n):
            rotas += Util.cidades[random.randrange(Util.tamanho)]
        
        return rotas
        