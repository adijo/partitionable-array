import scala.collection.mutable.HashSet;

class PartitionableArray[T : Manifest](predicate : T => Boolean, 
                                      size : Integer) {
 
  
  var arr = new Array[T](size);
  var counter = 0
  var candidate = null
  var set = new HashSet[Integer]
  
  def set(index : Integer, value : T) {
      if(index >= size)
        throw new ArrayIndexOutOfBoundsException()
      else {
          if(arr(index) == null) {
              arr(index) = value  
              if(predicate(value)) {
                counter = counter + 1
                set = set + index
              }
          }
          else {
            val prev = arr(index)
            if(predicate(prev)) {
                set.remove(index)
                counter = counter - 1
            }

            if(predicate(value)) {
              counter = counter + 1
              set = set + index
              arr(index) = value
            }
                
            else {
              arr(index) = value
             }
          }
      }
    
  }
  
  def get(index : Integer) : T = {
      if(index >= size)
        throw new ArrayIndexOutOfBoundsException()
      arr(index)
  }
  
  def getCount() : Integer = counter
  
  def getOne() : Integer = {
      if (counter == 0)
        throw new NoSuchElementException()
      set.take(1).toSeq(0)
  }
  
   
}