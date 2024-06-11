// 2023 may 30

#include <iostream>

using namespace std;

int main() {
    int res = 0;
    int p2 = 0;
    int p1 = 1;

    while(p2 + p1 < 4000000) {
        int tmp = p2 + p1;
        p1 = p2;
        p2 = tmp;
        if(tmp % 2 == 0) {
            res += tmp;
        }
    }

    cout << res << endl;
}