##爱丽丝、鲍勃和巧克力 
 
###描述 
 
爱丽丝和鲍勃喜欢游戏。现在他们准备开始一个新的游戏。他们把n块巧克力排成一行。爱丽丝开始从左到右一个一个地吃巧克力棒，鲍勃从右到左。对于每个巧克力棒，玩家消耗它所需的时间是已知的(Alice和Bob以相同的速度吃掉它们)。当玩家消耗一个巧克力棒时，他会立即开始食用另一个。不允许同时吃两块巧克力棒，不允许不吃完巧克力棒，也不允许中途停顿。如果两个玩家同时开始吃同一块巧克力棒，Bob会把它留给Alice，作为一个真正的绅士。 
 
每个玩家会消耗多少条巧克力棒? 
 
###输入 
 
第一行包含一个整数n，代表巧克力棒的总数。第二行包含一个序列，每个数代表消耗对应巧克力棒所需的时间(以秒为单位)(按从左到右的顺序)。 
 
###输出 
 
返回两个数字a和b（用列表返回，即[a,b]），其中a是Alice消耗的巧克力棒数量，b是Bob消耗的巧克力棒数量。 
 
###例子 
 
####输入 


    5
    2 9 8 2 7
 
####返回
    [2,3] 