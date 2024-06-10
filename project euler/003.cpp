#include <iostream>

using namespace std;

int smallestPrime(long int n) {
    long int stop = sqrt(n);
    for(int i = 2; i < stop + 1; i += 1) {
        if(n % i == 0) {
            return i;
        } 
    }
    return -1;
}

int main() {
    long int val = 600851475143;
    while(smallestPrime(val) != -1) {
        int pr = smallestPrime(val);
        val /= pr;
        cout << val << " " << pr << endl;;
    }

    cout << val << endl;
}