import random

class Util:
    cidades = "123456789"
    tamanho = len(cidades)
    
    @staticmethod
    def gerar_rota(n):     
        rotas = ''

        for i in range(n):
            # [123456789].shuffle para não gerar rotas com números iguais
            rotas += Util.cidades[random.randrange(Util.tamanho)]
        
        return rotas
        
