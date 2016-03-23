import scala.collection.mutable.Stack
import scala.util.control.Breaks

class BigSumCalculator(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  
  def findSum(stack1: Stack[Int], stack2: Stack[Int]){
      val stack3 = new Stack[Int]
      var s = 0;
      val loop = new Breaks;
      var first = 0
      var second = 0
      var colum_result=0
      loop.breakable{
      while(!stack1.isEmpty && !stack2.isEmpty){
        first=0
        second=0
        if(stack1.isEmpty && stack2.isEmpty){
          loop.break;
        }
        first = stack1.pop()
        second = stack2.pop()
        colum_result += first+second
        println(first + " : " + second);
        stack3.push(colum_result%10)
//        stack3.foreach(println)
        if(colum_result>9){
          colum_result = colum_result / 10;
        }else{
          colum_result = 0;
        }
      }
      println("\ncarry \t "+colum_result + " ");
      stack1.foreach(print)
      println()
      stack2.foreach(print)
      var stackTemp = new Stack[Int]
      if (!stack1.isEmpty) {
			  stackTemp = stack1;
  		} else if (!stack2.isEmpty) {
  			stackTemp = stack2;
  		}
      var stackPrelim = new Stack[Int]
      while(!stackTemp.isEmpty){
        stackPrelim.push(stackTemp.pop())
      }
      if(colum_result>0 && stackTemp.isEmpty ){
        stack3.push(colum_result)
      }
      println("result is : " + stackPrelim)
      while(!stackPrelim.isEmpty){
       print(stackPrelim.pop())
      }
      while(!stack3.isEmpty){
        print(stack3.pop())
      }
    }
  }

  def factorial(n: Int) : Int =  {
    if(n==1 || n<1){
      return n;
    }
    return n * factorial(n-1);
  }

}

object MyApp extends App {   
     val pt = new BigSumCalculator(1, 2)
     val n = pt.factorial(3);
     println("factorial : " + n);
     val stack1 = new Stack[Int]
     val stack2 = new Stack[Int]  
     var first = "1123";
     var second = "456";
     var c = ""
     for(c <- first.toList){
       stack1.push(Integer.parseInt(""+c))
       print(Integer.parseInt(""+c))
     }
//     print("First : ")
//     stack1.foreach(x => print(x+""))
     println()
     for(c <- second.toList){
       stack2.push(Integer.parseInt(""+c))
       print(Integer.parseInt(""+c))
     }
     println()
//     stack1.foreach(print)
//     println()
     pt.findSum(stack1,stack2);
     //args.foreach(arg => print(arg+"\t"))
}