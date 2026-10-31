// Integer Pointers Program
// Reads three integers, stores each in a variable, creates an int pointer to
// dynamic memory for each, displays variables and pointers, then frees memory.

#include <iostream>
using namespace std;

int main() {
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;

    // Get input from the user
    cout << "Enter the first integer: ";
    cin >> value1;
    cout << "Enter the second integer: ";
    cin >> value2;
    cout << "Enter the third integer: ";
    cin >> value3;

    // Allocate dynamic memory with new, initialized with the variable values
    int* ptr1 = new int(value1);
    int* ptr2 = new int(value2);
    int* ptr3 = new int(value3);

    // Display the variables
    cout << "\n--- Variables ---" << endl;
    cout << "value1 = " << value1 << endl;
    cout << "value2 = " << value2 << endl;
    cout << "value3 = " << value3 << endl;

    // Display the pointers (address stored) and what they point to (contents)
    cout << "\n--- Pointers ---" << endl;
    cout << "ptr1 address = " << ptr1 << ", contents = " << *ptr1 << endl;
    cout << "ptr2 address = " << ptr2 << ", contents = " << *ptr2 << endl;
    cout << "ptr3 address = " << ptr3 << ", contents = " << *ptr3 << endl;

    // Release the dynamic memory with delete
    delete ptr1;
    delete ptr2;
    delete ptr3;

    // Avoid dangling pointers
    ptr1 = nullptr;
    ptr2 = nullptr;
    ptr3 = nullptr;

    cout << "\nDynamic memory has been released." << endl;
    return 0;
}
