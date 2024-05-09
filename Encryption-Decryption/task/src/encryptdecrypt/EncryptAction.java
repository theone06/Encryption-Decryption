package encryptdecrypt;

public class EncryptAction {
    /**
     * Encrypts the given input string using Unicode encryption.
     *
     * @param  input  the string to be encrypted
     * @param  offset the offset value for encryption
     * @return        the encrypted string
     */
    public String unicodeEncryption(String input, int offset) {
        int uni;
        StringBuilder builder = new StringBuilder("");
        for (char c : input.toCharArray()) {
            uni = c + offset;
            builder.append("" + (char) uni);
        }
        return builder.toString();
    }

    /**
     * Encrypts the given input string using a shift encryption.
     *
     * @param input  the string to be encrypted
     * @param shift  the shift value for encryption
     * @return       the encrypted string
     */
    public String shiftEncryption(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Decrypts the given input string using Unicode decryption.
     *
     * @param  input  the string to be decrypted
     * @param  offset the offset value for decryption
     * @return        the decrypted string
     */
    public String unicodeDecryption(String input, int offset) {
        int uni;
        StringBuilder builder = new StringBuilder("");
        for (char c : input.toCharArray()) {
            uni = c - offset;
            String s1 = "" + (char) uni;
            builder.append(s1);
        }
        return builder.toString();
    }
    /**
     * Decrypts the input text using a shift decryption algorithm with a specified shift value.
     *
     * @param  input  the text to be decrypted
     * @param  shift  the amount of shift used for decryption
     * @return        the decrypted text
     */
    public String shiftDecryption(String input, int shift) {
        return shiftEncryption(input, 26 - (shift%26));
    }
}
