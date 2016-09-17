package other.thing;

public class SomeGreaterClass {
    public static void main(String[]  s) {
        if(true) {
            System.out.println("this is true");
        }
        if(false) {
            System.out.println("well, this is not going to run");
        }
        
        try {
            throw new RuntimeException("shouldn't i see this error?");
        } catch(Throwable t) {}
    }
    
    public static class InnerClass {
        public String name;
        private int time;
        
        public void setName(String name) {
            this.name = name;
        }
    }
    
    public class SubclassHidingThings extends InnerClass {
        public String name; // this should be bad.
        private int time;
    }
}
