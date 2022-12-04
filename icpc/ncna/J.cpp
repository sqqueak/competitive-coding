// Stream Lag
// September 2022

#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    cin >> n;

    for(int i = 0; i < n-1; i += 1) {
        string d1, d2;
        cin >> d1 >> d2;
    }

    int ti, i;
    cin >> ti >> i;
    if(ti - i <= 0) {
        cout << 0 << endl;
    } else {
        cout << ti - i << endl;
    }
}