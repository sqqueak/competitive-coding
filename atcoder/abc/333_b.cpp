// 2023 dec 25

#include <iostream>
#include <string>
#include <set>

using namespace std;

int main() {
    string s; string t;
    cin >> s >> t;

    set<string> g1 = { "AB", "BC", "CD", "DE", "AE", "BA", "CB", "DC", "ED", "EA" };
    set<string> g2 = { "AC", "AD", "BD", "BE", "CE", "CA", "DA", "DB", "EB", "EC" };

    if((g1.find(s) != g1.end()) && (g1.find(t) != g1.end())) {
        cout << "Yes" << endl;
    } else if((g2.find(s) != g2.end()) && (g2.find(t) != g2.end())) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }
}