// 2024 jun 11

#include <iostream>
using namespace std;

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i += 1) {
        int a;
        int b;
        cin >> a >> b;

        while(a != b && a > 0 && b > 0) {
            if(b > a) {
                b -= 2;
                a -= 1;
            } else {
                a -= 2;
                b -= 1;
            }
        }

        if(a % 3 == 0) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
}