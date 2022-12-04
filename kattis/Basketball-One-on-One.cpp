#include <iostream>
#include <string>
#include <cstring>
#include <math.h>
using namespace std;

int main() {
    string game;
    cin >> game;
    char arr[game.length() + 1];
    strcpy(arr, game.c_str()); // converted to char type

    int a = 0, b = 0;
    bool tied = false;

    for(int i = 0; i < sizeof(arr); i+=2) {
        if(arr[i] == 'A') {
            a += (int) arr[i+1]-48; // wants const char * type?
        } else {
            b += (int) arr[i+1]-48;
        }

        // cout << a << " " << b << endl;

        if(tied || a==10 && b==10) {
            tied = true;
            if(a > b && abs(a-b) >= 2) {
                cout << "A" << endl;
                break;
            } else if(a < b && abs(a-b) >= 2) {
                cout << "B" << endl;
                break;
            }
        } else if(a >= 11) {
            cout << "A" << endl;
            break;
        } else if(b >= 11) {
            cout << "B" << endl;
            break;
        }
    }
}

/**
 * #include <iostream>
using namespace std;

int main() {
	string s; cin >> s;
	cout << s[s.size()-2];
}
**/
