public class MergeSort{

    
	public static void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
   	}

	public static int partition(int arr[], int l, int r){
		int pivot = r;
		int i = -1;
		int j=0;

		for(j=0; j<r; j++){
			if(arr[j]<arr[pivot]){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, pivot);
		return i+1;
	}
    
   
	public static void quickSort(int arr[], int l, int r){
		if(l>=r) 
			return;

		int p = partition(arr, l, r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1, r);
	}


    
	public static void merge(int arr[], int l, int m, int r){

		int n1 = m-l+1;
		int n2 = r-m;

		int arr1[] = new int[n1];
		int arr2[] = new int[n2];

		int i, j, k;

		for(i=0; i<n1; i++){
			arr1[i] = arr[l+i];
		}

		for(j=0; j<n2; j++){
			arr2[j] = arr[m+1+j];
		}

		i=0; j=0; k=l;

		while(i<n1 && j<n2){       
			if(arr1[i]<arr2[j])
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
		}

		while(i<n1){
			arr[k++] = arr1[i++];
		}

		while(j<n2){
			arr[k++] = arr2[j++];
		}
	}

   
	public static void divide(int arr[], int l, int r){

		if(l>=r)
			return;

		int mid = (l+r)/2;
		divide(arr, l, mid);
		divide(arr, mid+1, r);
		merge(arr, l, mid, r);
	}



	public static void print(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}	
		System.out.println();
	}
    
   

	public static void main(String args[]){    
		int arr[] = {1, 5, 2, 8, 4, 3};
		MergeSort ob = new MergeSort();

		ob.divide(arr, 0, arr.length-1);
		ob.print(arr);

		int a[] = {1, 5, 3, 2, 8, 6, 9, 2, 5, 3};
		ob.quickSort(a, 0, a.length-1);
		ob.print(a);
	}

}
