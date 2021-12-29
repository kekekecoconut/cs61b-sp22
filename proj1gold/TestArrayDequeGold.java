import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void test1(){
        StudentArrayDeque<Integer> studentArrayDeque =  new StudentArrayDeque<>();
        for (int i = 0; i < 120; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (i==0){
                if (numberBetweenZeroAndOne < 0.5) {
                    studentArrayDeque.addLast(StdRandom.uniform(0,100));
                } else {
                    studentArrayDeque.addFirst(StdRandom.uniform(0,100));
                }
            }else {
                if (numberBetweenZeroAndOne < 0.25) {
                    studentArrayDeque.addLast(StdRandom.uniform(0,100));
                } else {
                    if(numberBetweenZeroAndOne < 0.5){
                        studentArrayDeque.addFirst(StdRandom.uniform(0,100));
                    }else {
                        if (numberBetweenZeroAndOne < 0.75){
                            if(studentArrayDeque.isEmpty())
                                continue;
                            else
                                studentArrayDeque.removeFirst();
                        }else {
                            if(studentArrayDeque.isEmpty())
                                continue;
                            else
                                studentArrayDeque.removeLast();
                        }

                    }

                }
            }
        }

        studentArrayDeque.printDeque();
    }
    
}
