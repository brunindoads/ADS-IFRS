#include <time.h> //Contagem do tempo.
#include <sys/time.h>
#include <Windows.h>
#include "binarysearch.h"
#include "dataset.h"

int binarySearch(int data[], int size, int value) {
    int start = 0;
    int end = size - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        // Verifica se o valor está no meio do array
        if (data[mid] == value) {
            return mid;
        }

        // Se o valor for menor que o valor do meio, descarta a metade direita
        if (data[mid] > value) {
            end = mid - 1;
        }
        // Se o valor for maior que o valor do meio, descarta a metade esquerda
        else {
            start = mid + 1;
        }
    }

    // Valor não encontrado
    return -1;
}

void timeBinarySearch(int data[], int size, int value_1, int value_2, int value_3, int value_4, int value_5, int value_6, int value_7, int value_8, int value_9, int value_10, int data_set){
    // Medição de tempo
    long long start = getTime();
    
    // Faz 10 buscas de 10 valores diferente, mas ainda assim, o tempo é insignificante.
    int index_1 = binarySearch(data, size, value_1); // Faz a busca.
    int index_2 = binarySearch(data, size, value_2); // Faz a busca.
    int index_3 = binarySearch(data, size, value_3); // Faz a busca.
    int index_4 = binarySearch(data, size, value_4); // Faz a busca.
    int index_5 = binarySearch(data, size, value_5); // Faz a busca.
    int index_6 = binarySearch(data, size, value_6); // Faz a busca.
    int index_7 = binarySearch(data, size, value_7); // Faz a busca.
    int index_8 = binarySearch(data, size, value_8); // Faz a busca.
    int index_9 = binarySearch(data, size, value_9); // Faz a busca.
    int index_10 = binarySearch(data, size, value_10); // Faz a busca.
    
    long long end = getTime(); // Finaliza o tempo.
    double cpu_time_used = (end - start) / 1000000.0; // Faz o cálculo de quantos segundos.
    
    if(index_1 != -1 || index_2 != -1 || index_3 != -1 || index_4 != -1 || index_5 != -1 || index_6 != -1 || index_7 != -1 || index_8 != -1 || index_9 != -1 || index_10 != -1) printf("Binary Search;%d;%f\n", data_set, cpu_time_used); // Imprime na tela mostrando qual conjunto utilizado o tempo exigido para ordenação.
    else printf("Binary Search;%d;NULL\n", data_set);
}

long long getTime() {
    FILETIME tempoArquivo;
    GetSystemTimeAsFileTime(&tempoArquivo);

    ULARGE_INTEGER tempo;
    tempo.LowPart = tempoArquivo.dwLowDateTime;
    tempo.HighPart = tempoArquivo.dwHighDateTime;

    return tempo.QuadPart / 10; // Converter para microssegundos
}

