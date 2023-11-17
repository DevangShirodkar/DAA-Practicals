class FractionalSnapSack{

    static int fractionalSnapsack(int[] weight,int profit[],int maxWeight){

        // Calculate profit-to-weight ratio for each item and store it in pw array
        int pw[] = new int[weight.length];
        int itr1 = 0;
        for(int i=0;i<pw.length;i++)
        {
            pw[i] = profit[i]/weight[i];
            itr1++;
        }

        System.out.println("P/W Iterations: "+itr1);

        // Sorting the items based on their profit-to-weight ratios in ascending order
        int itr2 = 0;
        for(int i=0;i<weight.length;i++){

            for(int j=i+1;j<weight.length;j++){
                
                if(pw[i]>pw[j]){
                 // Swap profit-to-weight ratios, profits, and weights if necessary for sorting

                    int temp1 = pw[i];
                    pw[i] = pw[j];
                    pw[j] = temp1;

                    int temp2 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp2;

                    int temp3 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp3;
                }

                itr2++;
            }
        }

        System.out.println("Sorting Iterations: "+itr2);

        int weightSum = 0;
        int maxProfit = 0;
        int itr3 = 0;

        // Fill the knapsack by selecting items based on the sorted profit-to-weight ratios
        for(int i=pw.length-1;i>=0;i--){

            if(weightSum + weight[i]==maxWeight){
                // If the weight of the item is exactly the remaining capacity of the knapsack, add its profit
                maxProfit +=profit[i];
                break;
            }

            else if(weightSum+weight[i]<maxWeight){
                // If the weight of the item can fit entirely, add its profit and update the weightSum
                weightSum +=weight[i];
                maxProfit +=profit[i];
            }

            else{
                // If the weight exceeds the remaining capacity, add a fractional part of the item to maximize profit
                int req= maxWeight - weightSum;
                maxProfit = maxProfit + pw[i]*req;
                break;
            }

            itr3++;
        }

        System.out.println("Iterations: "+itr3);

        return maxProfit;
    }

    public static void main(String[] args) {
        
        int weigth[] = {3, 3, 2, 5, 1};
        int profit[] = {10, 15, 10, 20, 8};

         // Call fractionalSnapsack method with weight, profit arrays, and maximum weight
        System.out.println(fractionalSnapsack(weigth, profit,10));
    }
}