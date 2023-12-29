// 2023-12-25

#include <iostream>

using namespace std;

int main() {
    int N; int S; int K;
    int P; int Q;
    cin >> N >> S >> K;
    int tot = 0;

    for(int i = 0; i < N; i += 1) {
        cin >> P >> Q;
        tot += P * Q;
    }

    if(tot >= S) {
        cout << tot << endl;
    } else {
        cout << tot + K << endl;
    }
}