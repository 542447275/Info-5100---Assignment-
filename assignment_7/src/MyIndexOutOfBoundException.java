public class MyIndexOutOfBoundException extends Exception {

    int index;

    public MyIndexOutOfBoundException(){}

    public MyIndexOutOfBoundException(int index){
        final int lowerBound = 0;
        final int upperBound = 9;
        this.index = index;
        System.out.println("\"Error Message: Index: " + index + ", but Lower bound:" + lowerBound + " Upper bound:" + upperBound + "\"");
    }

    public void inputIndex(int index) throws MyIndexOutOfBoundException{
        if(index <= 9 && index >= 0)
            System.out.println("index: " + index);
        else
            throw new MyIndexOutOfBoundException(index);
    }

    public static void main(String[] args){
        int index = 10;
        MyIndexOutOfBoundException test = new MyIndexOutOfBoundException();
        try {
             test.inputIndex(index);
        } catch (MyIndexOutOfBoundException e){
            e.printStackTrace();
        }
    }
}
