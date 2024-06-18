romanChar=['I','V','X','L','C','D','M']
romanVal=[1,5,10,50,100,500,1000]
romanStr=[
    ['','I','II','III',"IV",'V','VI','VII',"VIII","IX"],
    ['','X','XX','XXX','XL','L','LX','LXX','LXXX','XC'],
    ['','C','CC','CCC','CD','D','DC','DCC','DCCC','CM'],
    ['','M','MM','MMM'],
    ]
romanDigit=[['I','V','X'],['X','L','C'],['C','D','M'],['M']]


def convert_roma_number_to_integer(str):
    digitPos=3 
    strDigitPos=0
    ansList=[0,0,0,0]
    while digitPos>=0:
        if strDigitPos<len(str) and str[strDigitPos] in romanDigit[digitPos]:
            lastDigitPos=strDigitPos
            while lastDigitPos+1<len(str) and str[lastDigitPos+1] in romanDigit[digitPos]:
                lastDigitPos+=1
            ansList[digitPos]=romanStr[digitPos].index(str[strDigitPos:lastDigitPos+1])
            strDigitPos=lastDigitPos+1
    
        digitPos-=1
    ans =0
    ansList.reverse()
    for digit in ansList:
        ans*=10
        ans+=digit
    return ans


def convert_integer_to_roma_number(i):
    if i> 3999:
        return ValueError

    
    ans=[]
    digitPos= 0
    while i>0:
        digit=i%10
        ans.append(romanStr[digitPos][digit])
        digitPos+=1
        i//=10
    ans.reverse()
    ansStr=''.join(ans)

    return ansStr



if __name__=='__main__':
    str=input()
    print(convert_roma_number_to_integer(str))
