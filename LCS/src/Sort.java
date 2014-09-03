import java.util.ArrayList;
import java.util.List;


public class Sort {
	public static <T extends Comparable<T>> T[] insertSort(T[] arrays){
		for(int i=1;i<arrays.length;i++){
			T key = arrays[i];
			int j;
			for(j = i-1;j>=0;j--){
				if(arrays[j].compareTo(key)>0){
					arrays[j+1] = arrays[j];
				}	
				else{
					break;
				}
			}
			arrays[j+1] = key;
		}
		return arrays;
	}
	
	public void mergeSort(List<Integer> arrays){
		this.mergeSort(arrays, 0, arrays.size()-1);
		
	}
	
	public void mergeSort(List<Integer> arrays,int p,int r){
		if(p>=r) return;
		int q = (p+r)/2;
		mergeSort(arrays,p,q);
		mergeSort(arrays,q+1,r);
		merge(arrays,p,q,r);
	}
	
	public static void merge(List<Integer> arrays,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		for(int i=0;i<n1;i++){
			left.add(arrays.get(p+i));
			
		}
		for(int j=0;j<n2;j++){
			right.add(arrays.get(q+j+1));
		}
		left.add(new Integer(Integer.MAX_VALUE));
		right.add(new Integer(Integer.MAX_VALUE));
	
		for(int i=0,j=0,k=p;k<=r;k++){
			if(left.get(i).compareTo(right.get(j))<=0){
				arrays.set(k, left.get(i));
				i++;
			}else{
				arrays.set(k, right.get(j));
				j++;
			}
		}
	}
	
	public List<Integer> heapSort(List<Integer> arrays){
		List<Integer> lis = new ArrayList<Integer>();
		buildMaxHeap(arrays);
		for(int i=arrays.size()-1;i>=1;i--){
			Integer temp = arrays.get(0);
			arrays.set(0, arrays.get(i));
			arrays.remove(i);
			lis.add(temp);
			maxHeapify(arrays,0);
		}
		lis.add(arrays.get(0));
		return lis;
	}
	
	public void buildMaxHeap(List<Integer> arrays){
		for(int i = arrays.size()/2-1;i>=0;i--){
			maxHeapify(arrays,i);
		}
	}
	
	public void maxHeapify(List<Integer> arrays,int i){
		int largest = i;
		if(2*i+1<arrays.size() && arrays.get(2*i+1).compareTo(arrays.get(largest))>0)
			largest = 2*i+1;
		if(2*i+2<arrays.size() && arrays.get(2*i+2).compareTo(arrays.get(largest))>0)
			largest = 2*i+2;
		if(largest!=i){
			Integer temp = arrays.get(i);
			arrays.set(i, arrays.get(largest));
			arrays.set(largest, temp);
			maxHeapify(arrays,largest);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
 	public static void main(String[] args){
		/*String[] arr = {"b","a","d","c","g","Z","A"};
		String[] res = Sort.insertSort(arr);
		for(String s: res){
			System.out.println(s);
		}*/
 		
 		
 		List<Integer> lis = new ArrayList<Integer>();
 		lis.add(new Integer(3));
 		lis.add(new Integer(7));
 		lis.add(new Integer(2));
 		lis.add(new Integer(9));
 		lis.add(new Integer(5));
 		lis.add(new Integer(4));
 		lis.add(new Integer(1));
 		
 		
 		//new Sort().mergeSort(lis);
 		//lis = new Sort().heapSort(lis);
 		for(Integer i : lis){
 			System.out.println(i);
 		}
 		
	}
}
