// Land Equality
// September 2022

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    int row, col;
    cin >> row >> col;

    int size = row * col;

    int zeros = 0, twos = 0;

    for(int i = 0; i < size; i += 1) {
        int d;
        cin >> d;
        if(d == 0) {
            zeros += 1;
        } else if(d == 2) {
            twos += 1;
        }

        if(zeros >= 2) {
            break;
        }
    }

    if(zeros >= 2 || twos % 2 == 0) {
        cout << 0 << endl;
    } else {
        cout << pow(2, (twos+1)/2) - pow(2, (twos-1)/2) << endl;
    }
}
