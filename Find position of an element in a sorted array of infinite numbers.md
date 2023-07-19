## Time Complexity: $$O()$$
## Space Complexity: $$O()$$

# Code
```java
    static int findPos(int arr[],int key)
    {
        int l = 0, h = 1;
        int val = arr[0];
 
        // Find h to do binary search
        while (val < key)
        {
            l = h;     // store previous high
            //check that 2*h doesn't exceeds array
            //length to prevent ArrayOutOfBoundException
            if(2*h < arr.length-1)
               h = 2*h;            
            else
               h = arr.length-1;
             
            val = arr[h]; // update new val
        }
 
        // at this point we have updated low
        // and high indices, thus use binary
        // search between them
        return binarySearch(arr, l, h, key);
```
