// 06/2023

#include <iostream>
#include <cmath>

using namespace std;
using ll = long long;

int main() {
    int n;
    int counter = 0;
    cin >> n;

    cout << 0 << endl;
    for(int i = 2; i <= n; i += 1) {
        cout << (ll)((pow(i,2) * (pow(i,2)-1) / 2) - (8 * counter)) << endl;
        counter += i - 1;
    }
}