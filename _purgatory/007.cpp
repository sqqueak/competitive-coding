// 2024 jun 11

#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> arr;
    int bound = 1000000;

    for(int i = 2; i < bound; i += 1) {
        arr.push_back(i);
    }

    for(int i = 0; i < bound - 1; i += 1) {
        if(arr[i] > 0) {
            for(int j = i + arr[i]; j < bound - 1; j += arr[i]) {
                arr[j] = -1;
            }
        }
    }

    int cnt = 0;
    for(auto& digit : arr) {
        if(digit > 0) {
            cnt += 1;
        }
        if(cnt % 10001 == 0 && digit > 0) {
            cout << digit << " ";
            exit(0);
        }
    }
}