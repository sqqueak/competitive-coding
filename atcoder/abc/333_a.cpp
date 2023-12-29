// 2023-12-25

#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;
    string res = "";
    for(int i = 0; i < N; i += 1) {
        res += to_string(N);
    }
    cout << res << endl;
}