import java.util.ArrayList;
public class NumGenerator {

    private ArrayList<Integer>[] numGenerated = new ArrayList[81];
    public NumGenerator() {
        for(int i = 0; i < 81; i++) {
            numGenerated[i] = new ArrayList<Integer>();
        }
    }

    public void setNumTestedToGenerator(int num, int index) {
        this.numGenerated[index].add(num);
    }

    public void clearSpecificNumTestedList(int index) {
        for(int i = 0; i < this.numGenerated[index].size(); i++) {
            this.numGenerated[index].remove(i);
        }
    }

    public boolean checkIfNumExistsInList(int num, int index) {
        boolean numFound = false;
        for(int i = 0; i < this.numGenerated[index].size(); i++) {
            if(this.numGenerated[index].get(i) == num) {
                numFound = true;
            }
        }
            
        return numFound;
    }

    public int getNumTestedSize(int index) {
        return this.numGenerated[index].size();
    }
}
