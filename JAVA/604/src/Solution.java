
public class Solution {

	public static void main(String[] argv) {

		StringIterator iterator = new StringIterator("L15A1");
		Character a = iterator.next();
		Character b = iterator.next();
		Boolean a1 = iterator.hasNext();
//		Character c = iterator.next();

		System.out.println("End");
	}

	public static class StringIterator {

		private String compressedString;
		int count = 0;
		private int index = 0;
		private char ch;

		public StringIterator(String compressedString) {
			this.compressedString = compressedString;
		}

		public char next() {

			if(count >0){
				count--;
				return ch;
			}
			
			if(index >= compressedString.length())
				return ' ';
			
			ch = compressedString.charAt(index);
			index++;
			count = compressedString.charAt(index) - '0';
			index++;
			
		
			while ( index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
				Boolean asd = Character.isDigit(compressedString.charAt(index));
				count = count * 10 + compressedString.charAt(index) - '0';
				index++;
			}
			count--;
			return ch;
		}

		public boolean hasNext() {
			return count > 0 || index < compressedString.length();  
			
		}
	}

}
