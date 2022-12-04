#include<iostream>
#include<fstream>
#include<math.h>
#include<algorithm>
#include<vector>
#include<string>
#include<sstream>
#include<iterator>
using namespace std;

int main() {
    ifstream infile ("word.in");
    ofstream myfile;
    myfile.open ("word.out");

    int num, limit, curLen;
    infile >> num >> limit;
    string line; infile >> line;
    curLen = line.size();

    for(int i = 1; i < num; i+=1) {
        string word; infile >> word;
        if(word.size() + curLen > limit) {
            curLen = word.size();
            myfile << line << endl;
            line = word;
        } else {
            line += " " + word;
            curLen += word.size();
        }
    }
    myfile << line << endl;
}