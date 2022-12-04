#include<iostream>
#include<fstream>
#include<math.h>
#include <algorithm>
using namespace std;

int main() {
    int arr[7];
    for(int i = 0; i < 7; i+=1) {
        cin >> arr[i];
    }

    sort(begin(arr), end(arr));

    int a = arr[0]; int b = arr[1]; int c;
    if(arr[0] + arr[1] == arr[2]) c = arr[3]; else c = arr[2]; 

    cout << a << " " << b << " " << c << endl;
}