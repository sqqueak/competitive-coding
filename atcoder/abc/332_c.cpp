// 2023 dec 25

#include <iostream>
#include <string>

using namespace std;

int main() {
    int N, M;
    string S;
    cin >> N >> M >> S;
    int m = M;
    int amt = 0;
    int res = 0;

    for(int i = 0; i < N; i += 1) {
        if(S[i] == '0') {
            m = M;
            res = max(amt, res);
            amt = 0;
        } else if(S[i] == '1') {
            if(m <= 0) {
                amt += 1;
            } else {
                m -= 1;
            }
        } else {
            amt += 1;
        }
    }
    cout << max(amt, res) << endl; 
}