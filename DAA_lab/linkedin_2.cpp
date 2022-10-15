#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s= "abababa";
    //string s="aaaa";
    int flag[s.length()]{0};
    int i = 0,k=0;
    int j = s.length()-1;
    string res = "";
    while(i <= j)
    {
        if(s[i] > s[j])
        {
            //int x = count(s.begin(), s.end(), s[i]);
            if(flag[i] == 0)
            {
                for(int l = 0;l < s.length();l++){
                    //making all ocurrences 1
                    if(s[i] == s[l]);
                        flag[l] = 1;
                } 
                res[k++] = s[i];
                i++;
            }
        }
        else if(s[i] == s[j])
        {
            flag[i] = flag[j] = 1;
            res[k++] = s[i];
            i++;
            j--;
        }
        else
        {
            if(flag[j] != 1)
            {
                flag[j] = 1;
                res[k++] = s[j];
                j--;
            }
        }
    }
    
    for(int i = 0;i < k;i++)
        cout<<res[i]<<" ";
}