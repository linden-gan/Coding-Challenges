public class EagerMan {
   private static final EagerMan instance = new EagerMan();
   
   private EagerMan() {}
   
   public EagerMan getInstace() {
      return instance;
   }
   
   public void method1() {
      System.out.println("This is method1");
   }
}