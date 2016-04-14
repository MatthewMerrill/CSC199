# Dynamic Programming:

## When Greedy Doesn't Work:

### Making Change:
When units are {$1, $3, $5, $8}, want to make $10, we would first pick $8, be left with $2, and pick up 2 more 1s for 3 coins. 2 $5s, however, is the answer.

## Make a Table
For each 'i' value of distinct coins, and N where N-i > 0, s[N] = min(s[N], s[N-i] + 1)

#### Starts:
 - 0 |  1 |  2 |  3 | 	4 |	 5 |	 6 |	 7 |	 8 |	 9 |	10
 - 0 | -1 | -1 | -1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1
 
##### One coin:
 - 0 |  1 |  2 |  3 | 	4 |	 5 |	 6 |	 7 |	 8 |	 9 |	10
 - 0 | -1 | -1 | -1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1

##### Two coins: 
 - 0 |  1 |  2 |  3 | 	4 |	 5 |	 6 |	 7 |	 8 |	 9 |	10
 - 0 | -1 | -1 | -1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1

##### Three coins: 
 - 0 |  1 |  2 |  3 | 	4 |	 5 |	 6 |	 7 |	 8 |	 9 |	10
 - 0 | -1 | -1 | -1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1 |	-1

Thus, s[n] is smallest number of coins to make $n.