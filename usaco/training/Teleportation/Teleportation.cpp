#include<iostream>
#include<math.h>
#include<fstream>
using namespace std;

int main() {
    ifstream infile ("teleport.in");
    ofstream myfile;
    myfile.open ("teleport.out");

    if(infile.is_open()) {
        int a, b, x, y; infile >> a >> b >> x >> y;

        if(abs(a-b) < abs(a-y)+abs(b-x) && abs(a-b) < abs(a-x)+abs(b-y)) {
            myfile << abs(a-b) << endl;
        } else {
            myfile << ( (abs(a-y)+abs(b-x) > abs(a-x)+abs(b-y)) ? abs(a-x)+abs(b-y) : abs(a-y)+abs(b-x) ) << endl;
        }
    }

    infile.close();
    myfile.close();
}