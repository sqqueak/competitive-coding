#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    for(int i = 0; i < n; i+=1) {
        string w;
        cin >> w;

        if(w.length() > 10) {
            cout << w.substr(0, 1) << w.length() - 2 << w.substr(w.length()-1, 1) << endl;
        } else {
            cout << w << endl;
        }
    }
}