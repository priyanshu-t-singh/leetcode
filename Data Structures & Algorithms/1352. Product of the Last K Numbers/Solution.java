// Time Complexity: O(1)
// Space Complexity: O(n)
class ProductOfNumbers {

    private List<Integer> prefixProd = new ArrayList<>();
    private int start = 0;

    public ProductOfNumbers() {
        prefixProd.add(1);
    }
    
    public void add(int num) {
        int n = prefixProd.size();
        int prev = prefixProd.get(n-1);
        if (num == 0) {
            start = n;
            prefixProd.add(0);
        } else if (prev == 0) {
            prefixProd.add(num);
        } else {
            prefixProd.add(num * prev);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProd.size();
        int num = prefixProd.get(n-1);
        int den = prefixProd.get(Math.max(n-k-1, start));

        if (n-k-1 == start) {
            return num;
        }
        if (den == 0) {
            return 0;
        }

        return num / den;
    }
}
