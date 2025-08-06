/*
LeetCode 2: Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
- The number of nodes in each linked list is in the range [1, 100]
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros
*/

#include <bits/stdc++.h>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *adder(ListNode *l1, ListNode *l2, int carry)
{
    if (!l1 && !l2 && carry == 0)
        return nullptr;

    int sum = carry;
    if (l1)
        sum += l1->val;
    if (l2)
        sum += l2->val;

    ListNode *newNode = new ListNode(sum % 10);
    newNode->next = adder(l1 ? l1->next : nullptr, l2 ? l2->next : nullptr, sum / 10);
    return newNode;
}

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    return adder(l1, l2, 0);
}

ListNode *readList(int n)
{
    ListNode *head = nullptr;
    ListNode *tail = nullptr;
    for (int i = 0; i < n; ++i)
    {
        int val;
        cin >> val;
        ListNode *node = new ListNode(val);
        if (!head)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail->next = node;
            tail = node;
        }
    }
    return head;
}

void printList(ListNode *head)
{
    while (head)
    {
        cout << head->val;
        if (head->next)
            cout << " ";
        head = head->next;
    }
    cout << '\n';
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n1, n2;
        cin >> n1;
        ListNode *l1 = readList(n1);

        cin >> n2;
        ListNode *l2 = readList(n2);

        ListNode *result = addTwoNumbers(l1, l2);
        printList(result);
    }

    return 0;
}
