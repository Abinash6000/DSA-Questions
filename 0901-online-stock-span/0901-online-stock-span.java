class StockSpanner {
    ArrayDeque<Pair> st;
    int i;

    public StockSpanner() {
        st = new ArrayDeque<Pair>();
        i = 0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }

        int res = !st.isEmpty() ? i - st.peek().index : i+1;

        st.push(new Pair(price, i));
        i++;

        return res;
    }
}

class Pair {
    int price;
    int index;

    Pair(int price, int index) {
        this.price = price;
        this.index = index;
    }
}