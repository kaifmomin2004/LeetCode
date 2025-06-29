/*
LeetCode 51: N-Queens

The n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example 1:
Input: n = 4
Output:
[
 [".Q..",
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",
  "Q...",
  "...Q",
  ".Q.."]
]

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
- 1 <= n <= 9
*/

#include <bits/stdc++.h>
using namespace std;

vector<vector<string>> ans;
vector<string> paths;
vector<vector<bool>> notVisited;
bool check(int i, int j, int n)
{
    return notVisited[0][j] &&
           notVisited[1][i - j + n - 1] &&
           notVisited[2][i + j];
}

void Queens(int n, string &psf, int i, int j)
{
    if (i == n)
    {
        ans.push_back(paths);
        return;
    }

    if (j == n)
        return;

    if (check(i, j, n))
    {
        psf[j] = 'Q';

        paths.push_back(psf);

        psf[j] = '.';

        notVisited[0][j] = false;
        notVisited[1][i - j + n - 1] = false;
        notVisited[2][i + j] = false;

        Queens(n, psf, i + 1, 0);

        paths.pop_back();

        notVisited[0][j] = true;
        notVisited[1][i - j + n - 1] = true;
        notVisited[2][i + j] = true;
    }

    Queens(n, psf, i, j + 1);
}

vector<vector<string>> solveNQueens(int n)
{
    ans.clear();
    paths.clear();
    notVisited.clear();
    notVisited = {
        (vector<bool>(n, true)),         // 0 : vertical
        (vector<bool>(2 * n - 1, true)), // 1 : diagonal
        (vector<bool>(2 * n - 1, true))  // 2 : anti-diagonal
    };

    string stars(n, '.');

    Queens(n, stars, 0, 0);

    return ans;
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n;
        cin >> n;

        vector<vector<string>> solutions = solveNQueens(n);

        for (const auto &board : solutions)
        {
            for (const auto &row : board)
            {
                cout << row << '\n';
            }
            cout << '\n'; // separate different board solutions
        }
        cout << "========================================\n\n";
    }

    return 0;
}
