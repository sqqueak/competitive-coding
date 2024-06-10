// 06/2023

#include <iostream>

using namespace std;
using ll = long long;

int main() {
    int n;
    int prev;
    int curr;
    ll diffs = 0;

    cin >> n;
    cin >> prev;
    for(int i = 0; i < n-1; i += 1) {
        cin >> curr;
        if(curr < prev) {
            diffs += prev - curr;
        } else {
            prev = curr;
        }
    }

    cout << diffs << endl;
}