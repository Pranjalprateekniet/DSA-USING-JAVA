#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <vector>
using namespace std;

class Expense {
public:
    string date;
    string category;
    string description;
    double amount;

    void input() {
        cout << "Enter date (DD-MM-YYYY): ";
        cin >> date;
        cout << "Enter category (Food/Travel/Bills/Other): ";
        cin >> category;
        cin.ignore();
        cout << "Enter description: ";
        getline(cin, description);
        cout << "Enter amount: ";
        cin >> amount;
    }

    void display() const {
        cout << left << setw(12) << date
             << setw(15) << category
             << setw(25) << description
             << "₹" << fixed << setprecision(2) << amount << endl;
    }
};

class ExpenseTracker {
private:
    vector<Expense> expenses;
    const string filename = "expenses.txt";

public:
    ExpenseTracker() {
        loadFromFile();
    }
    void addExpense() {
        Expense e;
        e.input();
        expenses.push_back(e);
        saveToFile();
        cout << "\n✅ Expense added successfully!\n";
    }

    void viewExpenses() const {
        if (expenses.empty()) {
            cout << "No expenses recorded yet.\n";
            return;
        }

        cout << "\n------ Expense List ------\n";
        cout << left << setw(12) << "Date"
             << setw(15) << "Category"
             << setw(25) << "Description"
             << "Amount\n";
        cout << "---------------------------------------------------------------\n";

        double total = 0;
        for (const auto &e : expenses) {
            e.display();
            total += e.amount;
        }

        cout << "---------------------------------------------------------------\n";
        cout << "Total Spending: ₹" << fixed << setprecision(2) << total << endl;
    }

    void deleteExpense() {
        if (expenses.empty()) {
            cout << "No expenses to delete.\n";
            return;
        }

        string targetDate;
        cout << "Enter date of expense to delete (DD-MM-YYYY): ";
        cin >> targetDate;

        bool found = false;
        for (auto it = expenses.begin(); it != expenses.end(); ++it) {
            if (it->date == targetDate) {
                expenses.erase(it);
                saveToFile();
                cout << "🗑️ Expense on " << targetDate << " deleted.\n";
                found = true;
                break;
            }
        }

        if (!found)
            cout << "No record found for that date.\n";
    }

    void searchByCategory() const {
        if (expenses.empty()) {
            cout << "No expenses to search.\n";
            return;
        }

        string cat;
        cout << "Enter category to search: ";
        cin >> cat;

        double total = 0;
        bool found = false;
        for (const auto &e : expenses) {
            if (e.category == cat) {
                if (!found) {
                    cout << "\nExpenses under category '" << cat << "':\n";
                    cout << left << setw(12) << "Date"
                         << setw(25) << "Description"
                         << "Amount\n";
                    cout << "-------------------------------------------\n";
                    found = true;
                }
                cout << left << setw(12) << e.date
                     << setw(25) << e.description
                     << "₹" << fixed << setprecision(2) << e.amount << endl;
                total += e.amount;
            }
        }

        if (!found)
            cout << "No records found for category: " << cat << endl;
        else
            cout << "-------------------------------------------\nTotal: ₹" << total << endl;
    }

    void saveToFile() const {
        ofstream fout(filename);
        for (const auto &e : expenses)
            fout << e.date << "," << e.category << "," << e.description << "," << e.amount << "\n";
    }

    void loadFromFile() {
        ifstream fin(filename);
        if (!fin)
            return;

        Expense e;
        string line;
        while (getline(fin, line)) {
            size_t p1 = line.find(',');
            size_t p2 = line.find(',', p1 + 1);
            size_t p3 = line.find(',', p2 + 1);

            e.date = line.substr(0, p1);
            e.category = line.substr(p1 + 1, p2 - p1 - 1);
            e.description = line.substr(p2 + 1, p3 - p2 - 1);
            e.amount = stod(line.substr(p3 + 1));

            expenses.push_back(e);
        }
    }
};

int main() {
    ExpenseTracker tracker;
    int choice;

    cout << "\n===== Personal Expense Tracker =====\n";
    do {
        cout << "\n1. Add Expense\n2. View All Expenses\n3. Delete Expense\n4. Search by Category\n5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: tracker.addExpense(); break;
            case 2: tracker.viewExpenses(); break;
            case 3: tracker.deleteExpense(); break;
            case 4: tracker.searchByCategory(); break;
            case 5: cout << "Exiting... Goodbye!\n"; break;
            default: cout << "Invalid choice! Try again.\n";
        }
    } while (choice != 5);

    return 0;
}
