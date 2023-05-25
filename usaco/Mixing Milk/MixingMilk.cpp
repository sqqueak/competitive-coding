// REVIEW + SIMPMLIFY 

#include<iostream>
#include<fstream>
using namespace std;

int main() {
    freopen("mixmilk.in", "r", stdin);
    freopen("mixmilk.out", "w", stdout);

    int cap1, vol1, cap2, vol2, cap3, vol3;
    cin >> cap1 >> vol1 >> cap2 >> vol2 >> cap3 >> vol3;

    for(int i = 0; i < 33; i+=1) { // there will always be 33 cycles of 3
        if(vol2 != cap2) {
            if(vol1 < cap2-vol2) {
                vol2 += vol1;
                vol1 = 0;
            } else {
                int space = cap2-vol2;
                vol1 -= space;
                vol2 += space;
            }
            //cout << vol1 << vol2 << vol3 << endl;
        }
        if(vol3 != cap3) {
            if(vol2 < cap3-vol3) {
                vol3 += vol2;
                vol2 = 0;
            } else {
                int space = cap3-vol3;
                vol2 -= space;
                vol3 += space;
            }
            //cout << vol1 << vol2 << vol3 << endl;
        }
        if(vol1 != cap1) {
            if(vol3 < cap1-vol1) {
                vol1 += vol3;
                vol3 = 0;
            } else {
                int space = cap1-vol1;
                vol3 -= space;
                vol1 += space;
            }
            //cout << vol1 << vol2 << vol3 << endl;
        }
    }
    if(vol2 != cap2) {
            if(vol1 < cap2-vol2) {
                vol2 += vol1;
                vol1 = 0;
            } else {
                int space = cap2-vol2;
                vol1 -= space;
                vol2 += space;
            }
            //cout << vol1 << vol2 << vol3 << endl;
        }

    cout << vol1 << "\n" << vol2 << "\n" << vol3 << endl;
}