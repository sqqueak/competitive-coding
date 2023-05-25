// USACO Guide
// September 18 2022

#include<iostream>
#include<fstream>
#include<math.h>
using namespace std;

int main() {
    int n; cin >> n;
    int counter = 0;
    for(int i = 0; i < n; i += 1) {
        int p, v, t; cin >> p >> v >> t;
        if(p+v+t >= 2) counter += 1;
    }
    cout << counter << endl;
}