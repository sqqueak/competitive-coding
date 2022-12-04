/**
 * Espresso!
 * 1 second
 * September 2021
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
    int n, s, c, cc;
    cin >> n >> s;
    c = 0, cc = 0;

    for(int i = 0; i < n; i += 1) {
        string order;
        cin >> order;
        
        if(order.find("L") != string::npos) { // latte    (n+1)
            cc += 1 + stoi(order.substr(0,1));
        } else {                              // expresso (n)
            cc += stoi(order);
        }

        if(cc > s) {
            cc %= s;
            c += 1;
        }
    }

    cout << c << endl;
}