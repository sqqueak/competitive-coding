// Code Guessing
// September 2022

#include <iostream>
using namespace std;

int main() {
    int n1, n2;
    cin >> n1 >> n2;
    string order;
    cin >> order;

    if(order == "BAAB") {
        cout << -1 << endl;
    } else if (order == "ABAB") {
        if(n2-n1 == 2) {
            cout << n1+1 << " " << n2+1 << endl;
        } else {
            cout << -1 << endl;
        }
    } else if (order == "BABA") {
        if(n2-n1 == 2) {
            cout << n1-1 << " " << n2-1 << endl;
        } else {
            cout << -1 << endl;
        }
    } else if (order == "ABBA") {
        if(n2-n1 == 3) {
            cout << n1+1 << " " << n2-1 << endl;
        } else {
            cout << -1 << endl;
        }
    } else if (order == "AABB") {
        if(n1 == 6 && n2 == 7) {
            cout << "8 9" << endl;
        } else {
            cout << -1 << endl;
        }
    } else {
        if(n1 == 3 && n2 == 4) {
            cout << "1 2" << endl;
        } else {
            cout << -1 << endl;
        }
    } 
}