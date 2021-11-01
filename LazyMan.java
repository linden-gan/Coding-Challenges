public class LazyMan {
   private static LazyMan instance;
   
   private LazyMan() {}
   
   public synchronized LazyMan getInstance() {
      if (instance == null) instance = new LazyMan();
      return instance;
   }
   
   public void method1() {
      System.out.println("This is method1");
   }
}