// 06/2023

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    string input;
    cin >> input;
    int count = 1;
    int curr = 1;

    for(int i = 0; i < input.length() - 1; i += 1) {
        if(input[i] == input[i+1]) {
            curr += 1;
        } else {
            curr = 1;
        }
        count = max(count, curr);
    }
    
    cout << count << endl;
}