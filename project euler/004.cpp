#include <iostream>

using namespace std;

bool isPalindrome(string s) {
    int l = 0;
    int r = s.size() - 1;

    while(l < r) {
        if(s[l] != s[r]) {
            return false;
        }
        l += 1;
        r -= 1;
    }
    return true;
}

int main() {
    int largest = 0;
    for(int i = 999; i > 0; i--) {
        for(int j = 999; j > 0; j--) {
            if(isPalindrome(to_string(i * j))) {
                largest = max(largest, i * j);
            }
        }
    }
    cout << largest << endl;
}