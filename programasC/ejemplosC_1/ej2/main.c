#include <stdio.h>
#include <stdlib.h>
#include "header.h"
int main(void){
    printf("Se obtuvo el valor: %d", returnSeven());
    printf("\n");
    printf("Se obtuvo el valor: %d", returnParam(255));
    printf("\n");
    return EXIT_SUCCESS;
}
