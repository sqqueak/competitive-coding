#include <iostream>
#include <vector>
#include <string>

std::vector<std::string> greycode(int n) {
    if(n == 1) {
        std::vector<std::string> x;
        x.push_back("0");
        x.push_back("1");
        return x;
    }
    
    std::vector<std::string> res;
    std::vector<std::string> rec = greycode(n - 1);
    for(auto& r : rec) {
        res.push_back("0" + r);
    }
    for(auto& r : rec) {
        res.push_back("1" + r);
    }
    return res;
}


int main() {
    int N; 
    std::cin >> N;

    std::vector<std::string> m = greycode(N);
    for(auto& g : m) {
        std::cout << g << std::endl;
    }
}