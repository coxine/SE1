"""write your code in method"""


def get_solutions(n):
    ans=[1,1,2]
    if n>=3:
        for i in range(3,n+1):
            ans.append(ans[-1]+ans[-2])
    
    return ans[n]
    # return solutions

if __name__=='__main__':
    for i in range(0,5):
        print(get_solutions(i))