# Problema Trem-Empacotador

Projeto de Sistemas Operacionais - IFCE - 2022.1

## O problema:  
Considere a seguinte situação: Um trem de carga transporta caixas com produtos entre as
localidades **A** e **B**, mas só quando a quantidade de caixas acumuladas chegar a **N**. Inicialmente, o
trem fica parado (bloqueado) em **A** enquanto não houver **N** caixas para transportar. Quando a
quantidade de caixas chegar a **N**, o trem deve transportar exatamente **N** caixas de **A** para **B**, e em
seguida voltar para **A**. Caso existam outras **N** caixas, o trem parte imediatamente; caso contrário,
o trem fica parado (bloqueado) novamente até que existam as **N** caixas. Os produtos a serem
transportados são embalados nas caixas pelos empacotadores; cada empacotador, quando tem
uma caixa pronta, coloca a caixa em um depósito da estação de trem que tem capacidade para
armazenar **M** caixas (**M** ≥ **N**). Cada empacotador trabalha continuamente embalando caixas e
armazenando no depósito. Quando o depósito estiver cheio, os empacotadores que tentarem
armazenar suas caixas devem dormir (bloqueados). Usando semáforos, modele o thread trem e o
thread empacotador, lembrando que podem existir muitos empacotadores e apenas um trem.  
## Configuração:  
**M** = quantidade de caixas que podem ser armazenadas no depósito da estação de trem.  
## Thread Trem:  
Durante a criação do thread trem devem ser definidos os seguintes parâmetros:  
- **N** = quantidade de caixas que devem ser transportadas pelo trem.  
- **tv** = tempo de viagem (tempo que o trem gasta para viajar de A até B e vice-versa). A
interface deve mostrar que o processo trem está executando durante todo este tempo com o
status “viajando de A para B” ou “viajando de B para A”.  

![TremDeCarga](https://github.com/mateuzin/Projeto-Trem-Empacotador/assets/75508372/8fe849de-b3b7-4b51-b958-852cc93b9493)

## Thread Empacotador:  
Durante a criação do thread empacotador devem ser definidos os seguintes parâmetros:  
- **id** = identificador do empacotador.
- **te** = tempo de empacotamento (tempo que o empacotador gasta para embalar uma caixa). A
interface deve mostrar que o empacotador está executando durante todo este tempo com o
status “empacotando”.  
## Observação:
A interface deve mostrar, a cada instante, a quantidade de caixas armazenadas no depósito e o
status de cada processo empacotador (empacotando, colocando a caixa no depósito ou dormindo)
e do processo trem (viajando de **A** para **B**, viajando de **B**, para **A** ou parado).

Foi utilizada a versão 17 do JDK nesse projeto, podendo apresentar possiveis erros de compatibilidade com versões anteriores.

![Empacotadores](https://github.com/mateuzin/Projeto-Trem-Empacotador/assets/75508372/d9d7c921-e6b4-4e9b-b59b-5b1b8e54ceb9)

