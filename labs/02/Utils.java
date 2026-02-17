public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if the pre-conditions are satistified

        // Testing pre-conditions

        if ( in == null || what == null || with == null ) {
            valid = false;
        } else if ( what.length != with.length ) {
                valid = false;
        } else {
            // Check for null elements in 'in' array
            for ( int i=0; i<in.length && valid; i++ ) {
                if ( in[i] == null ) {
                    valid = false;
                }
            }
            // Check for null elements in 'what' array
            for ( int i=0; i<what.length && valid; i++ ) {
                if ( what[i] == null ) {
                    valid = false;
                }
            }
            // Check for null elements in 'with' array
            for ( int i=0; i<with.length && valid; i++ ) {
                if ( with[i] == null ) {
                    valid = false;
                }
            }
        }

        if ( valid ) {
            out = new String[ in.length ];
            for ( int i=0; i<in.length; i++ ) {
                    out[i] = in[i]; // Copy the element
                    
                    // Check if this word should be replaced
                    for ( int j=0; j<what.length; j++ ) {
                    if ( in[i].equals( what[j] ) ) {
                        out[i] = with[j]; // Replace it
                        break; // Stop searching once found
                    }
                }
            }
        }
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}
