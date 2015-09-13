import scala.collection.mutable.TreeSet;
object Test {
	
	
	
	
	val arr = new PartitionableArray[Integer](_  > 5, 10)
                                                  //> arr  : PartitionableArray[Integer] = PartitionableArray@385cbbb1
	
	arr.set(0, 2)
	arr.set(1, 4)
	arr.set(2, 5)
	arr.set(3, 10)
	arr.set(4, 33)
	arr.set(4, 1)
	arr.getCount                              //> res0: Integer = 1
	
	arr.getOne                                //> res1: Integer = 3
	}
	