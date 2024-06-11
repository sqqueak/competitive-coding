// 2023 jun 8

#include <iostream>
using namespace std;
using ll = long long;

int main() {
    ll n = 0;
    ll sum = 0;
    int input;

    cin >> n;

    for(int i = 0; i < n-1; i += 1) {
        cin >> input;
        sum += input;
    }

    cout << (n*(n+1))/2 - sum << endl;
}