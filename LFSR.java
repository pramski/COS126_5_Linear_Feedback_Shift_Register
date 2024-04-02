public class LFSR {
    //We are creating our Linear Feedback Shift Register (LFSR). It is a data type, so first we create our instance variables.
    //These are an integer array of 0s and 1s (bitArray), and an integer signifying a position along said array (tapPosition)
    private int tapPosition;
    private int[] bitArray;

    /** Here is the constructor for the LFSR. Having acquired the string seed, we can initialize bitArray with it as reference.
     *@param seed is the initial binary string supplied.
     *@param tap is the position along seed that will become useful later on
     */
    public LFSR(String seed, int tap) {
        tapPosition = tap;
        bitArray= new int[seed.length()];
        for(int i=0;i<seed.length();i++){
            bitArray[i]=Character.getNumericValue(seed.charAt(i));
        }
    }
    /** This returns the length of the array we now have
     * @return the length of the array
     */
    public int length() {
        return bitArray.length;
    }
    /** A string version of our data type is returned, just printing seed
     * @return alterString builds the string version of our array*/
    public String toString() {
        StringBuilder alterString = new StringBuilder();
        for (int j : bitArray) {
            alterString.append(j);
        }
        return String.valueOf(alterString);
    }
    /** Returns a digit at a specified point in the string.
     * @param i, a point along the seed string
     * @return the ith digit of the array
     */
    public int bitAt(int i) {
        return bitArray[i];
    }
    /** This simulates a step of the LFSR, by shifting our seed to the left by one digit, and then creating the final digit by taking
     * the xor of our leftmost and "tap" digits
     * @return the last digit formed via the aforementioned xor operation */
    public int step() {
        int temp= bitArray[0]^bitArray[bitArray.length-tapPosition];
        for (int i = 1; i <bitArray.length; i++) {
            bitArray[i-1]=bitArray[i];
        }
        bitArray[bitArray.length-1]=temp;
        return temp;
    }
    /** simulates k steps of the LFSR to return a k-bit integer
     * @param k, the number of steps desired
     * @return a k bit integer */

    public int generate(int k){
        int kBit=0;
        for(int i=0;i<k;i++){
            kBit=(2*kBit)+step();
        }
        return kBit;
    }



    public static void main(String[] args) {
        LFSR lfsr0 = new LFSR("01101000010", 9);
        StdOut.println(lfsr0);
        for (int i = 0; i < 10; i++) {
            int r = lfsr0.generate(5);
            StdOut.println(lfsr0 + " " + r);
        }
        StdOut.println(lfsr0);



    }
}
