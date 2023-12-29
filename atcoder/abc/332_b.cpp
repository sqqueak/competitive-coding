// 2023-12-25

#include <iostream>

using namespace std;

int main() {
    int K, G, M;
    cin >> K >> G >> M;
    int g = 0, m = 0;

    for(int i = 0; i < K; i += 1) {
        if(g == G) {
            g = 0;
        } else if(m == 0) {
            m = M;
        } else {
            int amt = min(G - g, m);
            g += amt;
            m -= amt;
        }
    }
    cout << g << " " << m << endl;
}