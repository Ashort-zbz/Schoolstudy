package LineList;

public class SqList<AnyType> {
	public int AMOUNT = 10; //初始长度
	public static int index; //表位置
	AnyType[] myList;
	public SqList() {
		initList();
	}
	
	//初始化顺序表
	public void initList() {
		myList = (AnyType[]) new Object[AMOUNT];
		index = 0;
	}
	
	//判断顺序表是否为空
	public boolean listEmpty() {
		if(index == 0) {
			return true;
		}
		return false;
	}
	
	//清空顺序表
	public boolean clearList() {
		myList = null;
		index = 0;
		return true;
	}
	
	//返回i位置的元素
	public AnyType get(int i) {
		if(i<0 || i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return myList[i];
	}
	
	//在i处插入元素
	public void add(int i, AnyType a){
		if(i<0 || i>index){
			throw new ArrayIndexOutOfBoundsException();//检查i是否越界
		}
		if(i==index){
			largeList();//插入位置在表尾，则扩大表的长度
		}
		for(int k=index; k>i; k--){
			myList[k] = myList[k-1];//把i出以后的元素均后移
		}
		myList[i] = a;
		index++;//然后表的长度加一
	}

	//在表尾插入元素
	//方法重载
	public void add(AnyType a){
		add(index,a);//调用上面的add方法
	}

	//对i处的元素重新赋值
	public AnyType set(int i, AnyType a){
		if(i<0 || i>index){
			throw new ArrayIndexOutOfBoundsException();//检查i是否越界
		}
		AnyType old = myList[i];
		myList[i] = a;
		return old;
	}

	//遍历顺序表
	public void print(){
		String s = "[";
		for(int i = 0; i<index; i++){
			s=s+myList[i];
			s=s+",";
		}
		s=s+"]";
		System.out.println(s);
	}

	//查找a是否在表中
	public int locateElem(AnyType a){
		int ret = 0;
		for(int i =0; i < index; i++){
			if(a == myList[i]){
				ret = i;
			}
		}
		return ret;
	}

	//返回表长
	public int length(){
		return index;
	}

	//删除i处的位置
	public AnyType delete(int i){
		if(i<1 || i>index){
			throw new ArrayIndexOutOfBoundsException();//检查i是否越界
		}
		AnyType old = myList[i];
		for(int k=i-1; k<index; k++){
			myList[k]=myList[k+1];
		}
		index--;
		return old;
	}

	//扩大表的最大长度
	public void largeList(){
		AnyType[] newList = (AnyType[]) new Object[2*length()+1];
		for(int i=0; i<index; i++){
			newList[i] = myList[i];
		}
		myList=newList;
	}
}
