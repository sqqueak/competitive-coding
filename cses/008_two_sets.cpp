// 2023 jun 8

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    if((n * (n+1) / 2) & 1) {
        cout << "NO" << endl;
    } else {
        vector<int> l1;
        vector<int> l2;
        bool first_list = true;
        bool pick_twice = true;
        for(int i = n; i >= 1; i -= 1) {
            if(!pick_twice) {
                if(first_list) {
                    l2.push_back(i);
                    pick_twice = !pick_twice;
                } else {
                    l1.push_back(i);
                    first_list = !first_list;
                }
            } else {
                if(first_list) {
                    l2.push_back(i);
                    first_list = !first_list;
                } else {
                    l1.push_back(i);
                    pick_twice = !pick_twice;
                }
            }
        }

        cout << "YES" << endl;
        cout << l1.size() << endl;
        for(int x : l1) {
            cout << x << " ";
        }
        cout << endl;
        cout << l2.size() << endl;
        for(int x : l2) {
            cout << x << " ";
        }
    }
}