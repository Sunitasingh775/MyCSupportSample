//
// Created by sunita on 6/4/2019.
//

#include <stdbool.h>

bool isPrime(int number) {
    bool isPrime = true;
    for (int i = 2; i <= number / 2; i++) {
        if (number % i == 0) {
            return false;
        } else {
            isPrime = true;
        }
    }
    return isPrime;
}