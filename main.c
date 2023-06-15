#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <locale.h> // Validação da acentuação e caracteres especiais.

// Inclusão das funções.
#include "bubblesort.h"
#include "selectionsort.h"
#include "binarysearch.h"
#include "linearsearch.h"
#include "dataset.h"

// Tamanhos dos conjuntos de dados.
#define SIZE1 50000
#define SIZE2 100000
#define SIZE3 150000
#define SIZE4 200000

 // Inicia cada array para cada conjunto de dados.
  int* data_1;
  int* data_2;
  int* data_3;
  int* data_4;
  
// Contador
int count = 1; 

int main(int argc, char *argv[])
{
  setlocale(LC_ALL, "Portuguese"); // Validação da acentuação e caracteres especiais.
  
  int loading = 0;
  printf("Gerando arquivo CSV com os dados. Por favor, aguarde!");
  
  // Alocação de memória para garantir o trabalho com grandes dados.
  data_1 = (int*)malloc(SIZE1*sizeof(int));
  data_2 = (int*)malloc(SIZE2*sizeof(int));
  data_3 = (int*)malloc(SIZE3*sizeof(int));
  data_4 = (int*)malloc(SIZE4*sizeof(int));
  
  // Verificação da alocação.
  if (data_1 == NULL || data_2 == NULL || data_3 == NULL || data_4 == NULL) {
        printf("\nErro na alocação de memória. Execute o programa novamente.\n");
        return 1;
  }
  
  FILE *file = fopen("dados.csv", "w"); // Abre o arquivo para escrita.

  if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
  }

  freopen("dados.csv", "w", stdout); // Redireciona a saída padrão para o arquivo.
  
  while(count != 11){
  // Controle das rodadas.
  printf("Rodada de numero %d.\n\n", count);
  
  // Cabeçalho do CSV.
  printf("ALGORITMO;DATA_SET;SEGUNDOS\n");
  
  generateData(data_1, SIZE1); // Geração do conjunto de dados 1.
  generateData(data_2, SIZE2); // Geração do conjunto de dados 2.
  generateData(data_3, SIZE3); // Geração do conjunto de dados 3.
  generateData(data_4, SIZE4); // Geração do conjunto de dados 4.
  
  timeSelectionSort(data_1, SIZE1, 1); // Chama a função de ordenação para conjunto de dados 1.
  timeSelectionSort(data_2, SIZE2, 2); // Chama a função de ordenação para conjunto de dados 2.
  timeSelectionSort(data_3, SIZE3, 3); // Chama a função de ordenação para conjunto de dados 3.
  timeSelectionSort(data_4, SIZE4, 4); // Chama a função de ordenação para conjunto de dados 4.
  
  generateData(data_1, SIZE1); // Geração do conjunto de dados 1.
  generateData(data_2, SIZE2); // Geração do conjunto de dados 2.
  generateData(data_3, SIZE3); // Geração do conjunto de dados 3.
  generateData(data_4, SIZE4); // Geração do conjunto de dados 4.
    
  timeBubbleSort(data_1, SIZE1, 1); // Chama a função de ordenação para conjunto de dados 1.
  timeBubbleSort(data_2, SIZE2, 2); // Chama a função de ordenação para conjunto de dados 2.
  timeBubbleSort(data_3, SIZE3, 3); // Chama a função de ordenação para conjunto de dados 3.
  timeBubbleSort(data_4, SIZE4, 4); // Chama a função de ordenação para conjunto de dados 4.
  
  timeBinarySearch(data_1, SIZE1, 70, 746, 15879, 48567, 41256, 12, 358, 5874, 14569, 21548, 1); // Chama a função de busca para conjunto de dados 1.  
  timeBinarySearch(data_2, SIZE2, 9521, 746, 15879, 32569, 94586, 12, 358, 5874, 100, 21548, 2); // Chama a função de busca para conjunto de dados 2.
  timeBinarySearch(data_3, SIZE3, 10000, 746, 15879, 48567, 52, 12, 358, 5874, 14569, 145200, 3); // Chama a função de busca para conjunto de dados 3.
  timeBinarySearch(data_4, SIZE4, 36458, 152000, 15879, 48567, 41256, 12, 3, 5874, 48952, 21548, 4); // Chama a função de busca para conjunto de dados 4.
  
  generateData(data_1, SIZE1); // Geração do conjunto de dados 1.
  generateData(data_2, SIZE2); // Geração do conjunto de dados 2.
  generateData(data_3, SIZE3); // Geração do conjunto de dados 3.
  generateData(data_4, SIZE4); // Geração do conjunto de dados 4.
  
  timeLinearSearch(data_1, SIZE1, 70, 746, 15879, 48567, 41256, 12, 358, 5874, 14569, 21548, 1); // Chama a função de busca para conjunto de dados 1.  
  timeLinearSearch(data_2, SIZE2, 9521, 746, 15879, 32569, 94586, 12, 358, 5874, 100, 21548, 2); // Chama a função de busca para conjunto de dados 2.
  timeLinearSearch(data_3, SIZE3, 10000, 746, 15879, 48567, 52, 12, 358, 5874, 14569, 145200, 3); // Chama a função de busca para conjunto de dados 3.
  timeLinearSearch(data_4, SIZE4, 36458, 152000, 15879, 48567, 41256, 12, 3, 5874, 48952, 21548, 4); // Chama a função de busca para conjunto de dados 4.
  
  count++;
  
  printf("\n");
  } // Encerra o While.
  
  // Libera a memória.
  free(data_1);
  free(data_2);
  free(data_3);
  free(data_4);
  
  fclose(file); // Fecha o arquivo.
  freopen("CON", "w", stdout); // Retorna a saída padrão para o console.
  printf("Arquivo CSV gerado com sucesso!\n");
  system("start dados.csv"); // Abre o arquivo gerado.
  
  system("PAUSE");	
  return 0;
}

