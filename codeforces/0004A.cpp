// 2022 sep 10

#include <iostream>
using namespace std;

int main() {
    int w;
    cin >> w;
    if(w % 2 == 0) {
        w /= 2;
        if(w % 2 == 0) {
            cout << "YES" << endl;
        } else {
            int a = w+1, b = w-1;
            if(a && b) {
                cout << "YES" << endl;
            } else {
                cout << "NO" << endl;
            }
        }
    } else {
        cout << "NO" << endl;
    }
}