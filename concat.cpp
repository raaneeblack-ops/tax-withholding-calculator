// CSC450 - Programming III
// Program: Concatenate two user-supplied strings, repeated three times.

#include <iostream>
#include <string>

using namespace std;

int main() {
    const int NUM_ROUNDS = 3;

    cout << "String Concatenation Program" << endl;
    cout << "============================" << endl;

    for (int round = 1; round <= NUM_ROUNDS; round++) {
        string first;
        string second;

        cout << "\nRound " << round << " of " << NUM_ROUNDS << endl;

        cout << "Enter the first string: ";
        getline(cin, first);

        cout << "Enter the second string: ";
        getline(cin, second);

        string result = first + second;

        cout << "Concatenated result: " << result << endl;
        cout << "Result length: " << result.length() << " characters" << endl;
    }

    cout << "\nProgram complete." << endl;
    return 0;
}
