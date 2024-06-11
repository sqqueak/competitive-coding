// 2024 may 30

#include <iostream>

using namespace std;

int main() {
    int res = 0;

    for(int i = 1; i < 1000; i += 1) {
        if(i % 5 == 0 || i % 3 == 0) {
            res += i;
        }
    }

    cout << res << endl;
}