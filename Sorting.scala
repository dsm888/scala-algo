
class Sorting {
  
  def bubbleSort(array1: Array[Int]){
    println("bubble sort");
    println(array1.mkString(" "))
    var i=0;
    var j=0;
    for (i <- array1.indices) {
      for (j <- array1.indices) {
        if(array1(i) < array1(j)){
          var t = array1(i) 
          array1(i) = array1(j);
          array1(j) = t;
//          println("yes")
        }
      }
    }
    
    println(array1.mkString(" "))
    
  }
  
  def arrayOperations(){
     //sum array elements
  }
  
  def selectionSort(array1: Array[Int]){
    println("select sort");
    println(array1.mkString(" "));
    var small=0;
    var index = 0;
    var i=0;
    var j=0;
    var found = false;
    for (i <- array1.indices) {
      small = array1(i);
          for(j <- i until array1.length){
            if(array1(j) < small ){
                small = array1(i);
                index = j;
                found = true;
            }
          }
          if(found){
            var tmp = array1(i);
            array1(i) = array1(index);
            array1(index) = tmp;
            found=false;
          }
    }
    println(array1.mkString(" "))
  }
  
  def mergeSort(){
    
  }
  
  def merge(){
    
  }
  
}

object printer extends App{
  new Sorting().bubbleSort(Array(3, 2, 1) )
  new Sorting().selectionSort(Array(3, 2, 1) )
}