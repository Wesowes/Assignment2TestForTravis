// Wesley So
// CS 410 Junit assignment
public class StringManipulation implements StringManipulationInterface {
    private String manipulatedString;
    private int count;
    @Override
    public String getString() {
        count = 0;
        return null;
    }

    @Override
    public void setString(String string) {
        manipulatedString = string;
    }
    @Override
    // used to find number of words in the manipulatedstring
    // returns number counted
    public int count() {
        if (manipulatedString == null || manipulatedString.isEmpty()) {
            count = 0;
            return count;
        } // count is 0 if nothing in manipulated string
        String[] words = manipulatedString.split("\\s+");
        // find word count by splitting by spaces
        count = words.length;
        return count;
        }


    @Override
    // removes every nth character which is stated by user
    // spacing is either left or deleted completely from string
    // depending on whether maintain spacing is true or false
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        StringBuilder newString = new StringBuilder(manipulatedString);
        String secondString = "";
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        if (n > manipulatedString.length()) {
            throw new IndexOutOfBoundsException("Choose a number smaller than length of the string");
        }
        if(n == 1 && maintainSpacing == false) {
            return secondString;
        }
        // checking for all special cases and returning appropriate string or exception

        if (maintainSpacing == true) {
            // This will replace every nth character with ' '
            for (int i = n - 1; i < manipulatedString.length(); i += n) {
                newString.setCharAt(i, ' ');
            }
        }
        // if mainSpacing is true that means that anything deleted will be a space instead,
        // used string builder to replace the character at each interval with a space

        if(maintainSpacing == false) {
            int indexStart = 0;
            int indexFinish = 0;
            for (int i = n-1; i <= manipulatedString.length(); i += n) {
               if(i + n > manipulatedString.length()) {
                   indexFinish = i + 1;
               }
               secondString += manipulatedString.substring(indexStart, i);
               indexStart = i + 1;
            }
            // if maintain space is false the new string will have a substring up to the point
            // of n which is not kept and index moves on to find the next n substring to add
            // to the new String
            secondString += manipulatedString.substring(indexFinish, manipulatedString.length());
            // in case forloop is cut off before full substring is completed, this adds the remaining substring
            // to the string
            return secondString;
        }
            return newString.toString();
    }
    @Override
    // returns the substring from index start word to index endword
    public String[] getSubStrings(int startWord, int endWord){
        if(startWord <= 0 || endWord <= 0 || endWord < startWord) {
            throw new IllegalArgumentException("Input valid start and end word index");
        }
        // looks for potential errors and gives appropriate error message

        String[] substrings = manipulatedString.split("\\s+");
        // splits substring by spaces
        int size = substrings.length;
        if(endWord > size) {
            throw new IndexOutOfBoundsException("End word is out of bounds of string words");
        }
        // looks for potential errors and gives appropriate error message
        String[] acceptedSubstrings = new String[endWord-startWord + 1];
        int index = 0;
        for(int i = startWord-1; i <= endWord-1; i++) {
            acceptedSubstrings[index] = substrings[i];
            index++;
        }
        //  adds start and end words to a new string array to be returned
        return acceptedSubstrings;
    }

    @Override
    // makes word based on already given word and indices given byt he user
    // word will be rearragned based on array given
    public String restoreString(int[] indices){
        if(manipulatedString.length() != indices.length) {
            throw new IllegalArgumentException("Please have the correct number of indexes");
        }
        // looks for potential errors and gives appropriate error message
        StringBuilder newString = new StringBuilder(manipulatedString);
        for(int i =0; i < indices.length; ++i) {
            if(indices[i] < 0 || indices[i] >= manipulatedString.length()) {
                throw new IndexOutOfBoundsException("Please input the correct indexes");
            }
            // looks for potential errors and gives appropriate error message
            else {
                newString.setCharAt(indices[i], manipulatedString.charAt(i));
                // creates new word based on changed indices
            }
        }
        return newString.toString();
    }

}
