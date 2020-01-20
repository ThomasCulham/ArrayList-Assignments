import java.util.ArrayList;

class ArrayListAssingmrnt2 {

    public static void main (String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n= 100;
        for( int i = 2; i<n-2; i++){
            list.add(i);
        }
        Eratosthenes(list);
        System.out.println(list);
        System.out.println(Goldbach(160));
        
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        n1.add(9);
        n1.add(2);
        n2.add(1);
        n2.add(8);
        System.out.println(n1 + " + " + n2 + " = " + Add(n1,n2));

    }  

    public static void Eratosthenes( ArrayList<Integer> nums ) {
        boolean calculating = true;
        int p=2;
        int loopCount = 0;
        while(calculating){
            for( int i = p; i<nums.size();i++){
                if(nums.get(i)%p==0){
                    nums.remove(i);
                    i--;
                }
            }
            if(loopCount+1==nums.size()){
                return;
            }else{
                loopCount++;
            }
            if(p==nums.get(loopCount)){
                calculating = false;
            }else{
                p=nums.get(loopCount);
            }
        }
        return;
    }

    public static String Goldbach( int n ) {  
        ArrayList<Integer> p = new ArrayList<Integer>(160000000 );
        for( int i = 2; i<n-2; i++){
            p.add(i);
        }
        Eratosthenes(p);
        System.out.println(p);
        for(int i = 0; i<p.size();i++){
            for(int j = 0; j<p.size();j++){
                int ti= p.get(i);
                int tj=p.get(j);
                if(ti+tj==n){
                    return p.get(i) + " + " + p.get(j) + " = " + n; 
                }
            }
        }
        return "didnt work fam";
    }

    public static ArrayList<Integer> Add( ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> ans= new ArrayList<Integer>();
        while(a.size()!=b.size()){
            if(a.size()>b.size()){
                b.add(0,0);
            }else{
                a.add(0,0);
            }
        }
        System.out.println(a + " + " + b );

        for(int i = a.size()-1; i>=0;i--){
            ans.add(0);
        }

        for(int i = a.size()-1; i>=0;i--){
            int na= a.get(i);
            int nb= b.get(i);
            int nans= ans.get(i);
            int add= nb+na+nans;
            if(add>9){
                ans.set(i, add%10);
                if(i==0){
                    ans.add(0, add/10);
                }else{
                    ans.set(i-1, add/10);
                }

            }else{
                ans.set(i,add);
            }

        }
        return ans;
    }
}

        
