// 06/2023

#include <iostream>
#include <set>

using namespace std;

int main() {
    int n;
    set<int> l;
    cin >> n;
    int input;

    for(int i = 0; i < n; i += 1) {
        cin >> input;
        l.insert(input);
    }

    cout << l.size() << endl;
}