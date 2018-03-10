package wl;

import java.util.*;
import java.io.File;
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.FileInputStream;


public class wordladder {
	public static void wladder(Set<String> wordlist1,Set<String> wordlist2) {
		boolean done = false;
		String word1;
		String word2;
		Stack<String>orig = new Stack<>();
		Stack<String>ans = new Stack<>();
		Queue<Stack<String>>ladder = new LinkedList<Stack<String>>();
		System.out.print("word #1");
		Scanner sc = new Scanner(System.in); 
		word1 = sc.nextLine();
		System.out.print("word #2");
		word2 = sc.nextLine();
		if (word1.length() != word2.length()) {
			System.out.print("The two words must be the same length.");
		}
		else if (!wordlist1.contains(word1) || !wordlist1.contains(word2)) {
			System.out.print("The two words must be found in the dictionary.");
		}
		else if (word1.equals(word2)) {
			System.out.print("The two words must be different.");
		}
		else {
			wordlist2.remove(word1);
			orig.push(word1);
			ladder.add(orig);
			while (ladder.size()!= 0 && !done) {
				Stack<String>start = ladder.poll();
				int length = word1.length();
				for (int pos = 0;pos< length;pos++) {
					String word_orig = start.peek();
					char []chs = word_orig.toCharArray();
					for (char j = 'a';j <= 'z'; j++) {
						chs[pos] =  j;
						String word_temp = new String(chs);						
						if (wordlist1.contains(word_temp) && !word_temp.equals(word_orig) && done != true) {
							if (wordlist2.contains(word_temp)) {
								if(word_temp.equals(word2)) {
									done = true;
									start.push(word2);
									ans = start;
								}
								else {
									wordlist2.remove(word_temp);
									Stack<String>stack_temp = new Stack<>();
									for (String s:start) {
										stack_temp.push(s);
									}
									stack_temp.push(word_temp);
									ladder.add(stack_temp);
								}
							}
						}
						if (done) break;
					}
					if (done) break;
				}
			}
			if (done)
			{
				System.out.print("The ladder from " + word1 + " back to " + word2 + ":\n");
				while (!ans.empty()) {
					System.out.print(ans.pop()+" ");
				}
			}
			if (!done) {
				System.out.print("No word ladder found from" + word1 + "back to" + word2 + ".\n");
			}
		}		
	}
    public static Set<String> file(String pathname) {  
    	Set<String>wordlist = new HashSet<>();
        try {
            File infile = new File(pathname);  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(infile));
            BufferedReader br = new BufferedReader(reader);  
            String line = "";  
            line = br.readLine();  
            wordlist.add(line);
            while ((line = br.readLine()) != null) {  
                wordlist.add(line);
            }
            return wordlist;
        } catch (Exception e) {  
            e.printStackTrace();
            return wordlist;
        } 
    }
    public static void main(String[] args){
        Set<String> set1 = file("src/wl/dictionary.txt");
        Set<String> set2 = file("src/wl/dictionary.txt");
        wladder(set1,set2);
    }
    
    
}