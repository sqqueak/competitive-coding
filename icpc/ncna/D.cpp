// Ultimate Binary Watch
// September 2022

#include <iostream>
#include <vector>
using namespace std;

vector<int> intToBinary(int i) { // this can be simplified woo
    if(i == 0) {
        return vector<int> {0,0,0,0};
    } else if(i == 1) {
        return vector<int> {0,0,0,1};
    } else if(i == 2) {
        return vector<int> {0,0,1,0};
    } else if(i == 3) {
        return vector<int> {0,0,1,1};
    } else if(i == 4) {
        return vector<int> {0,1,0,0};
    } else if(i == 5) {
        return vector<int> {0,1,0,1};
    } else if(i == 6) {
        return vector<int> {0,1,1,0};
    } else if(i == 7) {
        return vector<int> {0,1,1,1};
    } else if(i == 8) {
        return vector<int> {1,0,0,0};
    } else {
        return vector<int> {1,0,0,1};
    }
}

int main() {
    int time;
    cin >> time;

    vector<int> t;
    for(int i = 0; i < 4; i += 1) {
        t.push_back(time % 10);
        time /= 10;
    }
    reverse(t.begin(), t.end());

    vector<vector<string>> fin{4, vector<string> {".",".",".",".","."}};

    for(int i = 0; i < 5; i += 1) {
        if(i == 2) {
            for(int row = 0; row < 4; row += 1) {
                fin.at(row).at(2) = " ";
            }
        } else {
            vector<int> binary;
            if(i < 2) {
                binary = intToBinary(t.at(i));
            } else {
                binary = intToBinary(t.at(i-1));
            }
            for(int row = 0; row < 4; row += 1) {
                if(binary.at(row) == 1) {
                    fin.at(row).at(i) = "*";
                }
            }
        }
    }

    // printing out answer
    for(vector<string> v1 : fin) {
        for(string s : v1) {
            cout << s << " ";
        }
        cout << endl;
    }
}