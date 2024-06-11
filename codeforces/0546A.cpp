// 2022 sep 10
// USACO Guide

#include <iostream>
using namespace std;

int main() {
    int k, n, w;
    cin >> k >> n >> w;
    int d = 0;
    for(int i = 1; i <= w; i += 1) {
        d += i*k;
    }
    if(d-n < 0) {
        cout << 0 << endl;
    } else {
        cout << d-n << endl;
    }
}


// #include <iostream>
// using namespace std;

// int main() {
// 	int first, num;
// 	long long money;
// 	cin >> first >> money >> num;
// 	int cost = num * (num + 1) / 2;
// 	cost *= first;
// 	cout << (max(0, cost - money));
// }