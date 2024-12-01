// 2024 jun 11

#include <iostream>
using namespace std;

int main() {
    int square = 0;
    int add = 0;
    for(int i = 1; i < 101; i++) {
        square += pow(i, 2);
        add += i;
    }
    printf("%.0f", pow(add, 2) - square);
}